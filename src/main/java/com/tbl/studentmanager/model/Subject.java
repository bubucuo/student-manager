package com.tbl.studentmanager.model;

import lombok.Data;

import java.util.Date;

@Data
public class Subject {
    private Integer id;
    private String subjectName;
    private String subjectCode;
    private Date createDate;
    private Date updateDate;
}
