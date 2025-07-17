package org.example.test0717;

import org.example.test0717.model.Book;
import org.example.test0717.service.BookService;
import org.example.test0717.service.BookServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        // 임의 도서 추가


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" ===도서관리 시스템 ===");
            System.out.println("1. 도서등록");
            System.out.println("2. 도서조회 전체");
            System.out.println("3. 도서조회(id)");
            System.out.println("4. 도서조회(제목)");
            System.out.println("5. 도서저자 수정");
            System.out.println("6. 도서삭제");
            System.out.println("0. 도서프로그램 종료");
            System.out.println("메뉴를 선택해 주세요");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        addBook(bookService, sc);
                        break;
                    case 2:
                        getAllBook(bookService, sc);
                        break;
                    case 3:
                        getBookById(bookService, sc);
                        break;
                    case 4:
                        findBookByTitle(bookService, sc);
                        break;
                    case 5:
                        updateBookAuthor(bookService, sc);
                        break;
                    case 6:
                        deleteBook(bookService, sc);
                        break;
                    case 0:
                        System.out.println("종료합니다.");
                        sc.close();
                        return;
                    default:
                        System.out.println("유효하지 않은 선택입니다.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
    }

    private static void addBook(BookService bookService, Scanner sc) {
        System.out.println("책의 아이디를 입력하세요");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("책의 제목을 입력하세요");
        String title = sc.nextLine();
        System.out.println("책의 저자을 입력하세요");
        String author = sc.nextLine();
        System.out.println("책 등록이 완료되었습니다.");
        bookService.addBook(new Book(id, title, author));
    }

    //도서 전체 조회
    private static void getAllBook(BookService bookService, Scanner sc) {
        bookService.getAllBook();
    }

    //도서 단건조회
    private static void getBookById(BookService bookService, Scanner sc) {
        System.out.println("조회할 책의 id를 검색해 주세요");
        int id = sc.nextInt();
        sc.nextLine();
        List<Book> books = bookService.getBookById(id);
        if (books.isEmpty()) {
            System.out.println("해당 책이 없습니다.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    //도서 조회 제목
    private static void findBookByTitle(BookService bookService, Scanner sc) {
        System.out.println("조회할 책의 제목을 입력해 주세요");
        String title = sc.nextLine();
        List<Book> books = bookService.findBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("해당 제목의 책이 없습니다.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    //도서 저자 수정
    private static void updateBookAuthor(BookService bookService, Scanner sc) {
        System.out.println("수정할 도서의 id를 검색해 주세요");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("수정할 저자를 새로 작성해 주세요");
        String newAuthor = sc.nextLine();
        List<Book> books = bookService.getBookById(id);
        if (books.isEmpty()) {
            System.out.println("해당 id의 도서가 없습니다.");
        } else {
            bookService.updateBookAuthor(id, newAuthor);
            System.out.println("저자가 성공적으로 수정 되었습니다.");
        }

    }

    //도서 삭제
    private static void deleteBook(BookService bookService, Scanner sc) {
        System.out.println("삭제할 도서의 id를 입력해 주세요");
        int id = sc.nextInt();
        sc.nextLine();
        bookService.deleteBook(id);
        System.out.println("도서 삭제가 성공적으로 이루어 졌습니다.");
    }


}

