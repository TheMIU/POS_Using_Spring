package lk.ijse.spring.pos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JPAConfig.class})
@ComponentScan(basePackages = "lk.ijse.spring.pos.service")
public class WebRootConfig {
    WebRootConfig(){
        System.out.println("WebRootConfig");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
