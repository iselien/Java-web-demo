package io.yovelas.model;

public class JsonBean {
    private int ret;
    private String msg;
    private Data data;

    public JsonBean() {
    }

    public JsonBean(int ret, String msg, Data data) {
        this.ret = ret;
        this.msg = msg;
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

