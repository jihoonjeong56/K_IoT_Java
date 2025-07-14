package org.example.chapter12.view;

import org.example.chapter12.controller.StudentController;

import java.util.Scanner;

public class StudentView {
    private final Scanner sc;
    private final StudentController controller;

    public StudentView(Scanner sc, StudentController controller) {
        this.sc = sc;
        this.controller = controller;
    }
    public void showMenu(){
        int choice = 0;
        while(choice != 6){
            System.out.println("===Student Management System");
            System.out.println("");
        }
    }
    private  void addStudentView(){

    }
    private  void showAllStudentView(){

    }
    private  void showStudentByStudentNumber(){

    }
    private void updateStudentView(){

    }
    private void deleteStudentView(){

    }
}
