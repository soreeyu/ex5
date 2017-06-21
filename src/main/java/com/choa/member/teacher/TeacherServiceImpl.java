package com.choa.member.teacher;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.member.MemberDTO;
import com.choa.member.MemberService;

@Service
public class TeacherServiceImpl implements MemberService{

	@Inject
	private TeacherDAOImpl teacherDAOImpl;
	
	@Override
	public int joinService(MemberDTO memberDTO) throws Exception {
		return teacherDAOImpl.memberJoin(memberDTO);
	}

}
