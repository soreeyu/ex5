package com.choa.ex5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.member.student.StudentDAOImpl;
import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

public class StudentDAOTest extends MyAbstractTest{

	@Inject
	private StudentDAOImpl studentDAOImpl;
	private static StudentDTO studentDTO;
	
	@Test
	public void joinStudent() throws Exception{
			int result = studentDAOImpl.memberJoin(studentDTO);
		
		assertEquals(0, result);
	}
	
	@BeforeClass
	public static void test(){
		studentDTO = new StudentDTO();
		studentDTO.setId("st6362");
		studentDTO.setPw("st6362");
		studentDTO.setName("st6362");
		studentDTO.setAge(30);
		studentDTO.setGrade("s");
		studentDTO.setSid("st6362");
		studentDTO.setPhone("2020");
		studentDTO.setfileName("hi");
		studentDTO.setoriName("ohi");
		studentDTO.setTid("iu");
		
		
	}
}
