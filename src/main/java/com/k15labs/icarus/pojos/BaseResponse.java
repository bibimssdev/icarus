package com.k15labs.icarus.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> 
{
    private T response; 
    private String code; 
    private String message;
}
