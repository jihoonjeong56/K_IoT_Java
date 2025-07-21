package org.example.chapter13.practice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor // 필드값 전부를 매개변수로 가지는 생성자
@ToString
@Getter
public abstract class Book {
    //추상 클래스 : 직접적인 인스턴스화가 안된다. 하위 클래스 생성자 내에서 호출 용도로 정의(생성자를 가질수는 있음)
    private String id; //책 고유번호
    private String title;//책 제목
    private String author; //책 저자

    //cf) 인터페이스: 직접적인 인스턴스 안됨, 생성자를 가질 수 없음
}
