package com.joblink.joblinktest01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private int n_appointid;
    private int n_consultantid;
    private int n_jobseekerid;
    private int n_jobid;
    private int n_countryid;
    private int n_status;
    private String d_datetime;
}
