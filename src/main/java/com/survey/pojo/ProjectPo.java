package com.survey.pojo;

import java.util.List;

import com.survey.entity.Surveymap;

public class ProjectPo {
	private int id;
	private String content;
	private List<Surveymap> bcheck;
	private String btype;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Surveymap> getBcheck() {
		return bcheck;
	}
	public void setBcheck(List<Surveymap> bcheck) {
		this.bcheck = bcheck;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	@Override
	public String toString() {
		return "ProjectPo [id=" + id + ", content=" + content + ", bcheck=" + bcheck + ", btype=" + btype + "]";
	}

}
