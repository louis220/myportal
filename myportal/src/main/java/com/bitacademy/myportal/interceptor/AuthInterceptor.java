package com.bitacademy.myportal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bitacademy.myportal.repository.MemberVo;

//요청을 미리 감지해서 Session 체크(로그인 여부 판별)
public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVo authMember = null;
		//세션이 정상적인지 확인
		
		if(session !=null) {
			authMember = (MemberVo)session.getAttribute("authMember");
		}
		//로그인 여부 판별
		if(authMember== null) {
			//로그인 사용자 아님
			response.sendRedirect(request.getContextPath() + "/members/login");
			// 뒤쪽 핸들러로 요청을 전달하지 않음
			return false;
		}
		// 로그인 사용자 -> 뒤쪽 핸들러로 요청과 응답 전달
		return true;
	}

}
