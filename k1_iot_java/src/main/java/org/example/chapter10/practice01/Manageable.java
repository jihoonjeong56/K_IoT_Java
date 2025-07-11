package org.example.chapter10.practice01;

import java.util.List;

public interface Manageable {
    //CRUD
    void add(Item item);
    void listAll();
    void updateStock(String id, int quantity);
    void remove(String id);

    //검색 기능
    List<Item> search(String keyword);
    List<Item> searchByCategory(String category);
    List<Item> searchByPriceRange(int minPrice, int maxPrice);
}
