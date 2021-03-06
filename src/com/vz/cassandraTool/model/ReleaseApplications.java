package com.vz.cassandraTool.model;
// Generated Oct 14, 2019 5:20:56 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ReleaseApplications generated by hbm2java
 */
@Entity
@Table(name = "release_applications")
public class ReleaseApplications implements java.io.Serializable {

	private String releaseAppId;
	private String applicationId;
	private String releaseId;
	private Date createdDate;
	private Date updatedDate;
	private String status;

	public ReleaseApplications() {
	}

	public ReleaseApplications(String releaseAppId, String applicationId, String releaseId, Date createdDate,
			String status) {
		this.releaseAppId = releaseAppId;
		this.applicationId = applicationId;
		this.releaseId = releaseId;
		this.createdDate = createdDate;
		this.status = status;
	}

	public ReleaseApplications(String releaseAppId, String applicationId, String releaseId, Date createdDate,
			Date updatedDate, String status) {
		this.releaseAppId = releaseAppId;
		this.applicationId = applicationId;
		this.releaseId = releaseId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.status = status;
	}

	@Id

	@Column(name = "release_app_id", unique = true, nullable = false, length = 20)
	public String getReleaseAppId() {
		return this.releaseAppId;
	}

	public void setReleaseAppId(String releaseAppId) {
		this.releaseAppId = releaseAppId;
	}

	@Column(name = "application_id", nullable = false, length = 20)
	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "release_id", nullable = false, length = 20)
	public String getReleaseId() {
		return this.releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
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

	@Column(name = "status", nullable = false, length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
