package com.vz.cassandraTool.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.vz.cassandraTool.dto.ErrorLogDto;
import com.vz.cassandraTool.dto.JobRunDto;
import com.vz.cassandraTool.pojo.FileProcess;
import com.vz.cassandraTool.pojo.JobRun;
import com.vz.cassandraTool.pojo.SourceTable;
import com.vz.cassandraTool.repo.SourceTableRepo;

@Service
public class FileProcessingService {
	@Autowired
	SourceTableRepo sourceTable;

	@Value("${T1.hostname}")
	String t1HostName;
	@Value("${T1.userName}")
	String t1UserName;
	@Value("${T1.password}")
	String t1Password;
	@Value("${T1.hostname}")
	String t2HostName;
	@Value("${T2.userName}")
	String t2UserName;
	@Value("${T2.password}")
	String t2Password;
	@Value("${T3.hostName}")
	String t3HostName;
	@Value("${T3.userName}")
	String t3UserName;
	@Value("${T2.userName}")
	String t3Password;
	@Value("${T4.hostName}")
	String t4HostName;
	@Value("${T4.userName}")
	String t4UserName;
	@Value("${T4.userName}")
	String t4Password;
	@Value("${loaderServer1}")
	String loaderServer1;
	@Value("${loaderServer2}")
	String loaderServer2;

	public String processInitFile(JobRun jobRun) {

		String instance = jobRun.getInstance();
		String environment = jobRun.getEnvironmentName();
		String hostName = "";
		String userName = "";
		String password = "";
		String response = null;
		String loaderServer = null;
		String confFileName = "";
		// to find the recon filename
		String command = null;
		List<SourceTable> findSourceTblId = sourceTable.findSourceTblId(jobRun.getSystem().getSystemId());

		Optional<SourceTable> findFirst = findSourceTblId.stream()
				.filter(x -> x.getSourceTableId() == x.getSourceTableId()).findFirst();

		if (findFirst.isPresent()) {
			confFileName = findFirst.get().getConfFileName().trim();
		}

		Calendar cal = Calendar.getInstance();
		Date today = Calendar.getInstance().getTime();
		int date = cal.get(Calendar.DAY_OF_MONTH);
		String day = today.toString().substring(0, 3);
		switch (environment) {
		case "T1":
			hostName = t1HostName;
			userName = t1UserName;
			password = t1Password;
			loaderServer = loaderServer1;
			break;
		case "T2":
			hostName = t2HostName;
			userName = t2UserName;
			password = t2Password;
			loaderServer = loaderServer1;
			break;
		case "T3":
			hostName = t3HostName;
			userName = t3UserName;
			password = t3Password;
			loaderServer = loaderServer1;
			break;
		case "T4":
			hostName = t4HostName;
			userName = t4UserName;
			password = t4Password;
			loaderServer = loaderServer1;
			break;
		default:
			break;
		}

		if (jobRun.getIsRecon() == 1) {

			if (jobRun.getFrequency().equalsIgnoreCase("WEEKLY")) {
				command = "sh recon.sh " + instance + " " + jobRun.getFrequency() + " " + confFileName + " "
						+ jobRun.getSystem().getSystemId();
			} else if (jobRun.getFrequency().equalsIgnoreCase("DAILY")) {
				command = "sh recon.sh " + instance + " " + jobRun.getFrequency() + " " + confFileName + " " + day + " "
						+ jobRun.getSystem().getSystemId();
			} else {
				command = "sh recon.sh " + instance + " " + jobRun.getFrequency() + " " + confFileName + " " + date
						+ " " + jobRun.getSystem().getSystemId();
			}
		} else {
			command = "sh init.sh " + "hari@" + loaderServer + " " + instance + " " + environment;
		}
		response = runScript(userName, password, hostName, command);
		return response;
	}

	private String runScript(String userName, String password, String hostName, String command) {

		String response = null;
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(userName, hostName.trim(), 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);
			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					response = String.valueOf(channel.getExitStatus());
					return response;
				}
				sleep();
			}
		} catch (com.jcraft.jsch.JSchException e) {
			System.err.println("Connection timed out: connect");
			response = "Connection timed out: connect";
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<JobRunDto> getRequestData(List<FileProcess> findAll){
		List<JobRunDto> list=new ArrayList<JobRunDto>();
		for(FileProcess fileData:findAll) {
			JobRunDto jobrun=new JobRunDto();
			ErrorLogDto errLogDto=new ErrorLogDto();
			jobrun.setCassandraTableId(fileData.getJobRun().getCassandraTable().getCassandraTableId());
			jobrun.setSourceTableId(fileData.getJobRun().getSourceTable().getSourceTableId());
			jobrun.setFileProcessId(fileData.getFileProcessId());
			jobrun.setSystemId(fileData.getJobRun().getSystem().getSystemId());
			jobrun.setEnvironmentName(fileData.getJobRun().getEnvironmentName());
			jobrun.setInstance(fileData.getJobRun().getInstance());
			jobrun.setStatus(fileData.getStatus());
			if(fileData.getErrorLog()!=null) {
			if(!(fileData.getStatus().equals("0"))){
				jobrun.setErrormsg(fileData.getErrorLog().getErrorName());
			}
			}
			list.add(jobrun);
		}
		return list;
		
	}
}
