const API='';
function userId(){return localStorage.getItem('userId')}
function role(){return localStorage.getItem('role')}
function logout(){localStorage.clear()}
function checkLogin(){if(!userId()) location.href='index.html'}
function checkAdmin(){if(role()!=='ADMIN') location.href='index.html'}
async function register(){
 const u={fullName:val('fullName'),email:val('email'),password:val('password')};
 const r=await fetch(API+'/api/auth/register',{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(u)});
 const d=await r.json(); alert(d.message); if(d.success) location.href='index.html';
}
async function login(){
 try{const u={email:val('email'),password:val('password')};
 const r=await fetch(API+'/api/auth/login',{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(u)});
 const d=await r.json(); if(!d.success){alert(d.message);return}
 localStorage.setItem('userId',d.userId); localStorage.setItem('role',d.role); localStorage.setItem('name',d.name||'');
 location.href=d.role==='ADMIN'?'admin.html':'dashboard.html';}catch(e){alert('Server not running or error: '+e.message)}
}
function val(id){return document.getElementById(id).value}
async function loadJobs(){const r=await fetch(API+'/api/jobs'); displayJobs(await r.json())}
async function searchJobs(){const k=val('keyword'); const r=await fetch(API+'/api/jobs/search?keyword='+encodeURIComponent(k)); displayJobs(await r.json())}
function displayJobs(jobs){const el=document.getElementById('jobs'); el.innerHTML=''; jobs.forEach(j=>el.innerHTML+=`<div class="card"><h2>${j.title}</h2><p><b>${j.company}</b> - ${j.location}</p><p>${j.jobType} | ${j.experience} | ${j.salary}</p><p>${j.description}</p><button onclick="apply(${j.id})">Apply Now</button></div>`)}
function apply(id){localStorage.setItem('jobId',id);location.href='apply.html'}
async function submitApplication(){
 const fd=new FormData(); fd.append('userId',userId()); fd.append('jobId',localStorage.getItem('jobId')); fd.append('applicantName',val('applicantName')); fd.append('phone',val('phone')); fd.append('email',val('email')); fd.append('resume',document.getElementById('resume').files[0]);
 await fetch(API+'/api/applications/apply',{method:'POST',body:fd}); location.href='success.html';
}
async function loadMyApplications(){const r=await fetch(API+'/api/applications/my/'+userId()); fillApps('apps',await r.json())}
async function loadAllApplications(){const r=await fetch(API+'/api/applications'); fillApps('allApps',await r.json())}
function fillApps(id,apps){const el=document.getElementById(id); el.innerHTML=''; apps.forEach(a=>el.innerHTML+=`<tr><td>${a.id}</td><td>${a.jobTitle}</td><td>${a.applicantName}</td><td>${a.email}</td><td>${a.phone}</td><td>${a.resumeFileName}</td><td>${(a.appliedAt||'').replace('T',' ')}</td></tr>`)}
async function loadAdminJobs(){const r=await fetch(API+'/api/jobs'); const jobs=await r.json(); const el=document.getElementById('adminJobs'); el.innerHTML=''; jobs.forEach(j=>el.innerHTML+=`<div class="card"><h2>${j.title}</h2><p>${j.company} | ${j.location} | ${j.jobType}</p><button onclick='editJob(${JSON.stringify(j)})'>Edit</button> <button class="danger" onclick="deleteJob(${j.id})">Delete</button></div>`)}
function editJob(j){['jobId','title','company','location','jobType','experience','salary','description'].forEach(k=>{document.getElementById(k).value=k==='jobId'?j.id:j[k]||''}); window.scrollTo(0,0)}
function clearJobForm(){['jobId','title','company','location','jobType','experience','salary','description'].forEach(k=>document.getElementById(k).value='')}
async function saveJob(){const j={title:val('title'),company:val('company'),location:val('location'),jobType:val('jobType'),experience:val('experience'),salary:val('salary'),description:val('description')}; const id=val('jobId'); await fetch(API+'/api/jobs'+(id?'/'+id:''),{method:id?'PUT':'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(j)}); clearJobForm(); loadAdminJobs();}
async function deleteJob(id){if(confirm('Delete this job?')){await fetch(API+'/api/jobs/'+id,{method:'DELETE'});loadAdminJobs()}}
