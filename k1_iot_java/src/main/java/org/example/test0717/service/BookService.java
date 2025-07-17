package org.example.test0717.service;

import org.example.test0717.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    //전체 조회
    void getAllBook();
    //단건 조회
    List<Book> getBookById(int id);
    //도서검색
    List<Book> findBookByTitle(String title);
    //도서 저자 수정
    void updateBookAuthor(int id, String newAuthor);
    //도서 삭제
    void deleteBook(int id);



}
