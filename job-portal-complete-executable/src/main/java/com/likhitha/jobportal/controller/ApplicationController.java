package com.likhitha.jobportal.controller;

import com.likhitha.jobportal.entity.Job;
import com.likhitha.jobportal.entity.JobApplication;
import com.likhitha.jobportal.repository.JobApplicationRepository;
import com.likhitha.jobportal.repository.JobRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin("*")
public class ApplicationController {
    private final JobApplicationRepository appRepo;
    private final JobRepository jobRepo;
    public ApplicationController(JobApplicationRepository appRepo, JobRepository jobRepo) { this.appRepo = appRepo; this.jobRepo = jobRepo; }

    @PostMapping("/apply")
    public String apply(@RequestParam Long userId, @RequestParam Long jobId, @RequestParam String applicantName,
                        @RequestParam String phone, @RequestParam String email, @RequestParam MultipartFile resume) throws IOException {
        String uploadDir = System.getProperty("user.dir") + File.separator + "uploads" + File.separator;
        File folder = new File(uploadDir); if (!folder.exists()) folder.mkdirs();
        String fileName = System.currentTimeMillis() + "_" + resume.getOriginalFilename();
        resume.transferTo(new File(uploadDir + fileName));
        Job job = jobRepo.findById(jobId).orElseThrow();
        JobApplication a = new JobApplication();
        a.setUserId(userId); a.setJobId(jobId); a.setJobTitle(job.getTitle()); a.setApplicantName(applicantName);
        a.setPhone(phone); a.setEmail(email); a.setResumeFileName(fileName);
        appRepo.save(a);
        return "Submitted Successfully. We will contact you for further details through your email. Thank you.";
    }
    @GetMapping public List<JobApplication> all() { return appRepo.findAll(); }
    @GetMapping("/my/{userId}") public List<JobApplication> my(@PathVariable Long userId) { return appRepo.findByUserId(userId); }
}
