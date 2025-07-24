package org.example.chapter15.c_board_app.dto;

import lombok.ToString;
import org.example.chapter15.c_board_app.entity.Board;

@ToString
public class BoardDetailResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;

    public BoardDetailResponseDto(Board board){
        this.id = board.getId();
        this.author = board.getAuthor();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
    public static BoardDetailResponseDto fromEntity(Board board){
        return new BoardDetailResponseDto(board);
    }
}
