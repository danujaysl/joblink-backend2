package com.joblink.joblinktest01.repo;

import com.joblink.joblinktest01.entity.jobseeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobSeekerRepo extends JpaRepository<jobseeker,Integer> {

    @Query(value = "select * from jobseeker where n_jobseekerid= ?1",nativeQuery = true)
    jobseeker getid(int n_jobseekerid);

    // @Query(value ="select * from consultant where nconsultantid= ?1",nativeQuery = true)
    // jobseeker getconsultantbyid (Integer nConsultantID);
}
