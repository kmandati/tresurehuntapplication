package com.example.tesco.tresurehunt.dto;

import java.util.List;

public class TresurehuntResponse {
	
	private String status;
	
	private List<String> cellsVisisted;
	
	private String statusMessage;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<String> getCellsVisisted() {
		return cellsVisisted;
	}

	public void setCellsVisisted(List<String> cellsVisisted) {
		this.cellsVisisted = cellsVisisted;
	}
	
}
