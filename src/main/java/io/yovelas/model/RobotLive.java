package io.yovelas.model;

public class RobotLive {
    private Live[] live;
    private Robot[] robot;

    public RobotLive() {
    }

    public RobotLive(Live[] live, Robot[] robot) {
        this.live = live;
        this.robot = robot;
    }

    public Live[] getLive() {
        return live;
    }

    public void setLive(Live[] live) {
        this.live = live;
    }

    public Robot[] getRobot() {
        return robot;
    }

    public void setRobot(Robot[] robot) {
        this.robot = robot;
    }

    @Override
    public String toString() {
        return "RobotLive{" +
                "live=" + live +
                ", robot=" + robot +
                '}';
    }
}
