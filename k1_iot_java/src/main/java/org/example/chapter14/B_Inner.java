package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

//===학교 시스템
@Getter
@AllArgsConstructor
class School {
    private String schoolName;

    //(비정적) 내부 클래스  - 학생
    @AllArgsConstructor
    class Student {
        private int studentId;
        private String studentName;

        public void displayInfo() {
            System.out.println("학교명: " + schoolName + ", 이름: " + studentName);
        }
    }
    // (정적 내부 클래스)교장선생님 - 싱클톤 패턴
    static class Principal{
        private static Principal instance;

        private Principal(){}
        public static Principal getInstance(){
            if(instance == null){
                instance = new Principal();
            }
            return instance;
        }
        public void displayInfo(){
            System.out.println("훈화말씀: 공부 열심히 해라 좀 !");
        }
    }
}

public class B_Inner {
    public static void main(String[] args) {
        School school = new School("유성초등학교");
        //@롬복 어노테이션 생성자
        // : 필드값 순서대로 매개변수 ㄱ밧 설정
        School.Student student1   = school.new Student(123, "qwe");
        School.Principal  principal = School.Principal.getInstance();

        student1.displayInfo();
        principal.displayInfo();
    }
}
