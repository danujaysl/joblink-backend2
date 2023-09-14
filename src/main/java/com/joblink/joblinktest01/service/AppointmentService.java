package com.joblink.joblinktest01.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joblink.joblinktest01.dto.AppointmentDTO;
import com.joblink.joblinktest01.entity.appointment;
import com.joblink.joblinktest01.repo.appointmentRepo;
import com.joblink.joblinktest01.util.VarList;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppointmentService {

  @Autowired
  private appointmentRepo aptRepo;
  @Autowired
  private ModelMapper modelMapper;

  // public Object loginAdmin(appointment aEntity){
  // return aptRepo.save(aEntity);
  // }

  public String newAppointment(AppointmentDTO appDTO) {

    aptRepo.save(modelMapper.map(appDTO, appointment.class));
    return VarList.RSP_SUCCESS;

  }

  // public AppointmentDTO getAppointmentbyJobSeekerID(int n_jobseekerid){

  // if(appointmentRepo.findByn_jobseekerid(String n_appointid)){
  // return null;
  // }
  // else{
  // return null;
  // }
  // }

  // public AppointmentDTO getbyid(int n_jobseekerid) {
  //   if (aptRepo.existsById(n_jobseekerid)) {
  //     appointment appointmentEntity = aptRepo.findById(n_jobseekerid).orElse(null);
  //     return modelMapper.map(appointmentEntity, AppointmentDTO.class);
  //   } else {
  //     return null;
  //   }
  // }


}
