package com.joblink.joblinktest01.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joblink.joblinktest01.entity.consultant;

public interface consultantRepo extends JpaRepository <consultant,Integer> {
    @Query(value = "Select * from consultant where nConsultantID= ?1",nativeQuery = true)
    consultant getConsultantbyID(int n_consultantid);
}
