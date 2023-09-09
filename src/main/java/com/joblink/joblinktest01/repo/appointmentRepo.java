package com.joblink.joblinktest01.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.joblink.joblinktest01.entity.appointment;
import org.springframework.data.jpa.repository.Query;

public interface appointmentRepo extends JpaRepository <appointment,Integer> {
    // @Query(value = "Select * from consultant where nConsultantID= ?1",nativeQuery = true)
    // consultant getConsultantbyID(int n_consultantid);

    // @Query(value = "select * from consultant where c_telephone= ?1",nativeQuery = true)
    // List<consultant> findByc_telephone(String n_consultantid);

    @Query(value = "select * from onsultant",nativeQuery = true)
    Object loginSp(String type,String uname,String password);
}
