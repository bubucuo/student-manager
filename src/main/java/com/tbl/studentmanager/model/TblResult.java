package com.tbl.studentmanager.model;

import lombok.Data;

import java.util.Date;

@Data
public class TblResult {
    private Integer id;
    private String userId;
    private Integer subjectId;
    private Integer subjectName;
    private Integer subjectCode;
    private Integer courseId;
    private Integer courseName;
    private Integer courseNameNumber;
    private Integer marks;

    private Date PostingDate;
    private Date updationDate;

    private Integer page;
    private Integer size;

}
