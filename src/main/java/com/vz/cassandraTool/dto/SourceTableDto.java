package com.vz.cassandraTool.dto;

public class SourceTableDto {

	private int sourceTableId;
	private String sourceTableName;
	private boolean refernece;

	public boolean isRefernece() {
		return refernece;
	}

	public void setRefernece(boolean refernece) {
		this.refernece = refernece;
	}

	public int getSourceTableId() {
		return sourceTableId;
	}

	public void setSourceTableId(int sourceTableId) {
		this.sourceTableId = sourceTableId;
	}

	public String getSourceTableName() {
		return sourceTableName;
	}

	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}

}
