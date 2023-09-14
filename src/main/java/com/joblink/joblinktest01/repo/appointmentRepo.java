package com.joblink.joblinktest01.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import com.joblink.joblinktest01.entity.appointment;

public interface appointmentRepo extends JpaRepository <appointment,Integer> {

    // //not needed for findbyid
    // @Query(value = "SELECT  * FROM joblink.vappointments where n_jobseekerid = ?1  order by n_appointid desc limit 1;",nativeQuery = true)
    // List<appointment> findByn_jobseekerid(String n_appointid);

    // Optional<appointment> findByN_jobseekerid(int n_jobseekerid);
    // @Query(value ="SELECT  * FROM joblink.vappointments where n_jobseekerid = ?1  order by n_appointid desc limit 1",nativeQuery = true)
    // appointment getappointbyjobseekid (Integer n_jobseekerid);

}
