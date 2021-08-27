package com.example.demo.models;

public class TaskDto {

	private String name;
	private String url;
	private String typetaskaction;
	private String cronexp;
	private String timerange;
	private String typetime;
	private String dateExecution;
	private String response;
	private String status;

	public TaskDto() {

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypetaskaction() {
		return typetaskaction;
	}

	public void setTypetaskaction(String typetaskaction) {
		this.typetaskaction = typetaskaction;
	}

	public String getCronexp() {
		return cronexp;
	}

	public void setCronexp(String cronexp) {
		this.cronexp = cronexp;
	}

	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timerange) {
		this.timerange = timerange;
	}

	public String getTypetime() {
		return typetime;
	}

	public void setTypetime(String typetime) {
		this.typetime = typetime;
	}

	public String getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(String dateExecution) {
		this.dateExecution = dateExecution;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
