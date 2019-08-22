package com.kgc.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Answers {
    private Integer id;

    private String anscontent;
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ansdate;

    private Integer gid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnscontent() {
        return anscontent;
    }

    public void setAnscontent(String anscontent) {
        this.anscontent = anscontent == null ? null : anscontent.trim();
    }

    public Date getAnsdate() {
        return ansdate;
    }

    public void setAnsdate(Date ansdate) {
        this.ansdate = ansdate;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}