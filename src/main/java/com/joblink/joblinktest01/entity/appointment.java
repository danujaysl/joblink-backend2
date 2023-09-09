package com.joblink.joblinktest01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int n_appointid;
    private int n_consultantid;
    private int n_jobseekerid;
    private int n_jobid;
    private int n_countryid;
    private int n_status;
    private String d_datetime;
}
