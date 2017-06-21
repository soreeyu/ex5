package com.choa.member.student;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;

@Repository
public class StudentDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession SqlSession;
	private final String NAMESPACE="StudentMapper.";
	private final String NAMESPACE2="MemberMapper.";
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		int result =SqlSession.insert(NAMESPACE2+"joinMember", memberDTO);
		
		if(result > 0){
			result = SqlSession.insert(NAMESPACE+"joinStudent", memberDTO);
		}
		return result;
	}

}
