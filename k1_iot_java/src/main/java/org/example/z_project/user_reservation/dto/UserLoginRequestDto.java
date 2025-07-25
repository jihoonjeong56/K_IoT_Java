package org.example.z_project.user_reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter@AllArgsConstructor
public class UserLoginRequestDto {
    private String userId;
    private String password;
}
