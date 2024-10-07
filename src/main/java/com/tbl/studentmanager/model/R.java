package com.tbl.studentmanager.model;

import lombok.Data;

@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public static Object OK(Object data) {
        R r = new R();
        r.setCode(200);
        r.setData(data);
        return r;
    }
    public static Object OK() {
        R r = new R();
        r.setCode(200);
        return r;
    }

    public static Object error(String msg) {
        R r = new R();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }
    public static Object error(int code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }


    public static Object error() {
        R r = new R();
        r.setCode(500);
        return r;
    }
}

