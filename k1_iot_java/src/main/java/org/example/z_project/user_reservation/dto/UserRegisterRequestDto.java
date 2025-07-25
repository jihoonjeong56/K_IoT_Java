package org.example.z_project.user_reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter@AllArgsConstructor
public class UserRegisterRequestDto {
    private String userId;
    private String password;
    private String passwordCheck; // Entity 와 User의 차이
    private String name;
    private String email;
}
