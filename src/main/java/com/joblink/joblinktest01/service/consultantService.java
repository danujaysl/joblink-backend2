package com.joblink.joblinktest01.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joblink.joblinktest01.dto.consultantDTO;
import com.joblink.joblinktest01.entity.consultant;
import com.joblink.joblinktest01.repo.consultantRepo;
import com.joblink.joblinktest01.util.VarList;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class consultantService {
    
    @Autowired
    private consultantRepo conREPO;
    @Autowired
    private ModelMapper modelMapper;

    // public Boolean seekConsultant(consultantDTO conDTO) {
    //     List<consultant> find = consultantRepo.findByc_telephone(conDTO.getC_telephone());
    //     return find != null && find.size() > 0;
    // }
    public Object loginCon(consultantDTO conDTO){
           return conREPO.loginSp(conDTO.getType(), conDTO.getC_logname(), conDTO.getC_password());
    }
}
