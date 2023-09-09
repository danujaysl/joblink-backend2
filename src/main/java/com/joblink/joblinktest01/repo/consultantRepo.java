package com.joblink.joblinktest01.repo;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.joblink.joblinktest01.entity.consultant;

public interface consultantRepo extends JpaRepository <consultant,Integer> {
    // @Query(value = "Select * from consultant where nConsultantID= ?1",nativeQuery = true)
    // consultant getConsultantbyID(int n_consultantid);

    // @Query(value = "select * from consultant where c_telephone= ?1",nativeQuery = true)
    // List<consultant> findByc_telephone(String n_consultantid);

     @Query(value = "SELECT * FROM joblink.consultant where n_country=?1 and n_jobid=?2 and b_active=1",nativeQuery = true)
    List<consultant> findByn_countryAndn_jobidAndb_active(int n_country, int n_jobid);

    @Query(value = "call joblink.sp_loginuser(?1, ?2, ?3);",nativeQuery = true)
    Object loginSp(String type,String uname,String password);
}
