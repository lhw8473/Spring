package com.spring.pr.board.service;

import java.util.List;

import com.spring.pr.command.BoardVO;

public interface IBoardService {
	
	// 글 등록 
	void registBoard(BoardVO board);
	
	// 글 목록 
	List<BoardVO> listBoard();
	
	// 글 가져오기 
	BoardVO contentBoard(int BNum);
	
	// 글 수정 
	// 글 제목이랑 글 내용만 수정 가능 
	void modiBoard(BoardVO board);
	
	// 글 삭제 
	void delBoard(int bNum);

}