package com.bitacademy.myportal.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//전역에서 객체들의 이벤트 발생을 감지
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(
		HttpServletRequest request, Exception e ){
			//응용프로그램에서 발생하는 모든 예외를 처리해주는 핸들러
			//1.로깅
			System.err.println("AdviceController:handleException");
			e.printStackTrace();
			
			//2. 시스템 오류 안내 화면 만들기
			ModelAndView mav = new ModelAndView();
			mav.addObject("name", e.getClass().getSimpleName());
			mav.addObject("message","AdviceController:handleException<br>" + e.getMessage());
			mav.setViewName("errors/exception");
			
			return mav;
		}

}
