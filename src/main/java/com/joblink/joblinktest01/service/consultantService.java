package com.joblink.joblinktest01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joblink.joblinktest01.dto.consultantDTO;
import com.joblink.joblinktest01.repo.consultantRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class consultantService {
    
    @Autowired
    private consultantRepo conREPO;

    // public Boolean seekConsultant(consultantDTO conDTO) {
    //     List<consultant> find = consultantRepo.findByc_telephone(conDTO.getC_telephone());
    //     return find != null && find.size() > 0;
    // }
    public Object loginCon(consultantDTO conDTO){
           return conREPO.loginSp(conDTO.getType(), conDTO.getC_logname(), conDTO.getC_password());
    }
}
