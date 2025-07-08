package org.example.chapter07;

// == 도서 관리 시스템
// : 책의 정보를 저장, 책의 상태(대여가능 여부)확인, 책의 정보 출력.

// 1) book 클래스
// : 속성) title(String, 불변성), author(String,불변성), isAvailable(boolean)
// : 메서드 borrowBooK(), returnBook(), displayInfo()
// : 생성자) 매개변수 - title, author

class Book {
    private final String title;
    private final String author;
    private boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        isAvailable = true;
    }

    //책 대여 메서드
    void borrowBook() {
        if (isAvailable) { // 책 대여 가능 상태
            isAvailable = false;
            System.out.println("책 대여가 성공적으로 완료 되었습니다.");
        } else {
            System.out.println("현재 대여 중입니다.(대여불가)");
        }
    }

    //책 반납 메서드
    void returnBook() {
        if (!isAvailable) {//isAvailable 이  false인 상태 - 대여중인 상태
            isAvailable = true;
            System.out.println("책 반납이 성공적으로 완료 되었습니다");
        } else {
            System.out.println("이미 반납된 상태입니다.");
        }
    }

    //책 정보 출력 메서드
    void displayInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 대여가능여부: " + (isAvailable ? "대여가능" : "대여불가"));
    }
    //캡슐화를 위한 getter 메서드 추가

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    } // boolean 데이터는 getter 사용시 get 키워드 작성을 권장하지 않는다.

}

// 2) EBook 클래스  - Book 클래스 상속
// 추가 속성 ) fileSize(double)
// 추가 메서드 ) displayInfo() - 재정의
// 생성자) EBook (title, author, fileSize)
class EBook extends Book { // Book 에서 사용할 수 있는 인자가 없음 - 자식클래스에서 super(인자) 키워드 사용
    private double fileSize;
    EBook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize+"Mb");
    }
    double getFileSize(){
        return fileSize;
    }
}

public class E_OOP_Practice {
    public static void main(String[] args) {
        Book book1 = new Book("자바는 재밌어","이승아");
        book1.displayInfo();
        book1.borrowBook();
        book1.displayInfo();
        book1.borrowBook();

        book1.returnBook();
        book1.returnBook();

        //EBook
        EBook eBook1 = new EBook("스프링부트는 재미있어","이도경", 132.23);
        eBook1.displayInfo();
        eBook1.borrowBook();
        eBook1.returnBook();

    }
}
