package com.bitacademy.myportal.service;

import com.bitacademy.myportal.repository.MemberVo;

public interface MembersService {
	
	public boolean join(MemberVo vo);
	public MemberVo getUser(String email, String password);
	public MemberVo getUser(String email);

}
