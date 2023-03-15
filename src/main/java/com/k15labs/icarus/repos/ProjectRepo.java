package com.k15labs.icarus.repos;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.k15labs.icarus.entites.Project;

import reactor.core.publisher.Flux;

@Repository
public interface ProjectRepo extends ReactiveCrudRepository<Project,Long>,ReactiveSortingRepository<Project,Long> {

     @Query("SELECT * FROM projects LIMIT :page,:size")
     public Flux<Project> findAllPaged(int page,int size);
    
}
