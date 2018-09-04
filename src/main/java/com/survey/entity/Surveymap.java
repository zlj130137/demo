package com.survey.entity;

public class Surveymap {
 
	private Integer id;

    private String bkey;

    private String bvalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBkey() {
        return bkey;
    }

    public void setBkey(String bkey) {
        this.bkey = bkey == null ? null : bkey.trim();
    }

    public String getBvalue() {
        return bvalue;
    }

    public void setBvalue(String bvalue) {
        this.bvalue = bvalue == null ? null : bvalue.trim();
    }
    @Override
  	public String toString() {
  		return "Surveymap [id=" + id + ", bkey=" + bkey + ", bvalue=" + bvalue + "]";
  	}
}