package com.joblink.joblinktest01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joblink.joblinktest01.dto.AppointmentDTO;
import com.joblink.joblinktest01.dto.ResponseDTO;
import com.joblink.joblinktest01.service.AppointmentService;
import com.joblink.joblinktest01.util.VarList;

@RestController
@RequestMapping(value = "/api/appointment")
public class appointmentController {
    
     @Autowired
    private ResponseDTO resDTO;

    @Autowired
    private AppointmentService appService;

    @PostMapping("/new")
      public ResponseEntity newAppointment(@RequestBody AppointmentDTO appDto){
        String res = appService.newAppointment(appDto);
        
         resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage( res);
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
      }

      
    @PostMapping("/change/status")
      public ResponseEntity changeStatus(@RequestBody AppointmentDTO appDto){
        String res = appService.changeStatus(appDto);
        
         resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage( res);
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
      }


            
    @PostMapping("/list")
      public ResponseEntity list(@RequestBody AppointmentDTO appDto){
  
        
         resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage("");
                resDTO.setContent(appService.list(appDto));
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
      }

          @PostMapping("/report")
      public ResponseEntity report(@RequestBody AppointmentDTO appDto){
  
        
         resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage("");
                resDTO.setContent(appService.report(appDto));
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
      }

    // @GetMapping("/getappbyID/{n_jobseekerid}")
    // public ResponseEntity getid(@PathVariable int n_jobseekerid) {
    //     try {
    //         AppointmentDTO appDTO = appService.getbyid(n_jobseekerid);
    //         if (appDTO != null) {
    //             resDTO.setCode(VarList.RSP_SUCCESS);
    //             resDTO.setMessage("Appointment Found !");
    //             resDTO.setContent(appDTO);

    //             return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);

    //         } else {
    //             resDTO.setCode(VarList.RSP_NO_DATA_FOUND);
    //             resDTO.setMessage("Appointment Not Exist !");
    //             resDTO.setContent(null);

    //             return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);

    //         }
    //     } catch (Exception ex) {
    //         resDTO.setCode(VarList.RSP_DUBLICATED);
    //         resDTO.setMessage("Server Error !");
    //         resDTO.setContent(null);

    //         return new ResponseEntity(resDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

}
