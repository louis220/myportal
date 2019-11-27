package com.bitacademy.myportal.exception;

//java가 기본적으로 제송하는 예외, 특히 runtimeexception은 일반적인 상황에서의 예외처리이기때문에 실제 구체적인 상황에서는 
// 사용자가 상황에 맞는 exception을 만들어서 사용하는 것이 좋다
public class CustomException extends RuntimeException {
	// TODO: 필드 +getter/setter등을 이용하여
	// 예외 발생 상황에 정보들을 추가로 담아두는 것이 좋다
	public CustomException() {
		super("CustomException 발생!");
	}
	public CustomException(String message) {
		super(message);
	}
	
}
