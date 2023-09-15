package com.joblink.joblinktest01.repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.joblink.joblinktest01.entity.appointment;

import jakarta.transaction.Transactional;

public interface appointmentRepo extends JpaRepository <appointment,Integer> {

    // //not needed for findbyid
    // @Query(value = "SELECT  * FROM joblink.vappointments where n_jobseekerid = ?1  order by n_appointid desc limit 1;",nativeQuery = true)
    // List<appointment> findByn_jobseekerid(String n_appointid);

    // Optional<appointment> findByN_jobseekerid(int n_jobseekerid);
    // @Query(value ="SELECT  * FROM joblink.vappointments where n_jobseekerid = ?1  order by n_appointid desc limit 1",nativeQuery = true)
    // appointment getappointbyjobseekid (Integer n_jobseekerid);


    @Transactional
    @Modifying
    @Query(value = "update joblink.appointment set n_status=?1 where n_appointid=?2",nativeQuery = true)
    int changeStatus(int n_status,int n_appointid);




    @Query(value = "SELECT * FROM joblink.vappointments where n_status=?1 and n_consultantid=?2",nativeQuery = true)
    List<Object[]> getByConsultantAndStatus(int n_status,int n_consultantid);


    
    @Query(value = "SELECT * FROM joblink.vappointments where  d_datetime between ?1 and ?2",nativeQuery = true)
    List<Object[]> getReport(String fromdate,String todate);
}
