package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.model.StudentDto;


@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	private String viewURL = "student/%s";
	
	/*
	 * "/student/" 또는 "/student"로 요청이 되면
	 */
	
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String list() {
		return String.format(viewURL,"list");
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return String.format(viewURL,"input");
	}
	/*
	 * form의 input box에 입력된 데이터(문자열)은 controller method의 매개변수와 1:1로 매칭된다
	 * 이때 input box의 name속성은 Dto클래스의 변수명과 일치해야 한다
	 * @ResponseBody
	 * method 문자열을 return하면 원래는 view/*.jsp 파일을 찾아서 rendering한 후
	 * client로 보낸다. 하지만 @ResponseBody가 설정되면,
	 * 문자열을 Http 프로토콜의 Response영역에 그대로 실어서 client로 보낸다
	 */
	@ResponseBody // 문자열을 그대로 리턴
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute StudentDto stDto) {
		System.out.println(stDto.toString());
		return stDto.toString(); // 문자열을 리턴
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return String.format(viewURL,"update");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(StudentDto stDto) {
		return "redirect:/detail";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(String stNum) {
		return String.format(stNum,"detail");
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		// "/student" URL로 화면을 전환하라
		return "redirect:/student";
	}
	
}
