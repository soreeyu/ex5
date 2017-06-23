package com.choa.member.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.member.MemberDTO;
import com.choa.member.MemberService;
import com.choa.util.FileSaver;

@Service
public class StudentServiceImpl implements MemberService{

	@Autowired
	StudentDAOImpl studentDAOImpl;
	
	//join
	@Override
	public int joinService(MemberDTO memberDTO, HttpSession session) throws Exception {
		FileSaver	fs = new FileSaver(); //여러곳에서 쓰지 않으니,, @respository 안씀
		String fileName =fs.filesave(session.getServletContext().getRealPath("resources/upload"), memberDTO.getF1());
		memberDTO.setoriName(memberDTO.getF1().getOriginalFilename());
		memberDTO.setfileName(fileName);
		return studentDAOImpl.memberJoin(memberDTO);
	}
	//login
	@Override
	public MemberDTO loginService(MemberDTO memberDTO) throws Exception {
		
		return studentDAOImpl.memberLogin(memberDTO);
	}

	//mypage
	@Override
	public MemberDTO memberPage(MemberDTO memberDTO) throws Exception {
		return studentDAOImpl.memberPage(memberDTO);
	}

}
