package com.bitacademy.myportal.repository;

import java.util.List;

public interface BoardDao {

	public List<BoardVo> selectAll();
	public int insert(BoardVo vo);
	
}
