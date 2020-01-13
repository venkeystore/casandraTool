package com.vz.cassandraTool.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vz.cassandraTool.pojo.CassandraTable;
import com.vz.cassandraTool.pojo.FileProcess;

public interface FileProcessRepo  extends JpaRepository<FileProcess, Integer>  {

}
