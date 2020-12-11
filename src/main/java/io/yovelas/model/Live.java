package io.yovelas.model;

public class Live {
    private String liveid;
    private String stream;

    public Live() {
    }

    public Live(String liveid, String stream) {
        this.liveid = liveid;
        this.stream = stream;
    }

    public String getLiveid() {
        return liveid;
    }

    public void setLiveid(String liveid) {
        this.liveid = liveid;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Live{" +
                "liveid='" + liveid + '\'' +
                ", stream='" + stream + '\'' +
                '}';
    }
}
