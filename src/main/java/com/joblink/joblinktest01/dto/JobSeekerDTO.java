package com.joblink.joblinktest01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobSeekerDTO {

    private int n_jobseekerid;
    private String c_name;   
    private String c_logname;
    private String c_password;
    private int n_age;
    private String c_telephone;
}
