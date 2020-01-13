package com.vz.cassandraTool.dto;

public class JobRunDTO1 {

	private String jobRunId;
	
	private int[] cassandraTableId;
	//private Integer cassandraTableId;
	private Integer systemId;
	
	private int[] sourceTableId;
	
	//private Integer sourceTableId;
	private String environmentName;
	private String instance;
	private String frequency;
	private String feedFileName;
	private Byte isRecon;
	
	

	public int[] getCassandraTableId() {
		return cassandraTableId;
	}

	public void setCassandraTableId(int[] cassandraTableId) {
		this.cassandraTableId = cassandraTableId;
	}

	public int[] getSourceTableId() {
		return sourceTableId;
	}

	public void setSourceTableId(int[] sourceTableId) {
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

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
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
}
