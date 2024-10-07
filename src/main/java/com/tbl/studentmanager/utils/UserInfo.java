package com.tbl.studentmanager.utils;

import lombok.Data;

@Data
public class UserInfo {
    private String sessionId;
    private String userId;
    private Integer rollId;

    public UserInfo(String sessionId, String userId, Integer rollId){
        this.sessionId = sessionId;
        this.userId = userId;
        this.rollId = rollId;
    }
}
