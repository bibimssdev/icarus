package com.k15labs.icarus.pojos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddProjectRequest {

    private String projectName;
    private LocalDate goLiveDate;
    private LocalDate goUATDate;
    private LocalDate startingDate;
    
}
