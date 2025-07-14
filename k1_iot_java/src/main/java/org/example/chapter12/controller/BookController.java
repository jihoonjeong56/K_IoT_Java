package org.example.chapter12.controller;

import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    // 실제 데이터들이 저장되는 리스트
    private List<Book> books;
    //private final List<Book> books = new ArrayList<>(); - 필드 주입 형식
    // >> 코드 간결화, 초기값 확인에 용이

    // 생성자 주입 형식
    // 생성자 주입 형식
    //>> 유연성 증가: 생성자를 토해 다른 리스트로 주입 가능(EX) 테스트용 더미 리스트 응
    // >> 의존성 주입 구조로 변경 가능
    // - 코드 복잡성 증가
    public  BookController(List<Book> books){
        this.books = books;
    }

    //1 . 책 추가에 (요청: 책데이터 / 응답: 없음)
    public void addBook(String title, String author, String publisher){
        Book newBook = new Book(title, author, publisher);
        books.add(newBook);
    }

    //2. 전체 책 조회 (요청없음 응답: 책 데이터 리스트
    public List<Book> getAllBooks(){
        return books;
    }
    // 3. 책검색(제목) (요청 :검색에 응답 검색된 책 리스트
    public List<Book> searchBook(String title){
        List<Book> result = new ArrayList<>();
        for(Book book: books){
            if(book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }
}
