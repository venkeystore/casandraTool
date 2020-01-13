package com.vz.cassandraTool.dto;

public class JobRunDto {
	private Integer systemId;
	private String jobRunId;
	private Integer cassandraTableId;
	//private int[] cassandraTableId;
	private int sourceTableId;
	//private int[] sourceTableId;
	private String environmentName;
	private String instance;
	private String status;
	private String errormsg;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public Integer getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(Integer fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

	private String feedFileName;
	private Byte isRecon;
	private Integer fileProcessId;

	

	public Integer getCassandraTableId() {
		return cassandraTableId;
	}

	public void setCassandraTableId(Integer cassandraTableId) {
		this.cassandraTableId = cassandraTableId;
	}

	public int getSourceTableId() {
		return sourceTableId;
	}

	public void setSourceTableId(int sourceTableId) {
		this.sourceTableId = sourceTableId;
	}

	public String getJobRunId() {
		return jobRunId;
	}

	public void setJobRunId(String jobRunId) {
		this.jobRunId = jobRunId;
	}

	/*public Integer getCassandraTableId() {
		return cassandraTableId;
	}

	public void setCassandraTableId(Integer cassandraTableId) {
		this.cassandraTableId = cassandraTableId;
	}*/

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	/*public Integer getSourceTableId() {
		return sourceTableId;
	}

	public void setSourceTableId(Integer sourceTableId) {
		this.sourceTableId = sourceTableId;
	}
*/
	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getFeedFileName() {
		return feedFileName;
	}

	public void setFeedFileName(String feedFileName) {
		this.feedFileName = feedFileName;
	}

	public Byte getIsRecon() {
		return isRecon;
	}

	public void setIsRecon(Byte isRecon) {
		this.isRecon = isRecon;
	}

	@Override
	public String toString() {
		return "JobRunDto [systemId=" + systemId + ", jobRunId=" + jobRunId + ", cassandraTableId=" + cassandraTableId
				+ ", sourceTableId=" + sourceTableId + ", environmentName=" + environmentName + ", instance=" + instance
				+ ", status=" + status + ", errormsg=" + errormsg + ", feedFileName=" + feedFileName + ", isRecon="
				+ isRecon + ", fileProcessId=" + fileProcessId + "]";
	}
	
}
