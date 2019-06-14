/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Lephise
 */
@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

@Override
public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/notFound").setViewName("forward:/index.html");
}


@Bean
public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
    return container -> {
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
                "/notFound"));
    };
  }
}

