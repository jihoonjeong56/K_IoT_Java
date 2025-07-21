package org.example.chapter13.practice.controller;

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.service.BookServiceImpl;
import org.example.chapter13.practice.view.BookView;

import java.util.List;

//사용자의 요청을 처리
public class BookController {
    // 싱글톤 패턴 인스턴스화(BookServiceImpl)
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view = new BookView();

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getInputMenuNumber();

            switch (choice) {
                case 1: // 책 추가:  요청 데이터 존재, 반환 데이터 없음
                    Book book = view.getBookDetails();
                    if (book != null) service.addBook(book);
                    else System.out.println("필수 데이터 값을 다시 확인해 주세요");
                    break;
                case 2:// 단건조회: 요청 데이터 존재 , 반환 데이터 존재
                    String findBookId = view.getInputIdString("id");
                    if (findBookId != null) {
                        Book foundBook = service.findBookById(findBookId);
                        view.displayBook(foundBook);
                    }
                    break;
                case 3: //전체조회
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;
                case 4: // 도서 수정
                    String updateId = view.getInputIdString("id");
                    if (updateId != null) {
                        Book updatedBook = view.getBookDetails();
                        if (updatedBook != null) {
                            service.updateBook(updateId, updatedBook);
                        } else {
                            System.out.println("수정할 도서 정보가 유효하지 않습니다.");
                        }
                    }
                    break;
                case 5: // 도서 삭제
                    String removeId = view.getInputIdString("id");
                    if (removeId != null) {
                        service.deleteBook(removeId);
                    }
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 입력해 주세요");

            }

        }
    }


}
