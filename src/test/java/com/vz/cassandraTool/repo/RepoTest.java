package com.vz.cassandraTool.repo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vz.cassandraTool.pojo.System;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RepoTest {
	@Mock
	SystemRepo systemRepo;

	@Mock
	SourceTableRepo sourceTableRepo;
	
	@Mock
	CassandraTableRepo cassandraTableRepo;


	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public final void systemRepo() {

		List<System> sysList = new ArrayList<>();
		System sys = new System(1, "DMD");
		sysList.add(sys);

		systemRepo.save(sys);
		verify(systemRepo, times(1)).save(sys);

		when(systemRepo.findAll()).thenReturn(sysList);
		systemRepo.findAll();
		verify(systemRepo, times(1)).findAll();

	}

	/*@Test
	public final void sourceTableRepo() {
		System sys = new System(1, "DMD");
		Set<JobRun> joRunSet = new HashSet<>();
		Set<CassandraTable> cassTableSet = new HashSet<>();
		SourceTable srcTable = new SourceTable(1, sys, "srcTableName", true, joRunSet, cassTableSet);
		sourceTableRepo.save(srcTable);
		verify(sourceTableRepo, times(1)).save(srcTable);

		List<SourceTable> srcTableList = new ArrayList<>();
		srcTableList.add(srcTable);
		when(sourceTableRepo.findAll()).thenReturn(srcTableList);
		sourceTableRepo.findAll();
		verify(sourceTableRepo, times(1)).findAll();
	}
	
	@Test
	public final void cassandraTableRepo() {
		System sys = new System(1, "DMD");
		Set<JobRun> joRunSet = new HashSet<>();
		Set<CassandraTable> cassTableSet = new HashSet<>();
		SourceTable srcTable = new SourceTable(1, sys, "srcTableName", true, joRunSet, cassTableSet);
		CassandraTable cassTable = new CassandraTable(1, srcTable, "srcTableName", "cntlFile", joRunSet);
		cassandraTableRepo.save(cassTable);
		verify(cassandraTableRepo, times(1)).save(cassTable);

		List<CassandraTable> cassTableList = new ArrayList<>();
		cassTableList.add(cassTable);
		when(cassandraTableRepo.findAll()).thenReturn(cassTableList);
		cassandraTableRepo.findAll();
		verify(cassandraTableRepo, times(1)).findAll();
	}*/
}
