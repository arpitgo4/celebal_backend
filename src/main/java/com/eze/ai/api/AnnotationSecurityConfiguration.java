package com.eze.ai.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.eze.ai.api.filter.JsonpCallbackFilter;

@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
public class AnnotationSecurityConfiguration {
	
	private static String[] urlPatterns= new String[]{"/ramViewer/stats/*"};
	@Bean
    public FilterRegistrationBean contextFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        RequestContextFilter contextFilter = new RequestContextFilter();
        registrationBean.setFilter(contextFilter);
        registrationBean.setOrder(1);
        return registrationBean;
    }
	
	@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JsonpCallbackFilter jsonCallbackFilter = new JsonpCallbackFilter();
        registrationBean.setFilter(jsonCallbackFilter);
        List<String> list = new ArrayList<String>(Arrays.asList(urlPatterns));
        registrationBean.setUrlPatterns(list);
        registrationBean.setOrder(2);
        return registrationBean;
    }


}