package com.joblink.joblinktest01.service;

import com.joblink.joblinktest01.dto.JobSeekerDTO;
import com.joblink.joblinktest01.entity.jobseeker;
import com.joblink.joblinktest01.repo.JobSeekerRepo;
import com.joblink.joblinktest01.util.VarList;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class JobSeekerService {

    @Autowired
    private JobSeekerRepo jobSeekerRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveJobSeeker(JobSeekerDTO jobSeekerDTO){
        if (jobSeekerRepo.existsById(jobSeekerDTO.getN_jobseekerid())){
            return VarList.RSP_DUBLICATED;
        } else {
            jobSeekerRepo.save(modelMapper.map(jobSeekerDTO, jobseeker.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public List<JobSeekerDTO> getAllJobSeeker(){
        List<jobseeker> jobSeekerList = jobSeekerRepo.findAll();
        return modelMapper.map(jobSeekerList,new TypeToken<ArrayList<JobSeekerDTO>>(){
            
        }.getType());
    }

    public String updateJobSeeker(JobSeekerDTO jobSeekerDTO){
        if (jobSeekerRepo.existsById(jobSeekerDTO.getN_jobseekerid())){
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public String deleteJobSeeker(int n_jobseekerid){
        if (jobSeekerRepo.existsById(n_jobseekerid)){
                jobSeekerRepo.deleteById(n_jobseekerid);
                return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    //select * from user_Entity where id = 1
    public JobSeekerDTO getid(Integer n_jobseekerid){
        jobseeker js = jobSeekerRepo.getid(n_jobseekerid);
        return modelMapper.map(js,JobSeekerDTO.class);
    }

}
