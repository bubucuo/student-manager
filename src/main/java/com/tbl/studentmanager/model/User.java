package com.tbl.studentmanager.model;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String name;
    private String password;
    private Integer rollId;
    private String email;
    private Integer gender;
    private String dob;
    private String address;

    private Integer page;
    private Integer size;
}
