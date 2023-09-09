package com.joblink.joblinktest01.repo;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.jpa.repository.JpaRepository;
import com.joblink.joblinktest01.entity.admin;

public interface adminRepo extends JpaRepository <admin,Integer> {

// LOGIN
    @Query(value = "call joblink.sp_loginuser(?1, ?2, ?3);",nativeQuery = true)
    Object loginSp(String type,String uname,String password);
}
