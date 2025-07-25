package org.example.z_project.phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class Patient {
    private Long id; // 환자에 대한 고유번호
    private String name; // 개명 가능성
    private int age; // 나이 증가
    private String gender; // 성별 변경 불가

}
