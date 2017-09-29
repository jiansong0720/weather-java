package top.xuansong0720;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class WeatherApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeatherApp.class, args);
    }
}