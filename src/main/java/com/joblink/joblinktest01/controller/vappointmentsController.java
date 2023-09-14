package com.joblink.joblinktest01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joblink.joblinktest01.dto.ResponseDTO;
import com.joblink.joblinktest01.dto.VappointmentsDTO;
import com.joblink.joblinktest01.service.VappointmentsService;
import com.joblink.joblinktest01.util.VarList;

@RestController
@RequestMapping(value = "/api/vappointment")
public class vappointmentsController {
    
     @Autowired
    private ResponseDTO resDTO;

    @Autowired
    private VappointmentsService vappService;

    @GetMapping("/getvappbyID/{n_jobseekerid}")
    public ResponseEntity getid(@PathVariable int n_jobseekerid) {
        try {
            VappointmentsDTO vappDTO = vappService.getAppointmentByJobSeekerID(n_jobseekerid);
            if (vappDTO != null) {
                resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage("Appointment Found !");
                resDTO.setContent(vappDTO);

                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);

            } else {
                resDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                resDTO.setMessage("Appointment Not Exist !");
                resDTO.setContent(null);

                return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception ex) {
            resDTO.setCode(VarList.RSP_DUBLICATED);
            resDTO.setMessage("Server Error !");
            resDTO.setContent(null);

            return new ResponseEntity(resDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/getvappbyJSID/{n_jobseekerid}")
    // public VappointmentsDTO getMyAppoint(@PathVariable int n_jobseekerid){
    //     return vappService.getAppointmentByJobSeekerID(n_jobseekerid);
    // } -- Uda eka ketiyenma
}
