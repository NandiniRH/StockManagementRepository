package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement;

import javax.servlet.ServletRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.h2.server.web.WebServlet;
import org.hibernate.SessionFactory;
@SpringBootApplication
public class StockExchangeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeManagementApplication.class, args);
	}
	

    
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2/*");
        return registrationBean;
    }
    
   
}


