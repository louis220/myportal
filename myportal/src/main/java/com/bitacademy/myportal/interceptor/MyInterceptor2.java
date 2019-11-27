package com.bitacademy.myportal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



//handlerinterceptoradeptor는 handlerinterceptor 인터페이스를 
//미리 구현해 둔 추상 클래스 : 필요한 단계의 메서드만 상속받아구현해 주면 된다
public class MyInterceptor2 extends HandlerInterceptorAdapter{
	 private static final Logger logger = LoggerFactory.getLogger(MyInterceptor2.class);
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			logger.debug("MyInterceptor2.preHandle call");
			return super.preHandle(request, response, handler);
		}

		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			logger.debug("MyInterceptor2.postHandle call");
			super.postHandle(request, response, handler, modelAndView);
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			logger.debug("MyInterceptor2.afterCompletion call");
			super.afterCompletion(request, response, handler, ex);
		}

	}

