package io.yovelas.model;

import java.util.Arrays;

public class Data {
    private int code;
    private String msg;
    private String info;

    public Data() {
    }

    public Data(int code, String msg, String info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Data{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}


