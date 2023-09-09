package com.joblink.joblinktest01.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joblink.joblinktest01.dto.adminDTO;
import com.joblink.joblinktest01.repo.adminRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class adminService {
    
    @Autowired
    private adminRepo aRepo;

    // public Boolean seekConsultant(consultantDTO conDTO) {
    //     List<consultant> find = consultantRepo.findByc_telephone(conDTO.getC_telephone());
    //     return find != null && find.size() > 0;
    // }
    public Object loginAdmin(adminDTO aDTO){
           return aRepo.loginSp(aDTO.getType(), aDTO.getC_name(), aDTO.getC_password());
    }
}
