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
@Table(name = "admin")
public class admin  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int n_adminid;
    private String c_name;
    private String c_password;


}