package com.joblink.joblinktest01.repo;

import com.joblink.joblinktest01.entity.jobseeker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobSeekerRepo extends JpaRepository<jobseeker,Integer> {

    @Query(value = "select * from jobseeker where n_jobseekerid= ?1",nativeQuery = true)
    jobseeker getid(int n_jobseekerid);

    

    // Optional<jobseeker> findByc_telephone(String c_telephone);


    
    @Query(value = "select * from jobseeker where c_telephone= ?1",nativeQuery = true)
    List<jobseeker> findByc_telephone(String n_jobseekerid);

  
    @Query(value = "select * from jobseeker where c_logname= ?1",nativeQuery = true)
    jobseeker findByLoginName(String c_logname);


    @Query(value = "select * from jobseeker where c_logname= ?1",nativeQuery = true)
    List<jobseeker> findByc_logname(String n_jobseekerid);
    


     @Query(value = "call joblink.sp_loginuser(?1, ?2, ?3);",nativeQuery = true)
    Object loginSp(String type,String uname,String password);

    // Optional<jobseeker> findByC_telephone(String c_telephone);
    // @Query(value ="select * from consultant where nconsultantid= ?1",nativeQuery = true)
    // jobseeker getconsultantbyid (Integer nConsultantID);
}
