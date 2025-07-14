package org.example.chapter12.dto;

import java.time.LocalDateTime;

public class StudentResponseDto {
    private String name;
    private int age;
    private String studentNumber;
    private LocalDateTime createdAt;

    public StudentResponseDto(String name, int age, String studentNumber, LocalDateTime createdAt) {

        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "StudentId: "
                + ", Name: " + name
                + ", Age: " + age
                + ", StudentNumber: " + studentNumber
                + ", CreatedAt: " + createdAt;
    }
}
