package com.joblink.joblinktest01.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "jobseeker")
public class jobseeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int n_jobseekerid;
    private String c_name;   
    private String c_logname;
    private String c_password;
    private int n_age;
    private String c_telephone;

}
