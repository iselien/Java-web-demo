package io.yovelas.model;

public class Robot {

    private String avatar;
    private String id;
    private String token;
    private String user_nicename;

    public Robot() {
    }

    public Robot(String avatar, String id, String token, String user_nicename) {
        this.avatar = avatar;
        this.id = id;
        this.token = token;
        this.user_nicename = user_nicename;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_nicename() {
        return user_nicename;
    }

    public void setUser_nicename(String user_nicename) {
        this.user_nicename = user_nicename;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "avatar='" + avatar + '\'' +
                ", id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", user_nicename='" + user_nicename + '\'' +
                '}';
    }
}
