package com.vz.cassandraTool.model;
// Generated Oct 14, 2019 5:20:56 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Testsuites generated by hbm2java
 */
@Entity
@Table(name = "testsuites")
public class Testsuites implements java.io.Serializable {

	private String testsuiteId;
	private Testcycles testcycles;
	private String testsuiteType;
	private String testsuiteName;
	private String testsuiteDesc;
	private String status;
	private Date createdDate;
	private Date updatedDate;
	private Date assignedDate;
	private String assignedto;
	private String createdby;
	private String updatedby;
	private String assignedby;

	public Testsuites() {
	}

	public Testsuites(String testsuiteId, Testcycles testcycles, String testsuiteType, String testsuiteName,
			String testsuiteDesc, String status, Date createdDate, String assignedto, String createdby,
			String updatedby, String assignedby) {
		this.testsuiteId = testsuiteId;
		this.testcycles = testcycles;
		this.testsuiteType = testsuiteType;
		this.testsuiteName = testsuiteName;
		this.testsuiteDesc = testsuiteDesc;
		this.status = status;
		this.createdDate = createdDate;
		this.assignedto = assignedto;
		this.createdby = createdby;
		this.updatedby = updatedby;
		this.assignedby = assignedby;
	}

	public Testsuites(String testsuiteId, Testcycles testcycles, String testsuiteType, String testsuiteName,
			String testsuiteDesc, String status, Date createdDate, Date updatedDate, Date assignedDate,
			String assignedto, String createdby, String updatedby, String assignedby) {
		this.testsuiteId = testsuiteId;
		this.testcycles = testcycles;
		this.testsuiteType = testsuiteType;
		this.testsuiteName = testsuiteName;
		this.testsuiteDesc = testsuiteDesc;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.assignedDate = assignedDate;
		this.assignedto = assignedto;
		this.createdby = createdby;
		this.updatedby = updatedby;
		this.assignedby = assignedby;
	}

	@Id

	@Column(name = "testsuite_id", unique = true, nullable = false, length = 20)
	public String getTestsuiteId() {
		return this.testsuiteId;
	}

	public void setTestsuiteId(String testsuiteId) {
		this.testsuiteId = testsuiteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "testcycle_id", nullable = false)
	public Testcycles getTestcycles() {
		return this.testcycles;
	}

	public void setTestcycles(Testcycles testcycles) {
		this.testcycles = testcycles;
	}

	@Column(name = "testsuite_type", nullable = false, length = 10)
	public String getTestsuiteType() {
		return this.testsuiteType;
	}

	public void setTestsuiteType(String testsuiteType) {
		this.testsuiteType = testsuiteType;
	}

	@Column(name = "testsuite_name", nullable = false, length = 50)
	public String getTestsuiteName() {
		return this.testsuiteName;
	}

	public void setTestsuiteName(String testsuiteName) {
		this.testsuiteName = testsuiteName;
	}

	@Column(name = "testsuite_desc", nullable = false, length = 200)
	public String getTestsuiteDesc() {
		return this.testsuiteDesc;
	}

	public void setTestsuiteDesc(String testsuiteDesc) {
		this.testsuiteDesc = testsuiteDesc;
	}

	@Column(name = "status", nullable = false, length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "assigned_date", length = 29)
	public Date getAssignedDate() {
		return this.assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	@Column(name = "assignedto", nullable = false, length = 50)
	public String getAssignedto() {
		return this.assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}

	@Column(name = "createdby", nullable = false, length = 50)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "updatedby", nullable = false, length = 50)
	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	@Column(name = "assignedby", nullable = false, length = 50)
	public String getAssignedby() {
		return this.assignedby;
	}

	public void setAssignedby(String assignedby) {
		this.assignedby = assignedby;
	}

}
