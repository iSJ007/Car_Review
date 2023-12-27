package com.iJ07.carreviewapi;

import com.iJ07.carreviewapi.filters.authFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarReviewApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarReviewApiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<authFilter> filterRegistrationBean() {
		FilterRegistrationBean<authFilter> registrationBean = new FilterRegistrationBean<>();
		authFilter authFilter = new authFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/carapi/car-review/*");
		return registrationBean;
	}

}
