package com.joblink.joblinktest01.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joblink.joblinktest01.entity.vappointments;
import java.util.List;


public interface VappointmentsRepo extends JpaRepository <vappointments,Integer> {
    
    @Query(value = "SELECT  * FROM joblink.vappointments where n_jobseekerid = ?1 order by n_appointid desc limit 1",nativeQuery = true)
    vappointments getAppByJSid(int n_jobseekerid);

    // @Query(value = "SELECT  * FROM joblink.vappointments where n_jobseekerid = ?1",nativeQuery = true)
    // List<vappointments> findByN_jobseekerid(int n_appointid);
}
