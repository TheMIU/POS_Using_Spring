package lk.ijse.spring.pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.spring.pos.controller","lk.ijse.spring.pos.adviser"})
public class WebAppConfig {
    public WebAppConfig(){
        System.out.println("WebAppConfig");
    }
}
