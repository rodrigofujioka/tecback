package br.iesp.edu.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfigureAdapter
        implements WebMvcConfigurer {

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry){
registry.addResourceHandler("swagger-ui.html")
.addResourceLocations("classpath:/META-INF/resources/");

registry.addResourceHandler("/webjars/**")
.addResourceLocations("classpath:/META-INF/resources/webjars/");}

}