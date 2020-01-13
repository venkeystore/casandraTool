package com.vz.cassandraTool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vz.cassandraTool.pojo.CassandraTable;



public interface CassandraTableRepo extends JpaRepository<CassandraTable, Integer> {

	// @Query("select i from Cassandratables i where i.sourceTable = ?1")


	@Query(value = "SELECT * FROM cassandra_table c WHERE c.sourceTableId = ?1", nativeQuery = true)
	List<CassandraTable> findSourceTblId(int srcTableId);

}

