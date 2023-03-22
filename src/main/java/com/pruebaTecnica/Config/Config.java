package com.pruebaTecnica.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config {

//    se hace el bean del modelmaper para que permita mapera los deto a las clases el se impl
    @Bean
    public ModelMapper modelMapper(){ return  new ModelMapper(); }


//    se congigura los cors para que se puedadn realizar laspeticiones correctamentedesde el front
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE").allowedHeaders("*").allowedOrigins("*");
            }
        };
    }
}
