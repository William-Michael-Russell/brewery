package net.testaholic.brewery.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.validation.OverridesAttribute;

/**
 * Created by williamrussell on 5/8/16.
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class WebConfig extends WebMvcConfigurerAdapter {


    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        if (!registry.hasMappingForPattern("/webjars/**")) {
//            registry.addResourceHandler("/webjars/**").addResourceLocations(
//                    "classpath:/META-INF/resources/webjars/");
//        }
//
//        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
//        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
//        registry.addResourceHandler("/resources/");
//                registry.addResourceHandler("**");
//        registry.addResourceHandler("/resources/static/**").addResourceLocations("classpath:/resources/static/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }



}
