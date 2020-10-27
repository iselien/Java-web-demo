package io.yovelas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring Boot Starter
 *
 */

@Controller
@SpringBootApplication
public class App {


//    @RequestMapping("/")
//    public String home(){
//        return "hello";
//    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
