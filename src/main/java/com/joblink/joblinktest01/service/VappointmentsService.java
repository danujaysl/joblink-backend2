package com.joblink.joblinktest01.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joblink.joblinktest01.dto.VappointmentsDTO;
import com.joblink.joblinktest01.entity.vappointments;
import com.joblink.joblinktest01.repo.VappointmentsRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VappointmentsService {

  @Autowired
  private VappointmentsRepo VaptRepo;
  @Autowired
  private ModelMapper modelMapper;


  // public VappointmentsDTO getbyJid(int n_jobseekerid) {
  //   if (VaptRepo.existsById(n_jobseekerid)) {
  //     vappointments vappointmentEntity = VaptRepo.findById(n_jobseekerid).orElse(null);
  //     return modelMapper.map(vappointmentEntity, VappointmentsDTO.class);
  //   } else {
  //     return null;
  //   }
  // }
  //   public VappointmentsDTO getbyJid(int n_jobseekerid) {
  //   if (VaptRepo.existsByN_jobseekerid(n_jobseekerid)) {
  //     List<vappointments> vappointmentEntity = VaptRepo.findByN_jobseekerid(n_jobseekerid);
  //     return modelMapper.map(vappointmentEntity, VappointmentsDTO.class);
  //   } else {
  //     return null;
  //   }

  public VappointmentsDTO getAppointmentByJobSeekerID(int n_jobseekerid){
    vappointments vAppEntity = VaptRepo.getAppByJSid(n_jobseekerid);
    return modelMapper.map(vAppEntity, VappointmentsDTO.class );
  }

}