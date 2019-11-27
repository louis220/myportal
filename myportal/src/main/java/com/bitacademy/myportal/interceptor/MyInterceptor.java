package com.bitacademy.myportal.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//Interceptor : 컨트롤러의 앞과 뒤에서 요청과 응답을 가로채서 처리한다
//필터와의 차이점은 필터가 dispatchercontroller 이전에서 요청/응답을 처리한다면
// 인터셉터는 dispatchercontroller 이후에 작동하기 때문에
// Spring container 내부에 생성된 객체를 활용할 수 있다
public class MyInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	
//	prehandle : 컨트롤러 실행 이전
	//만약에 return이 false면 연결되어 있는 handler로 요청이 전달되지 않는다

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("MyInterceptor.preHandle call");
		return true;
	}
	
	//posthandle :컨트롤러 수행 이후

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MtInterceptor.postHandle call");

	}

	// aftercompletion :뷰 작업까지 완료된 시점에서 수행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("MyInterceptor.afterCompletion call");

	}

}
