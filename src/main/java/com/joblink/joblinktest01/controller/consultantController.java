package com.joblink.joblinktest01.controller;

import com.joblink.joblinktest01.dto.AvailableConsultantsDTO;
import com.joblink.joblinktest01.dto.ResponseDTO;
import com.joblink.joblinktest01.dto.consultantDTO;
import com.joblink.joblinktest01.entity.consultant;
import com.joblink.joblinktest01.service.consultantService;
import com.joblink.joblinktest01.util.VarList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/consultant")
public class consultantController {

    @Autowired
    private ResponseDTO resDTO;

    @Autowired
    private consultantService conService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody consultantDTO conDTO){


         resDTO.setCode(VarList.RSP_DUBLICATED);
                resDTO.setMessage( String.valueOf(
                    (Long) conService.loginCon(conDTO)));
                resDTO.setContent(conService.findByLoginName(conDTO.getC_logname()));
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
       
    }

    @PostMapping("/get-consultatnts-by-availability")
     public ResponseEntity getConsultatntsByAvailability(@RequestBody AvailableConsultantsDTO conDTO){
        List<consultant> availableConsultants = conService.geAvailableConsultatnts(conDTO);

        resDTO.setCode(VarList.RSP_DUBLICATED);
        resDTO.setContent(availableConsultants);
        return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
       
    }
}