package org.example.z_project.phr_solution.controller;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.service.PatientService;
import org.example.z_project.phr_solution.service.implement.PatientServiceImpl;

import java.util.List;

public class PatientController {
    private final PatientService patientService;
    public PatientController(){
        this.patientService = new PatientServiceImpl();
    }
    //C
    public void registerPatient(PatientCreateRequestDto dto){
        patientService.registerPatient(dto);
    }
    //R(전체)
    public List<PatientListResponseDto> getAllPatients(){
        List<PatientListResponseDto> result =  patientService.listAllPatients();
        return result;
    }
    //R(단건)
    public PatientDetailResponseDto getPatientById(Long id){
        PatientDetailResponseDto result = patientService.getPatientById(id);
        return result;
    }
    //U
    public void updatePatient(Long id, PatientUpdateRequestDto dto){
        patientService.updatePatient(id, dto);
    }
    //D
    public void deletePatient(Long id){
        patientService.deletePatient(id);
    }

}
