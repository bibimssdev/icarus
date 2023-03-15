package com.k15labs.icarus.entites;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="projects")
public class Project 
{

    @Id
    private Long id;

    @Column(value = "project_name")
    private String projectName;

    @Column(value = "project_desc")
    private String description;

    @Column(value = "project_active")
    private Boolean active;


    @Column(value = "go_live_date")
    private LocalDate goLiveDate;

    @Column(value = "go_uat_date")
    private LocalDate goUATDate;

    @Column(value = "starting_date")
    private LocalDate startingDate;

   

    @CreatedDate
    @Column(value = "created_on")
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(value = "modified_on")
    private LocalDateTime modifiedOn;


     
    
}
