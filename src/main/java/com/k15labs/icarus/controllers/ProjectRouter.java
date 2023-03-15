package com.k15labs.icarus.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;




@Configuration(proxyBeanMethods = false)
public class ProjectRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ProjectHandler greetingHandler) {
  
      return 
        RouterFunctions
        .route(GET("/projects").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::findProjects)
        .andRoute(POST("/projecst").and(contentType(MediaType.APPLICATION_JSON),accept(MediaType.APPLICATION_JSON),greetingHandler::addProject)
        ,greetingHandler::addProject);
    }
    
}
