package org.example.z_project.phr_solution.dto.patient.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class PatientListResponseDto {
    private long id; // 테스트를 위해 임의로 삽입
    private String name;
    private String gender;

}
