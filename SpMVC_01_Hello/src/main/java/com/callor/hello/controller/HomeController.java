package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.model.StudentDto;
import com.callor.hello.service.StudentService;


@Controller
public class HomeController {
	/*
	 * Spring Project에서 가장 많이 보이는 에러 메시지
	 * No qualifying bean of type 'com.callor.hello.service.StudentService'
	 * 
	 * HomeController 에서 StudentService 클래스로 만들어진 bean(객체, 컴포넌트)를 사용하겟다고
	 * Spring에게 달라고 요청을 함
	 * 
	 * 그런데 어떤 이유로 StudentService 클래스의 bean이 생성이 안되었을때 보여지는 에러메시지이다
	 * 
	 * 이 메시지의 대부분의 원인이 bean을 생성할 클래스에
	 * @Annotation이 누락된 경우이다
	 */
	
	private final StudentService studentService;
	public HomeController(StudentService studentService) {
		this.studentService = studentService; // 이름이 같아야하니까
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		StudentDto stDto = studentService.getStudent();
		
		return "home";
	}
	
}
