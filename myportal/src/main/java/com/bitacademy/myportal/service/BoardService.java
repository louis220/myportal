package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.repository.BoardVo;

public interface BoardService {

	public List<BoardVo> getList();
	public boolean write(BoardVo vo);
	
}
