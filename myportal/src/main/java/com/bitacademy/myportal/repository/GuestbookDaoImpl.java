package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //저장소로 등록할수 있음
public class GuestbookDaoImpl implements GuestbookDao {
	// sqlSession 객체를 사용해야 한다
	// 외부로부터 sqlSession객체를 주입한다(DI)
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GuestbookVo> selectAll() {
		// 방명록 리스트 받아오기
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		// 방명록 기록
		int insertedCount = sqlSession.insert("guestbook.insert", vo);
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		// 방명록 삭제
		int deletedCount = sqlSession.delete("guestbook.delete", vo);
	
		return deletedCount;
	}

}









