package org.example.chapter15.c_board_app.view;

import org.example.chapter15.c_board_app.controller.BoardController;
import org.example.chapter15.c_board_app.dto.BoardDetailResponseDto;
import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;

import java.util.List;
import java.util.Scanner;

/*
    === 게시글 관리 시스템

    Board 게시판
    : CRUD
 */
public class BoardView {
    public static void main(String[] args) {
        BoardController boardController = new BoardController();
        Scanner sc = new Scanner(System.in);

        while(true){
            //View(프론트앤드),  controller(사용자의 입력과 선택을 받아 제어하는 역할 - 백앤드)
            try {
                System.out.println("\n[게시판 관리 시스템]");
                System.out.println("1. 게시글 등록");
                System.out.println("2. 게시글 전체조회(게시글 목록)");
                System.out.println("3. 게시글 단건조회(게시글 상세)");
                System.out.println("4. 게시글 수정");
                System.out.println("5. 게시글 삭제");
                System.out.println("0. 프로그램 종료");
                System.out.print("메뉴를 선택해 주세요 >> ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice){
                    case 1:{
                        System.out.println("게시글 등록(제목, 내용, 작성자를 입력해 주세요.)");
                        System.out.print("제목: ");
                        String title = sc.nextLine();
                        System.out.print("내용: ");
                        String content = sc.nextLine();
                        System.out.print("작성자: ");
                        String author = sc.nextLine();
                        boardController.createBoard(new BoardRequestDto(title, content, author));
                        System.out.println("게시글이 성공적으로 등록되었습니다.");
                        break;
                    }
                    case 2:{
                        System.out.println("게시글 전체 조회");
                        List<BoardResponseDto> dtos = boardController.getAllBoards();
                        dtos.forEach(System.out::println);
                        break;
                    }
                    case 3:{
                        System.out.println("게시글 단건 조회");
                        System.out.println("조회할 게시글 id");
                        Long id = sc.nextLong();
                        sc.nextLine();
                        BoardDetailResponseDto dto = boardController.getBoardById(id);
                        System.out.println(dto);
                        break;
                    }
                    case 4:{
                        System.out.println("게시글 수정(수정할 게시글의 id와 새로운 제목, 내용을 입력해 주세요.)");
                        System.out.print("수정할 게시글 id: ");
                        Long updatedId = sc.nextLong();
                        sc.nextLine();
                        System.out.print("새로운 제목: ");
                        String title = sc.nextLine();
                        System.out.print("새로운 내용: ");
                        String content = sc.nextLine();

                        BoardRequestDto dto = new BoardRequestDto(title, content, "수정은 작성자 x");
                        //BoardCreateRequestDto(title, content, author)
                        //BoardUpdateRequestDto(title, content)
                        boardController.updateBoard(updatedId,dto);
                        break;
                    }
                    case 5:{
                        System.out.println("게시글 삭제");
                        System.out.println("삭제할 게시글 id");
                        Long id = sc.nextLong();
                        sc.nextLine();
                        boardController.deleteBoard(id);
                        break;
                    }
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return;//반복문 종료
                    default:
                        System.out.println("잘못된 선택입니다. 0~5 사이 숫자를 선택해 주세요");
                        break;

                }


            }catch (IllegalArgumentException e){// 인수값으로 부적절한 값을 넘길 대 발생하는 예외
                System.out.println("id값을 확인해 주세요"+ e.getMessage());
                sc.nextLine();

            }catch (Exception e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }
    }
}





















