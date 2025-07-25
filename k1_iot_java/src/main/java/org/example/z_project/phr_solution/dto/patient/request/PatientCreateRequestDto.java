package org.example.z_project.phr_solution.dto.patient.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PatientCreateRequestDto {
    private String name; // 개명 가능성
    private int age; // 나이 증가
    private String gender; // 성별 변경 불가
}
