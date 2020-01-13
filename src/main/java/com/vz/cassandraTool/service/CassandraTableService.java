package com.vz.cassandraTool.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vz.cassandraTool.dto.CassandratablesDto;
import com.vz.cassandraTool.pojo.CassandraTable;
import com.vz.cassandraTool.repo.CassandraTableRepo;

@Service
public class CassandraTableService {
	@Autowired
	CassandraTableRepo cassandraTableRepo;

	// To get all sourceTables names from selected respective vision,dmd,ecpd etc.
	public Collection<CassandratablesDto> cassandraTables(int[] srcTableId) {

		// array of srcTableId
		// iterate array and find cassandra tables

		Set<CassandratablesDto> cassTableDtoList = new HashSet<>();
		for (int id : srcTableId) {
			List<CassandraTable> cassTables = cassandraTableRepo.findSourceTblId(id);
			for (CassandraTable sys : cassTables) {
				CassandratablesDto sysdto = new CassandratablesDto();
				sysdto.setCassandraTableId(sys.getCassandraTableId());
				sysdto.setCassandraTableName(sys.getCassandraTableName());
				cassTableDtoList.add(sysdto);
			}
		}

		// unique table only
		Collection<CassandratablesDto> uniqueCassandraTables = cassTableDtoList.stream()
				.<Map<Integer, CassandratablesDto>>collect(HashMap::new, (m, e) -> m.put(e.getCassandraTableId(), e),
						Map::putAll)
				.values();

		return uniqueCassandraTables;

	}

}
