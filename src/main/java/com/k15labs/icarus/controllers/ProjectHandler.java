package com.k15labs.icarus.controllers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.k15labs.icarus.entites.Project;
import com.k15labs.icarus.pojos.AddProjectRequest;
import com.k15labs.icarus.pojos.BaseResponse;
import com.k15labs.icarus.services.ProjectControllerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProjectHandler {

    @Autowired
    private ProjectControllerService projectControllerService;


    public Mono<ServerResponse> addProject(ServerRequest request) 
    {
        
        Mono<AddProjectRequest> bodyToMono = request.bodyToMono(AddProjectRequest.class);
        Mono<Mono<Project>> map = bodyToMono.map(e->{

           return  projectControllerService.addProject(e);
        });

        return ServerResponse
        .ok()
        .contentType(MediaType.TEXT_EVENT_STREAM).body(map,map.getClass());
      }
  
    public Mono<ServerResponse> findProjects(ServerRequest request) 
    {
        System.out.println("calling again");
        // Mono<BaseResponse<List<Project>>> map = Mono.empty(); 
      
        Flux<Project> projects = Flux.empty();
        Optional<String> pageOpt = request.queryParam("page");
        Optional<String> sizeOpt = request.queryParam("size");

        if(pageOpt.isPresent() && sizeOpt.isPresent())
        {
            String page  = pageOpt.get();
            String size  = sizeOpt.get();
            int pageInt = Integer.parseInt(page);
            int sizeInt = Integer.parseInt(size);

             projects =   projectControllerService.getProjects(pageInt, sizeInt);
         
            

            
            


        }
        else{
             projects = projectControllerService.getProjects();
           
            // map = projects.collectList().map(e->{

            //     var response = new BaseResponse<List<Project>>();
            //     response.setCode("200");
            //     response.setMessage("Fetch Successfull");
            //     response.setResponse(e);
            //     return response;
            // });
            
           
         
        }
        

        return ServerResponse
        .ok()
        .contentType(MediaType.TEXT_EVENT_STREAM).body(projects,projects.getClass());
      }
}
