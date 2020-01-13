package com.vz.cassandraTool.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vz.cassandraTool.pojo.ErrorLog;

public interface ErrorLogRepo extends JpaRepository<ErrorLog, String> {

}
