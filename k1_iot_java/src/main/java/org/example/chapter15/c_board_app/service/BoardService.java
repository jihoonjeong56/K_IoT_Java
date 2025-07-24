package org.example.chapter15.c_board_app.service;

import org.example.chapter15.c_board_app.dto.BoardDetailResponseDto;
import org.example.chapter15.c_board_app.dto.BoardRequestDto;
import org.example.chapter15.c_board_app.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {
    // 생성 요청 BoardRequestDto | 응닶 없음
    void createBoard(BoardRequestDto dto);
    //조회 전체 요청 없음 | 응답
    List<BoardResponseDto> findAllBoards();

    //조회 단건 - 요청 id | 응답 BoardResponseDto
    BoardDetailResponseDto findBoardById(Long id);

    //수정 요청 id, RequestDto |  응답
    void updateBoard(Long id, BoardRequestDto dto);
    //삭제 요청 id | 응답 없음
    void deleteBoard(Long id);

}
