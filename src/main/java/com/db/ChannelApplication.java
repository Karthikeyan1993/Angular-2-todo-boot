package com.db;

import com.db.entity.Todo;
import com.db.repository.TodoRepository;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ChannelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChannelApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(@Qualifier("todoRepository") TodoRepository todoRepository) {
        return (args) -> {
            todoRepository.save(new Todo("Meeting", "Today evening have meeting with manager", false));
            todoRepository.save(new Todo("Reporting", "Have to send status report before 5pm", false));
            todoRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    ServletRegistrationBean registrationBean( ) {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }
}
