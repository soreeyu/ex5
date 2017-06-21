package com.choa.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class TeacherController {

	@Inject
	private TeacherServiceImpl teacherServiceImpl;
	

	@RequestMapping(value="/teacherJoin", method=RequestMethod.POST)
	public String studentJoin(Model model,TeacherDTO teacherDTO) throws Exception{
		System.out.println("teacher@@@@@@@@@@@@@@@");
		int result = teacherServiceImpl.joinService(teacherDTO);
		String messege="FAIL";
		if(result > 0){
			messege ="SUCCESS";
		}
		
		model.addAttribute("messege", messege);
		model.addAttribute("path", "../");
		return "common/result";
	}
}
