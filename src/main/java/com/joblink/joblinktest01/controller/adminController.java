package com.joblink.joblinktest01.controller;


import com.joblink.joblinktest01.dto.ResponseDTO;
import com.joblink.joblinktest01.dto.consultantDTO;
import com.joblink.joblinktest01.service.consultantService;
import com.joblink.joblinktest01.util.VarList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/admin")
public class adminController {

    @Autowired
    private ResponseDTO resDTO;

    @Autowired
    private consultantService conService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody consultantDTO conDTO){


         resDTO.setCode(VarList.RSP_DUBLICATED);
                resDTO.setMessage( String.valueOf(
                    (Long) conService.loginCon(conDTO)));
                resDTO.setContent(conDTO);
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
       
    }
}