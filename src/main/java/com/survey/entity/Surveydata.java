package com.survey.entity;

public class Surveydata {
    private Integer id;

    private String content;

    private String bcheck;

    private String btype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBcheck() {
        return bcheck;
    }

    public void setBcheck(String bcheck) {
        this.bcheck = bcheck == null ? null : bcheck.trim();
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype == null ? null : btype.trim();
    }

	@Override
	public String toString() {
		return "Surveydata [id=" + id + ", content=" + content + ", bcheck=" + bcheck + ", btype=" + btype + "]";
	}
}