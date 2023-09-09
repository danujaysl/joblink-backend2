package com.joblink.joblinktest01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joblink.joblinktest01.dto.JobSeekerDTO;
import com.joblink.joblinktest01.dto.ResponseDTO;
import com.joblink.joblinktest01.dto.adminDTO;
import com.joblink.joblinktest01.dto.appointmentDTO;
import com.joblink.joblinktest01.service.AppointmentService;
import com.joblink.joblinktest01.service.adminService;
import com.joblink.joblinktest01.util.VarList;

@RestController
@RequestMapping(value = "/api/appointment")
public class appointmentController {
    
     @Autowired
    private ResponseDTO resDTO;

    @Autowired
    private AppointmentService appService;

    @PostMapping("/new")
      public ResponseEntity newAppointment(@RequestBody appointmentDTO appDto){
        String res = appService.newAppointment(appDto);
        
         resDTO.setCode(VarList.RSP_DUBLICATED);
                resDTO.setMessage( res);
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
      }

    @PostMapping("/myAppointment")
    public ResponseEntity myAppointment(@RequestBody JobSeekerDTO jsDTO) {

      return null;

    }

}
