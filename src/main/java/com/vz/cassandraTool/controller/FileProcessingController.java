package com.vz.cassandraTool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vz.cassandraTool.dto.JobRunDto;
import com.vz.cassandraTool.pojo.ErrorLog;
import com.vz.cassandraTool.pojo.FileProcess;
import com.vz.cassandraTool.pojo.JobRun;
import com.vz.cassandraTool.repo.ErrorLogRepo;
import com.vz.cassandraTool.repo.FileProcessRepo;
import com.vz.cassandraTool.service.FileProcessingService;

@CrossOrigin
@RestController
public class FileProcessingController {
	@Autowired
	ErrorLogRepo errorLogRepo;
	@Autowired
	FileProcessRepo fileProcessRepo;
	@Autowired
	FileProcessingService fileProcessingService;
	@PostMapping("/processFile")
	public ResponseEntity<String> processInitFile(@RequestBody JobRun  migrationData) throws JSONException, InterruptedException, ExecutionException {
		FileProcess fileprocess=new FileProcess();
		ErrorLog errLog=new ErrorLog();
		int jobRunId = migrationData.getJobRunId();
		fileprocess.setJobRun(migrationData);;
		fileprocess.setFileProcessId(100);
		fileprocess.setStatus("inProgress");
		fileProcessRepo.save(fileprocess);
		String processInitFile = fileProcessingService.processInitFile(migrationData);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("processInitFileExitStatus", "InProgress");
		jsonObj.put("Linuxstatus", processInitFile);
		if(processInitFile.trim().contentEquals("0")) {
		jsonObj.put("message", "Success");
		jsonObj.put("statuscode", 200);
		}
		else if(processInitFile.trim().contentEquals("255")) {
			jsonObj.put("message", "Connection timed out");
			errLog.setErrorName("connection timedout");
		    jsonObj.put("statuscode",500);
		    errorLogRepo.save(errLog);
		}
		else {
			jsonObj.put("message", "Failed");
			errLog.setErrorName("Failed");
			jsonObj.put("statuscode", 417);
			errLog.setErrorName("417");
			errorLogRepo.save(errLog);
		}
		if(processInitFile.equals("0")) {
			fileprocess.setStatus("success");
			}else  {
			fileprocess.setStatus("failed");
		}fileProcessRepo.save(fileprocess);
		
		return ResponseEntity.ok(jsonObj.toString());
	}
	@RequestMapping("/getProcessingRequests")
	public HashMap<Integer, FileProcess> getAllProcessRequests(){
		HashMap<Integer, FileProcess> map=new HashMap<>();
		List<FileProcess> fileProcessList = fileProcessRepo.findAll();
	    List<ErrorLog> errorLogList = errorLogRepo.findAll();
		List<JobRun> collect = fileProcessList.stream().map(FileProcess::getJobRun).collect(Collectors.toList());
		System.out.println(fileProcessList.size());
		  List<JobRunDto> requestData =
		 fileProcessingService.getRequestData(fileProcessList);
		  System.out.println(requestData);
		/*
		 * for(FileProcess fileProcess:fileProcessList) {
		 * map.put(fileProcess.getFileProcessId(), fileProcess); }
		 */
		return map;
	}
}
