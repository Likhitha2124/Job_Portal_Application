package com.likhitha.jobportal.controller;

import com.likhitha.jobportal.entity.Job;
import com.likhitha.jobportal.repository.JobRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobController {
    private final JobRepository jobRepository;
    public JobController(JobRepository jobRepository) { this.jobRepository = jobRepository; }
    @GetMapping public List<Job> all() { return jobRepository.findAll(); }
    @PostMapping public Job create(@RequestBody Job job) { return jobRepository.save(job); }
    @GetMapping("/{id}") public Job get(@PathVariable Long id) { return jobRepository.findById(id).orElseThrow(); }
    @PutMapping("/{id}") public Job update(@PathVariable Long id, @RequestBody Job j) {
        Job job = jobRepository.findById(id).orElseThrow();
        job.setTitle(j.getTitle()); job.setCompany(j.getCompany()); job.setLocation(j.getLocation()); job.setJobType(j.getJobType());
        job.setExperience(j.getExperience()); job.setSalary(j.getSalary()); job.setDescription(j.getDescription());
        return jobRepository.save(job);
    }
    @DeleteMapping("/{id}") public String delete(@PathVariable Long id) { jobRepository.deleteById(id); return "Job deleted successfully"; }
    @GetMapping("/search") public List<Job> search(@RequestParam String keyword) {
        return jobRepository.findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCaseOrJobTypeContainingIgnoreCase(keyword, keyword, keyword);
    }
}
