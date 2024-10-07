package com.tbl.studentmanager.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FeeModel {
    private BigDecimal fee;
    private Integer feesStatus;
    private Integer scolarshipStatus;
    private String userId;

}
