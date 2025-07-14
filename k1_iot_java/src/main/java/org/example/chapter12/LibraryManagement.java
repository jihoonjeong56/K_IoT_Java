package org.example.chapter12;


import org.example.chapter12.controller.BookController;
import org.example.chapter12.model.Book;
import org.example.chapter12.view.BookView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    ===도서관리 시스템

    1. 요구사항 분석
        - 새로운 도서 추가: addBook
        - 모든 도서 정부 출력: getAllBooks
        - 도서 검색(도서 제목으로): searchBookByTitle
    2. 프로그램 구조

    Model(도서 정보 담당)
        - Book 클래스: 도서 정보 저장 제목, 저자, 출판사 등

    View(사용자인터페이스 UI를 담당)

        - BookView 클래스 : 사용자의 입력을 받아 Controller 에게 전달 & Controller 에게 받은 정보를 출력
    Controller (사용자의 입력을 처리 - Model 과 View 사이를 중제)
        - BookController 클래스 : 사용자의 입력에 따라 적절한 Model 메서드를 호출2
 */
public class LibraryManagement {
    public static void main(String[] args) {
        //테스트용 더미 도서 리스트르 ㄹ생성

        //cf)  Dummy Data
        // :  실제 데이터처럼 보이지만, 테스트나 개발 목적으로 임시로 만든 가짜 데이터
        List<Book> dummyBooks = new ArrayList<>();
        dummyBooks.add(new Book("자바","자바","자바"));
        dummyBooks.add(new Book("파이","자바","자바"));
        dummyBooks.add(new Book("코틀","자바","자바"));

        BookController controller = new BookController(dummyBooks);
        Scanner sc = new Scanner(System.in);
        //의존성 주입
        BookView bookView = new BookView(controller, sc);
        bookView.showMenu();

    }
}
