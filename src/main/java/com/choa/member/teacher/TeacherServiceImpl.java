package com.choa.member.teacher;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.choa.member.MemberDTO;
import com.choa.member.MemberService;
import com.choa.util.FileSaver;

@Service
public class TeacherServiceImpl implements MemberService{

	@Inject
	private TeacherDAOImpl teacherDAOImpl;
	
	@Override
	public int joinService(MemberDTO memberDTO, HttpSession session) throws Exception {
		FileSaver fs = new FileSaver();
		String fileName = fs.filesave(session.getServletContext().getRealPath("resources/upload"), memberDTO.getF1());
		memberDTO.setfileName(fileName);
		memberDTO.setoriName(memberDTO.getF1().getOriginalFilename());
		
		return teacherDAOImpl.memberJoin(memberDTO);
	}

	@Override
	public MemberDTO loginService(MemberDTO memberDTO) throws Exception {
		return teacherDAOImpl.memberLogin(memberDTO);
	}

	@Override
	public MemberDTO memberPage(MemberDTO memberDTO) throws Exception {
		return teacherDAOImpl.memberPage(memberDTO);
	}


}
