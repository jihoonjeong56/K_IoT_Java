package org.example.chapter12.controller;

import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;
import org.example.chapter12.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    //데이터 저장
    private final List<Student> studentList;
    private int nextId;

    public StudentController(List<Student> studentList) {
        this.studentList = studentList;
        this.nextId = studentList.size() + 1;
    }

    // 1. 학생 추가
    public void addStudent(StudentRequestDto dto) {
        // 학생 추가 시 입력한 studentNumber의 학생이 존재하는 경우
        // : 기능하지 않고 메시지 출력
        StudentResponseDto studentResponseDto = getStudentById(dto.getStudentNumber());

        if(studentResponseDto != null){
            //입력받은 studentNumber의 학생이 존재 - 학생 추가 불가
            System.out.println(" 해당 학번의 학생이 이미 존재합니다ㅣ.");
            return;
        }
        Student student = new Student(nextId++, dto.getName(), dto.getAge(), dto.getStudentNumber());
        studentList.add(student);
        System.out.println(dto.getName() + "학생이 추가되었습니다. 학번: " + dto.getStudentNumber());
    }

    // 2. 학생 조회 전체
    public List<StudentResponseDto> getAllStudents() {
        List<StudentResponseDto> response = new ArrayList<>();
        // 데이터 가공 과정 (Student >> StudentResponseDto)
        for (Student student : studentList) {
            response.add(new StudentResponseDto(student.getName(), student.getAge(),
                    student.getStudentNumber(), student.getCreatedAt()));
        }
        return response;
    }

    // 3.학생 조회 단건
    public StudentResponseDto getStudentById(String studentNumber) {
        for (Student student : studentList) {
            if (student.getStudentNumber().equals(studentNumber)) { // 조회한 학생이 있을 경우
                return new StudentResponseDto(student.getName(), student.getAge(),
                        student.getStudentNumber(), student.getCreatedAt());
            }
        }
        return null; // 조회한 학생이 없을경우
    }

    // 4. 학생 수정 기능
    public boolean updateStudent( StudentRequestDto dto) {

        for (Student student : studentList) {
            if (student.getStudentNumber().equals(dto.getStudentNumber())) {
                student.setName(dto.getName());
                student.setAge(dto.getAge());
                return true;
            }
        }
        return false;
    }

    // 5. 학생 삭제 기능
    public boolean removeStudent(String studentNumber) {
        for (Student student : studentList) {
            if (student.getStudentNumber().equals(studentNumber)) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    // 6. 프로그램 종료


}
