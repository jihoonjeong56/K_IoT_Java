package org.example.z_project.user_reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private final String userId; // 사용자 데이터의 구분값 - 데이터 저장소에서 일괄 부여
    private final String password;
    private final String name;
    private final String email;
}
