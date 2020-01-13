package com.vz.cassandraTool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vz.cassandraTool.dto.SourceTableDto;
import com.vz.cassandraTool.pojo.SourceTable;
import com.vz.cassandraTool.repo.SourceTableRepo;

@Service
public class SourceTableService {
	@Autowired
	SourceTableRepo sourceTableRepo;

	// To get all sourceTables names from respective vision,dmd,ecpd etc.
	public List<SourceTableDto> sourceTables(int systemId) {

		List<SourceTable> srcTables = sourceTableRepo.findSourceTblId(systemId);

		List<SourceTableDto> srcTableDtoList = new ArrayList<>();
		for (SourceTable sys : srcTables) {
			SourceTableDto sysdto = new SourceTableDto();
			sysdto.setSourceTableId(sys.getSourceTableId());
			sysdto.setSourceTableName(sys.getSourceTableName());
			sysdto.setRefernece(sys.getReference());
			srcTableDtoList.add(sysdto);
		}
		return srcTableDtoList;
	}
}
