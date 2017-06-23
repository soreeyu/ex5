package com.choa.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.member.MemberDTO;
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
	
	@RequestMapping(value="MemberPage", method=RequestMethod.GET)
	public void studentPage(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberDTO memberDTO2=studentServiceImpl.memberPage(memberDTO);//덮어쓰면 안되니 새로운 객체 생성
		model.addAttribute("student", memberDTO2);
	}
	//학생 로그인
	//memberLogin 받아주는 페이지
	@RequestMapping(value="studentLogin")
	public String studentLogin(){
		
		return "member/MemberLogin";
	}
			
	@RequestMapping(value="/studentLogin", method=RequestMethod.POST)
	public ModelAndView studentLogin(Model model, MemberDTO memberDTO,HttpSession session) throws Exception{
		memberDTO=studentServiceImpl.loginService(memberDTO);
		String message = "로그인 실패";
		if(memberDTO != null){
			session.setAttribute("member", memberDTO);
			message= "로그인 성공";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", message);
		mv.addObject("path","../");
		mv.setViewName("common/result");
		return mv;
	}
			//학생 로그아웃
			@RequestMapping(value="memberLogout")
			public String memberLogout(HttpSession session){
				session.invalidate();
				return "redirect:/";
			}

	@RequestMapping(value="/studentJoin", method=RequestMethod.POST)
	public String studentJoin(Model model,StudentDTO studentDTO, HttpSession session) throws Exception{
		System.out.println("student@@@@@@@@@@@@");
		int result =studentServiceImpl.joinService(studentDTO, session);
		String messege="FAIL";
		if(result > 0){
			messege ="SUCCESS";
		}
		
		model.addAttribute("messege", messege);
		model.addAttribute("path", "../");
		return "common/result";
	}
}
