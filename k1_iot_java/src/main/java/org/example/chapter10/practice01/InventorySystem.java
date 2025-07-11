package org.example.chapter10.practice01;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

//재고관리
public class InventorySystem {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager(); //도서관리 시스템을 인스턴스 화
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===Inventory System");
            System.out.println("1. Create 책 추가");
            System.out.println("2. Read  전체 책 조회");
            System.out.println("3. Update 책 수정");
            System.out.println("4. Delete 책 삭제");
            System.out.println("5. 책 통합 검색");
            System.out.println("6. 책 카테고리 검색");
            System.out.println("7. 책 가격 검색");
            System.out.println("0. 프로그램 종료");

            try {
                //sc.nextLine() - 입력값이 문자열로 인식

                // Integer.parseInt(A)
                // : A 값을 분석하여 Integer 형태로 변경
                // - 숫자형태로 변경 할 수 없는 값이 입력되면
                //      NumberFormatException 발생
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: // 책 추가
                        System.out.println("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.println("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.println("Enter Book ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.println("Enter Book Author: ");
                        String author = sc.nextLine();
                        System.out.println("Enter Book publisher: ");
                        String publisher = sc.nextLine();
                        System.out.println("Enter Book Category: ");
                        String category = sc.nextLine();

                        System.out.println("Enter Book Publish Year: ");
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter Book Price: ");
                        int price = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter Book Stock: ");
                        int stock = Integer.parseInt(sc.nextLine());

                        manager.add(new Book(id, title, isbn, author, publisher, year, price, stock, category));
                        break;

                    case 2:
                        manager.listAll();
                        break;
                    case 3:
                        System.out.println("Enter Book ID to update stock: ");
                        String updateId = sc.nextLine();
                        System.out.println("Enter Quantity to add/subtract: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        manager.updateStock(updateId, quantity);
                        break;
                    case 4:
                        System.out.println("Enter Book ID to remove: ");
                        String removedId = sc.nextLine();
                        manager.remove(removedId);
                        break;
                    case 5:
                        System.out.println("Enter Book Title: ");
                        String keyword = sc.nextLine();
                        List<Item> searchResults = manager.search(keyword);
                        if (searchResults.isEmpty()) {
                            System.out.println("No item found in keyword: " + keyword);
                        } else {
                            for (Item item : searchResults) {
                                item.display();
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Enter Book Category: ");
                        String searchCategory = sc.nextLine();
                        List<Item> categoryResults = manager.searchByCategory(searchCategory);
                        if (categoryResults.isEmpty()) {
                            System.out.println("No item found in keyword: " + searchCategory);
                        } else {
                            for (Item item : categoryResults) {
                                item.display();
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Enter minimum Price: ");
                        int minPrice = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter maximum Price: ");
                        int maxPrice = Integer.parseInt(sc.nextLine());
                        List<Item> priceResult = manager.searchByPriceRange(minPrice, maxPrice);

                        if (priceResult.isEmpty()) {
                            System.out.println("No items in price range");
                        } else {
                            for (Item item : priceResult) {
                                item.display();
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Exit The Program? If you want to exit, please Enter Y");
                        if (sc.nextLine().equalsIgnoreCase("y")) {
                            System.out.println("Exit: ");
                            sc.close();
                            return; // while 무한 루프 탈출
                        }
                        System.out.println("Please Enter again");
                        break; // switch case의 탈출(while 종료 아님)
                    default:
                        System.out.println("Not Value, Please Again.");
                }

            } catch (NumberFormatException e) {
                //숫자형태의 입력이 아닌경우 발생
                System.out.println("Pleas Enter a valid number: " + e.getMessage());
            } catch (NoSuchElementException e) {
                //컬렉션에서 요소를 가져올 때 해당 요소가 없는 경우 발생하는 예외
                // - 존재하지 않는 것을 가져올 때 발생
                System.out.println(e.getMessage());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
//        }
//        int num = 0;
//        switch (num) {
//            case 1: {
//                int a;
//                //코드구문
//                break;
//            }
//            case 2:
//                {
//                    //코드구문
//                    break;
//                }            case 3:{
//                // case 3 만의 스코프(영역) 설계 : 각 case가 지역변수의 범위를 가진 독립 블록(안전성 확보
            //}
        }
    }
}
