package org.example.test0717.service;

import org.example.test0717.exception.BookNotFoundException;
import org.example.test0717.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService{
    private final List<Book> books = new ArrayList<>();


    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void  getAllBook() {
        if(books.isEmpty()){
            System.out.println("등록된 책이 업습니다.");
        }else{
            for(Book book: books){
                System.out.println(book);
            }
        }
    }

    @Override
    public List<Book> getBookById(int id) {
        List<Book> getBook = new ArrayList<>();
        for(Book book: books){
            if(book.getId() == id) {
               getBook.add(book);
            }
        }
        return getBook;
    }
    @Override
    public List<Book> findBookByTitle(String title) {
        List<Book> getBookByTitle = new ArrayList<>();
        for(Book book: books){
            if(book.getTitle() == title){
               getBookByTitle.add(book);
            }
        }
        return getBookByTitle;
    }

    @Override
    public void updateBookAuthor(int id, String newAuthor) {
        if(books.isEmpty()){
            System.out.println("해당 책이 없습니다.");
        }else {
            for(Book book: books){
                if(book.getId() == id){
                    book.setAuthor(newAuthor);
                }
            }
        }
    }

    @Override
    public void deleteBook(int id) {
        boolean removed = false;
        int size = books.size();
        for(int i = 0; i<size; i++){
            if(books.get(i).getId() == id){
                books.remove(i);
                removed = true;
                System.out.println("정상 삭제 되었습니다");
            }
        }
        if(!removed){
            throw new BookNotFoundException("검색한 "+id+"의 책이 없습니다.");
        }

    }



}
