package top.xuansong0720;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

@EnableScheduling
@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class WeatherApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeatherApp.class, args);
    }
}