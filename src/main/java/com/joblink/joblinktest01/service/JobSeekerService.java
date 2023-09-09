package com.joblink.joblinktest01.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joblink.joblinktest01.dto.JobSeekerDTO;
import com.joblink.joblinktest01.entity.jobseeker;
import com.joblink.joblinktest01.repo.JobSeekerRepo;
import com.joblink.joblinktest01.util.VarList;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobSeekerService {

    @Autowired
    private JobSeekerRepo jobSeekerRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveJobSeeker(JobSeekerDTO jobSeekerDTO) {
        if (jobSeekerRepo.existsById(jobSeekerDTO.getN_jobseekerid())) {
            return VarList.RSP_DUBLICATED;
        } else {
            jobSeekerRepo.save(modelMapper.map(jobSeekerDTO, jobseeker.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public Boolean seekJobSeeker(JobSeekerDTO jobSeekerDTO) {
        List<jobseeker> find = jobSeekerRepo.findByc_telephone(jobSeekerDTO.getC_telephone());
        return find != null && find.size() > 0;
    }
    public Boolean seekJobSeekerbyUn(JobSeekerDTO jobSeekerDTO){
           List<jobseeker> find2 =  jobSeekerRepo.findByc_logname(jobSeekerDTO.getC_logname());
           return find2!=null && find2.size()>0;
    }

    public Object login(JobSeekerDTO jobSeekerDTO) {
        return jobSeekerRepo.loginSp(jobSeekerDTO.getType(), jobSeekerDTO.getC_logname(), jobSeekerDTO.getC_password());
    }

    public Object getJobSeeker(String c_logname){
        return jobSeekerRepo.findByLoginName(c_logname);
    }

    public List<JobSeekerDTO> getAllJobSeeker() {
        List<jobseeker> jobSeekerList = jobSeekerRepo.findAll();
        return modelMapper.map(jobSeekerList, new TypeToken<ArrayList<JobSeekerDTO>>() {

        }.getType());
    }

    public String updateJobSeeker(JobSeekerDTO jobSeekerDTO) {
        if (jobSeekerRepo.existsById(jobSeekerDTO.getN_jobseekerid())) {
            jobSeekerRepo.save(modelMapper.map(jobSeekerDTO, jobseeker.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public String deleteJobSeeker(int n_jobseekerid) {
        if (jobSeekerRepo.existsById(n_jobseekerid)) {
            jobSeekerRepo.deleteById(n_jobseekerid);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public JobSeekerDTO getbyid(int n_jobseekerid) {
        if (jobSeekerRepo.existsById(n_jobseekerid)) {
            jobseeker jobentity = jobSeekerRepo.findById(n_jobseekerid).orElse(null);
            return modelMapper.map(jobentity, JobSeekerDTO.class);
        } else {
            return null;
        }
    }
}
