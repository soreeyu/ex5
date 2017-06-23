package com.choa.member;

import javax.servlet.http.HttpSession;

public interface MemberService {

	
	//Join Service
	public int joinService(MemberDTO memberDTO, HttpSession session) throws Exception;
	
	//login
		public MemberDTO loginService(MemberDTO memberDTO)throws Exception;
		
		//page
		public MemberDTO memberPage(MemberDTO memberDTO) throws Exception;
}
