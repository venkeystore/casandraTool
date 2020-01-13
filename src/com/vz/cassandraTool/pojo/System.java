package com.vz.cassandraTool.pojo;
// Generated Nov 12, 2019 12:28:09 PM by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * System generated by hbm2java
 */
@Entity
@Table(name = "system", catalog = "cassandra_automation1")
public class System implements java.io.Serializable {

	private int systemId;
	private String systemName;
	private Set<SourceTable> sourceTables = new HashSet<SourceTable>(0);
	private Set<JobRun> jobRuns = new HashSet<JobRun>(0);

	public System() {
	}

	public System(int systemId, String systemName) {
		this.systemId = systemId;
		this.systemName = systemName;
	}

	public System(int systemId, String systemName, Set<SourceTable> sourceTables, Set<JobRun> jobRuns) {
		this.systemId = systemId;
		this.systemName = systemName;
		this.sourceTables = sourceTables;
		this.jobRuns = jobRuns;
	}

	@Id

	@Column(name = "systemId", unique = true, nullable = false)
	public int getSystemId() {
		return this.systemId;
	}

	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}

	@Column(name = "systemName", nullable = false, length = 45)
	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "system")
	public Set<SourceTable> getSourceTables() {
		return this.sourceTables;
	}

	public void setSourceTables(Set<SourceTable> sourceTables) {
		this.sourceTables = sourceTables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "system")
	public Set<JobRun> getJobRuns() {
		return this.jobRuns;
	}

	public void setJobRuns(Set<JobRun> jobRuns) {
		this.jobRuns = jobRuns;
	}

}
