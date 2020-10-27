package io.yovelas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Spring Boot Starter
 *
 */

@SpringBootApplication
@EnableJpaRepositories("io.yovelas")
public class App {


    @Autowired
    PagingAndSortingRepository pagingAndSortingRepository;

    public App(PagingAndSortingRepository pagingAndSortingRepository) {
        this.pagingAndSortingRepository = pagingAndSortingRepository;
    }

    @RequestMapping("/")
    public void index(){
        PagingAndSortingRepository<User, Long> repository =  pagingAndSortingRepository;
        Page<User> users = repository.findAll(PageRequest.of(1, 20));
        System.out.println(users);
        System.out.println("ss");
        return;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }



}
