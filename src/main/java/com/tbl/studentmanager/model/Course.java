package com.tbl.studentmanager.model;

import lombok.Data;

import java.util.Date;

@Data
public class Course {

    private Integer id;
    private String courseName;
    private String courseNameNumber;
    private String section;
    private Date createDate;
    private Date updateDate;
}
