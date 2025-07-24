package org.example.chapter16.practice.service;

import org.example.chapter16.practice.entity.Book;
import org.example.chapter16.practice.entity.Category;
import org.example.chapter16.practice.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService{
    //데이터 저장소(repository 역할)
    private List<Item> items = new ArrayList<>();

    public BookServiceImpl(){
        items.add(new Book("1", "java1","책1", "이승아", "코리아", Category.FANTASY ));
        items.add(new Book("2", "java2","책2", "이승아", "코리아", Category.FICTION ));
        items.add(new Book("3", "java3","책3", "이승아", "코리아", Category.SCIENCE ));
        items.add(new Book("4", "java4","책4", "이승아", "코리아", Category.FICTION ));
        items.add(new Book("5", "java5","책5", "이승아", "코리아", Category.FICTION ));
        items.add(new Book("6", "java6","책6", "이승아", "코리아", Category.HISTORY ));
        items.add(new Book("7", "java7","책7", "이승아", "코리아", Category.FICTION ));
        items.add(new Book("8", "java8","책8", "이승아", "코리아", Category.FANTASY ));
        items.add(new Book("9", "java9","책9", "이승아", "코리아", Category.HISTORY ));
        items.add(new Book("10", "java10","책10", "이승아", "코리아", Category.FICTION ));
    }

    @Override
    public List<Item> searchByCategory(Category category) {
        /*
        List<Item> result = new ArrayList<>();
        for(Item item: items){
            //다운캐스팅 가능한지 확인
            if( item instanceof Book && ((Book)item).getCategory() == category){
                result.add(item);
            }
        }
         */
        return items.stream()
                .filter(item-> item instanceof Book) // Book 객체만 필터링
                .map(item -> (Book) item) // 형변환 다운 캐스팅
                .filter(book -> book.getCategory() == category) // 카테고리 필터링
                .collect(Collectors.toList());
    }
}
