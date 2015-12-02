package com.pluralsight;

import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

// instead of XML file, this one
@Configuration
@ComponentScan({"com.pluralsight"})
@PropertySource("app.properties")
public class AppConfig {

    // loading a properties file reader. This function goes out and reads the props file
    // 1. put .properties file into resources folder
    // 2. make this function to read them
    // 3. load values into variables, as done in file "HibernateCustomerRepositoryImpl.java"
    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "customerService")
    @Scope("singleton") // @Scope("prototype") guarantees a new one every time
    public CustomerService getCustomerService() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        //CustomerServiceImpl customerService = new CustomerServiceImpl(getCustomerRepository());
        //customerService.setCustomerRepository(getCustomerRepository());
        return customerService;
    }

    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository() {
        return new HibernateCustomerRepositoryImpl();
    }
}
