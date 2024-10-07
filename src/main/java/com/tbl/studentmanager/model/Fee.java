package com.tbl.studentmanager.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Fee {
    private Integer id;
    private BigDecimal fee;
    private Integer feesStatus;
    private Integer scolarshipStatus;
    private String userId;
    private Integer page;
    private Integer size;
}
