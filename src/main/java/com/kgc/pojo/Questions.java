package com.kgc.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Questions {
    private Integer id;

    private String title;

    private String detaidesc;

    private Integer answercount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastmodified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetaidesc() {
        return detaidesc;
    }

    public void setDetaidesc(String detaidesc) {
        this.detaidesc = detaidesc == null ? null : detaidesc.trim();
    }

    public Integer getAnswercount() {
        return answercount;
    }

    public void setAnswercount(Integer answercount) {
        this.answercount = answercount;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }
}