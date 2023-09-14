package com.joblink.joblinktest01.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="vappointments")
public class vappointments {

    @Id
    private int n_appointid;
    private int n_consultantid;
    private String c_consname;

    
    private int n_jobseekerid;
    private String c_jsname;
    private int n_jobid;
    private String c_jobtype;
    private int n_countryid;
    private String c_country;
    private int n_status;
    private String c_statustype;
    private String d_datetime;
}
