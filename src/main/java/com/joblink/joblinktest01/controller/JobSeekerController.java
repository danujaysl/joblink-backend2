package com.joblink.joblinktest01.controller;

import com.joblink.joblinktest01.dto.JobSeekerDTO;
import com.joblink.joblinktest01.dto.ResponseDTO;
import com.joblink.joblinktest01.service.JobSeekerService;
import com.joblink.joblinktest01.util.VarList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private ResponseDTO resDTO;

    @GetMapping("/getJS")
    public ResponseEntity getAllJobSeeker() {
        try {
            List<JobSeekerDTO> res = jobSeekerService.getAllJobSeeker();
            resDTO.setCode(VarList.RSP_SUCCESS);
            resDTO.setMessage("All Job Seekers !");
            resDTO.setContent(res);
            return new ResponseEntity(resDTO, HttpStatus.CREATED);

        } catch (Exception ex) {
            resDTO.setCode(VarList.RSP_ERROR);
            resDTO.setMessage(ex.getMessage());
            resDTO.setContent(null);
            return new ResponseEntity(resDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveJS")
    public ResponseEntity saveJobSeeker(@RequestBody JobSeekerDTO jsDTO) {

        Boolean jobseekerObj = jobSeekerService.seekJobSeeker(jsDTO);
        Boolean jobseekerUnObj = jobSeekerService.seekJobSeekerbyUn(jsDTO);
        if (jobseekerObj) {
            resDTO.setCode(VarList.RSP_DUBLICATED);
            resDTO.setMessage("Job Seeker already in system !");
            resDTO.setContent(jsDTO);
            return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
        } else if (jobseekerUnObj) {
            resDTO.setCode(VarList.RSP_DUBLICATED);
            resDTO.setMessage("Usename already existed. Try another username !");
            resDTO.setContent(jsDTO);
            return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);
        } else {

            try {
                String res = jobSeekerService.saveJobSeeker(jsDTO);
                if (res.equals("00")) {
                    resDTO.setCode(VarList.RSP_SUCCESS);
                    resDTO.setMessage("Successfully added a new Job Seeker !");
                    resDTO.setContent(jsDTO);

                    return new ResponseEntity(resDTO, HttpStatus.CREATED);
                } else if (res.equals("06")) {
                    resDTO.setCode(VarList.RSP_DUBLICATED);
                    resDTO.setMessage("Job Seeker already in system !");
                    resDTO.setContent(jsDTO);

                    return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
                } else {
                    resDTO.setCode(VarList.RSP_FAIL);
                    resDTO.setMessage("Saving error!");
                    resDTO.setContent(null);

                    return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
                }

            } catch (Exception ex) {
                resDTO.setCode(VarList.RSP_ERROR);
                resDTO.setMessage(ex.getMessage());
                resDTO.setContent(null);

                return new ResponseEntity(resDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            // return jobSeekerService.saveJobSeeker();
        }
    }

    @PutMapping(value = "/updateJS")
    public ResponseEntity updateJobSeeker(@RequestBody JobSeekerDTO jsDTO) {

        try {
            String res = jobSeekerService.updateJobSeeker(jsDTO);
            if (res.equals("00")) {
                resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage("Successfully updated Job Seeker !");
                resDTO.setContent(jsDTO);

                return new ResponseEntity(resDTO, HttpStatus.CREATED);
            } else if (res.equals("01")) {
                resDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                resDTO.setMessage("Job Seeker not found !");
                resDTO.setContent(jsDTO);

                return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
            } else {
                resDTO.setCode(VarList.RSP_FAIL);
                resDTO.setMessage("Saving error!");
                resDTO.setContent(null);

                return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            resDTO.setCode(VarList.RSP_ERROR);
            resDTO.setMessage(ex.getMessage());
            resDTO.setContent(null);

            return new ResponseEntity(resDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // return jobSeekerService.saveJobSeeker();
    }

    @DeleteMapping("/deleteJS/{n_jobseekerid}")
    public ResponseEntity deleleJobSeeker(@PathVariable int n_jobseekerid) {
        try {
            String res = jobSeekerService.deleteJobSeeker(n_jobseekerid);
            if (res.equals("00")) {
                resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage("Successfully deleted Job Seeker !");
                resDTO.setContent(res);

                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);

            } else {
                resDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                resDTO.setMessage("Job seeker not found to delete !");
                resDTO.setContent(null);
                ;
                return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            resDTO.setCode(VarList.RSP_ERROR);
            resDTO.setMessage(ex.getMessage());
            resDTO.setContent(null);

            return new ResponseEntity(resDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // GET BY JOB SEEKER ID 
    @GetMapping("/getjsbyID/{n_jobseekerid}")
    public ResponseEntity getid(@PathVariable int n_jobseekerid) {
        try {
            JobSeekerDTO jsDTO = jobSeekerService.getbyid(n_jobseekerid);
            if (jsDTO != null) {
                resDTO.setCode(VarList.RSP_SUCCESS);
                resDTO.setMessage("Job Seeker Found !");
                resDTO.setContent(jsDTO);
                
                return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);

            } else {
                resDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                resDTO.setMessage("Job Seeker Not Exist !");
                resDTO.setContent(null);

                return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception ex) {
            resDTO.setCode(VarList.RSP_DUBLICATED);
            resDTO.setMessage("Job Seeker Not Exist !");
            resDTO.setContent(null);

            return new ResponseEntity(resDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JobSeekerDTO jsDTO) {

        String userLoginResult = String.valueOf(
                (Long) jobSeekerService.login(jsDTO));

        resDTO.setCode(VarList.RSP_DUBLICATED);
        resDTO.setMessage(userLoginResult);
        if(userLoginResult.equals("100")){
            resDTO.setContent(jobSeekerService.getJobSeeker(jsDTO.getC_logname()));
        }
        return new ResponseEntity(resDTO, HttpStatus.ACCEPTED);

    }

}
