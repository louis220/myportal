package com.bitacademy.myportal.exception;

import com.bitacademy.myportal.repository.MemberVo;

public class MembersDaoException extends RuntimeException{
	// 예외 상황 발생시의 데이터 (확인용)
	private MemberVo vo =null;
	
	public MembersDaoException() {
		super();
	}

	public MembersDaoException(String message) {
		super(message);
	}
	
	public MembersDaoException(String message, MemberVo vo) {
		super(message);
		this.vo =vo;
	}

	public MemberVo getVo() {
		return vo;
	}

	public void setVo(MemberVo vo) {
		this.vo = vo;
	}

	@Override
	public String toString() {
		return "MembersDaoException [vo=" + vo + "]";
	}
	
	
}
