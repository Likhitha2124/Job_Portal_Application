package com.likhitha.jobportal.repository;

import com.likhitha.jobportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCaseOrJobTypeContainingIgnoreCase(String title, String location, String jobType);
}
