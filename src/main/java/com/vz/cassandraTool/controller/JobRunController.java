package com.vz.cassandraTool.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vz.cassandraTool.pojo.JobRun;
import com.vz.cassandraTool.service.JobRunService;

@CrossOrigin
@RestController
public class JobRunController {
	@Autowired
	JobRunService jobRunService;

	@PostMapping("/runInitJob")
	public ResponseEntity<String> runInitJob(@RequestBody JobRun migrationData) throws JSONException {
		List<JobRun> runInitJob = jobRunService.runInitJob();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("runInitJob", runInitJob);

		jsonObj.put("status", 200);
		jsonObj.put("message", "Success");
		return ResponseEntity.ok(jsonObj.toString());
	}

}
