package com.bitacademy.myportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal.exception.CustomException;
@Controller
public class WelcomeController {
	@RequestMapping("/")
	public ModelAndView hello(){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Welcome");
//		mav.setViewName("/WEB-INF/views/welcome.jsp");
		mav.setViewName("welcome");
		return mav;
		
	}
	@RequestMapping("/except") //에러가 발생하는 메서드
	@ResponseBody
	public String except() {
		try {
		int result = 4 / 0;
		} catch(Exception e) {
//			throw new RuntimeException("Welcome 컨트롤러에서 오류 발생!");
			// 예외를 단순히 throw 하는 것보다 
			// 보다 구체적인 예외로 전환하여 throw하는 것이 바람직
			throw new CustomException("Welcome 컨트롤러에서 오류 발생!");
		}
		return "Exception Test";		
	}
	
//	//exception handler v1
//	@ExceptionHandler(RuntimeException.class)
//	public String handleControllerExcept(RuntimeException e, Model model) {
//		model.addAttribute("name", e.getClass().getSimpleName());
//		model.addAttribute("message", e.getMessage());
//		return "errors/exception";
//	}
	
	//RuntimeException은 실행 도중 발생할 수 있는 모든 예외의 통칭
	// 가급적 보다 구체적 상황에 맞는 예외를 만들어서 전환하여 throw해 주는 것을 추천
	
	// exception handler v2
//	@ExceptionHandler(CustomException.class)
//	public String handleControllerException2(CustomException e, Model model) {
//		model.addAttribute("name", e.getClass().getSimpleName());
//		model.addAttribute("message", e.getMessage());
//		return "errors/exception";
//	}
	
	/*responsebody는 메서드의 리턴 타입에 따라 적합한 메세지 컨버터를 선택
	 * 해당 컨버터가 지원하는 미디어 타입으로 전환하여 응답으로 출력
	 */
	@RequestMapping("respbody")
	@ResponseBody
	public String respBodyTest() {
		return "<p> 메세지 컨버터 테스트</p>";
	}
	
	
}
























