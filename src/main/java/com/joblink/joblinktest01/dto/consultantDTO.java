package com.joblink.joblinktest01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class consultantDTO {
    private int n_consultantid;
    private String c_name;
    private String c_logname;
    private String c_password;
    private int c_telephone;
    private int n_country;
    private int n_jobid;
    private boolean b_active;
}
