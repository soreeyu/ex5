package com.choa.ex5;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;

import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

public class StudentServiceTest extends MyAbstractTest{

	
	@Inject
	private StudentServiceImpl studentServiceImpl;
	private static StudentDTO studentDTO;
	
	@Test
	public void insertService() throws Exception{
		//studentServiceImpl.joinService(studentDTO);
		int result = studentServiceImpl.joinService(studentDTO);
		
		assertEquals(1, result);
	}
	
	
	@BeforeClass
	public static void serviceTest(){
		studentDTO = new StudentDTO();
		studentDTO.setId("st316362");
		studentDTO.setPw("st316362");
		studentDTO.setName("st316362");
		studentDTO.setAge(30);
		studentDTO.setGrade("s");
		studentDTO.setSid("st316362");
		studentDTO.setPhone("2020");
		studentDTO.setfileName("hi");
		studentDTO.setoriName("ohi");
		studentDTO.setTid("iu");
		
	}
}
