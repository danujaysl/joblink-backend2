package com.joblink.joblinktest01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class consultant {
    @Id
    private int n_consultantid;
    private String c_name;
    private String c_logname;
    private String c_password;
    private int c_telephone;
    private int n_country;
    private int n_jobid;
    private boolean b_active;
}
