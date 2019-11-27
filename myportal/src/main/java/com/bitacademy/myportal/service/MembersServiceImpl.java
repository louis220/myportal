package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.MemberVo;
import com.bitacademy.myportal.repository.MembersDao;

@Service("membersService")
public class MembersServiceImpl implements MembersService {
	@Autowired
	MembersDao membersDao;
	@Override
	public boolean join(MemberVo vo) {
		int insertedCount = membersDao.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public MemberVo getUser(String email, String password) {
		MemberVo vo = membersDao.selectUser(email,password);
		return vo;
	}

	@Override
	public MemberVo getUser(String email) {
		MemberVo vo = membersDao.selectUser(email);
		return vo;
	}

}


















