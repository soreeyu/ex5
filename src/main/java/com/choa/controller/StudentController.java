package com.choa.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class StudentController {
	
	@Inject
	private StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void studentJoin(){
		
	}
	
	

	@RequestMapping(value="/studentJoin", method=RequestMethod.POST)
	public String studentJoin(Model model,StudentDTO studentDTO) throws Exception{
		System.out.println("student@@@@@@@@@@@@");
		int result =studentServiceImpl.joinService(studentDTO);
		String messege="FAIL";
		if(result > 0){
			messege ="SUCCESS";
		}
		
		model.addAttribute("messege", messege);
		model.addAttribute("path", "../");
		return "common/result";
	}
}
