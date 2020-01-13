package com.vz.cassandraTool.controller;

import java.util.Collection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vz.cassandraTool.dto.CassandratablesDto;
import com.vz.cassandraTool.dto.SourceTableArrayDto;
import com.vz.cassandraTool.dto.SourceTableDto;
import com.vz.cassandraTool.dto.SystemDto;
import com.vz.cassandraTool.service.CassandraTableService;
import com.vz.cassandraTool.service.JobRunService;
import com.vz.cassandraTool.service.SourceTableService;
import com.vz.cassandraTool.service.SystemService;

@CrossOrigin
@RestController
public class LoadTablesController {
	@Autowired
	JobRunService jobRunService;

	@Autowired
	SystemService systemService;

	@Autowired
	SourceTableService sourceTableService;

	@Autowired
	CassandraTableService cassandraTableService;

	@GetMapping("/systems")
	public ResponseEntity<String> systems() throws JSONException {

		List<SystemDto> systemsList = systemService.getSystems();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("systems", systemsList);
		jsonObj.put("status", 200);
		jsonObj.put("message", "Success");
		return ResponseEntity.ok(jsonObj.toString());

	}

	@PostMapping("/sourceTables")
	public ResponseEntity<String> sourceTables(@RequestBody SystemDto systemDto) throws JSONException {

		int systemId = systemDto.getSystemId();
		List<SourceTableDto> sourceTables = sourceTableService.sourceTables(systemId);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("sourceTables", sourceTables);
		jsonObj.put("status", 200);
		jsonObj.put("message", "Success");
		return ResponseEntity.ok(jsonObj.toString());
	}

	@PostMapping("/cassandraTables")
	public ResponseEntity<String> cassandraTables(@RequestBody SourceTableArrayDto sourceTableDto)
			throws JSONException {

		// SourceTable source = sourceTable.
		int[] srcTableId = sourceTableDto.getSourceTableId();
		Collection<CassandratablesDto> cassandraTables = cassandraTableService.cassandraTables(srcTableId);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("cassandraTables", cassandraTables);
		jsonObj.put("status", 200);
		jsonObj.put("message", "Success");
		return ResponseEntity.ok(jsonObj.toString());
	}

}
