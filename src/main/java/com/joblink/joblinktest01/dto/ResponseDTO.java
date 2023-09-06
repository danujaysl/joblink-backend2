package com.joblink.joblinktest01.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    private String code;
    private String message;
    private Object content;
}
