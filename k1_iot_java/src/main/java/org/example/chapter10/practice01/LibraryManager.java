package org.example.chapter10.practice01;

import java.util.ArrayList;
import java.util.List;

//도서관리기능을 수행(관리할 행동을 실질적 구현
public class LibraryManager implements Manageable {
    //책 저장 공간(ArrayList - 중복 가능, 순서 보장 / 조회 빠른 기능)
    private List<Item> items = new ArrayList<>();

    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

    @Override
    public void listAll() {
        //전체 조회: isEmpty()로 요소값 존재 여부 확인에 따라 로직을 처리
        if (items.isEmpty()) {
            System.out.println("No items in the library");
        } else {
            System.out.println("library Items");
            for (Item item : items) {
                item.display();
            }
        }
    }

    @Override
    public void updateStock(String id, int quantity) {
        for (Item item : items) {
            //item.updateStock(quantity);
            if (item.getId().equals(id) && item instanceof Book) {
                //Book selectedBook = (Book)item;
                ((Book) item).updateStock(quantity);
                //selectedBook.updateStock(quantity);
                System.out.println("Stock updated for ID: " + id + ", Stock: " + ((Book) item).getStock());
                // System.out.println("Stock updated for ID: "+ id + ", Stock: "+ selectedBook.getStock());
            }
        }
    }

    @Override
    public void remove(String id) {
        // 삭제 여부 확인용 boolean 데이터
        boolean removed = false;
        //인덱스 번호르 사용하여 요소 제거
        // : 일반 for문 사용 하여 초기화 변수 == 인덱스 번호
        int size = items.size();
        for (int i = 0; i < size; i++) {
            //전체 items 순회: 각 순번의  item의 id와 매개변수의 id가 일치한다면  해당 인덱스 요소를 제거
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                removed = true;
                System.out.println("Item with ID: " + id + " removed");
                break;
            }
        }
        if (!removed) {
            //제거된 요소가 없다면
            System.out.println("No item found with ID: " + id);
        }
    }

    @Override
    public List<Item> search(String keyword) {
        return List.of();
    }

    @Override
    public List<Item> searchByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Item> searchByPriceRange(int minPrice, int maxPrice) {
        return List.of();
    }
}
