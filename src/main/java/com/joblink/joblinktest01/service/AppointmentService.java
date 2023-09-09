package com.joblink.joblinktest01.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joblink.joblinktest01.dto.appointmentDTO;
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

  public String newAppointment(appointmentDTO appDTO) {

    aptRepo.save(modelMapper.map(appDTO, appointment.class));
    return VarList.RSP_SUCCESS;

  }

  public Object myAppointment(appointmentDTO appDTO) {
    return aptRepo.getAppointmentbyID(appDTO.getN_jobseekerid());
  }

}
