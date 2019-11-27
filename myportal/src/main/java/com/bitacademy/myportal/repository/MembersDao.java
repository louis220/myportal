package com.bitacademy.myportal.repository;

public interface MembersDao {
	public int insert(MemberVo vo); //가입 INSERT
	public MemberVo selectUser(String email);//중복 검사용 SELECT
	public MemberVo selectUser(String email, String password);// 로그인용 select
	

}
