package com.vz.cassandraTool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vz.cassandraTool.pojo.SourceTable;



public interface SourceTableRepo extends JpaRepository<SourceTable, Integer> {

	@Query(value = "SELECT * FROM source_table c WHERE c.systemId = ?1", nativeQuery = true)
	List<SourceTable> findSourceTblId(int systemId);
	


}
