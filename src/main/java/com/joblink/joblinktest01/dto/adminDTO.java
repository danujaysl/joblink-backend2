package com.joblink.joblinktest01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private int n_adminid;
    private String c_name;
    private String c_password;
    private String type;
}
