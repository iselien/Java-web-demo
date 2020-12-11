package io.yovelas;

import io.yovelas.model.Live;
import io.yovelas.model.Robot;
import io.yovelas.model.RobotLive;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * Spring Boot Starter
 *
 */

@RestController
@SpringBootApplication
public class App {


    @RequestMapping("/")
    public String home(){
        return "hello";
    }

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
        App app = new App();
        HttpClient.getInstance().init();

        while(true){
            RobotLive robotLive = null;
            try {
                robotLive = HttpClient.getInstance().getRobotLive();
            } catch (IOException e) {
                continue;
            }

            long time = System.currentTimeMillis();
            for(int i = 0; i < robotLive.getLive().length; i++){
                System.out.println(System.currentTimeMillis());
                app.conn(robotLive.getRobot()[new Random().nextInt(robotLive.getRobot().length)], robotLive.getLive()[i]);
            }

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向服务发送连接消息
     */
    private void conn(Robot robot, Live live) {
        RobotClient robotClient = new RobotClient();
        robotClient.init();

        org.json.JSONObject data = new org.json.JSONObject();
        try {
            data.put("uid", robot.getId());
            data.put("token", robot.getToken());
            data.put("liveuid", live.getLiveid());
            data.put("roomnum", live.getLiveid());
            data.put("stream", live.getStream());
            robotClient.emit("conn", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robotClient.disconnect();
    }

}
