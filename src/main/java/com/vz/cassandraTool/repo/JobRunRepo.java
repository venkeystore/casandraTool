package com.vz.cassandraTool.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vz.cassandraTool.pojo.JobRun;


public interface JobRunRepo extends JpaRepository<JobRun, Integer> {

}
