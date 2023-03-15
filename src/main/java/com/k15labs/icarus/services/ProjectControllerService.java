package com.k15labs.icarus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.k15labs.icarus.entites.Project;
import com.k15labs.icarus.pojos.AddProjectRequest;
import com.k15labs.icarus.repos.ProjectRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProjectControllerService {
    
    @Autowired
    private ProjectRepo projectRepo;

    public Flux<Project> getProjects(int page,int size) 
    {

       return projectRepo.findAllPaged(page,size);
        
    }

    public Flux<Project> getProjects() 
    {
       return projectRepo.findAll();
        
    }

    public Mono<Project> addProject(AddProjectRequest projectRequest) 
    {
        Project project = new Project();
        project.setActive(Boolean.TRUE);
        project.setGoLiveDate(projectRequest.getGoLiveDate());
        project.setGoUATDate(project.getGoUATDate());
        project.setStartingDate(project.getStartingDate());
       return projectRepo.save(project);
        
    }
}
