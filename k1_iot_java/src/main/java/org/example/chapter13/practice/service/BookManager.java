package org.example.chapter13.practice.service;

import java.util.List;

/*
도서관리 시스템의 비즈니스 로직을 인터페이스화
: CRUD 가능
- 제네릭 타입을 통해 책의 타입을 정의
 */
public interface BookManager<T> {
    // T: 타입변수
    //  - 해당 인터페이스로 실질적인 비즈니스 로직 구현 시 타입을 명시
    void addBook(T book);
    T findBookById(String id); // 단건조회
    List<T> listAllBooks();//전체조회
    void updateBook(String id, T updatedBook);
    void deleteBook(String id);
}
