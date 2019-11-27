package com.bitacademy.myportal.repository;

import java.util.List;

public interface GuestbookDao {

		public List<GuestbookVo> selectAll();
		public int insert(GuestbookVo vo);
		public int delete(GuestbookVo vo);
	
	
}
