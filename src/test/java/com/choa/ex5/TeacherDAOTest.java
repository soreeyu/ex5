package com.choa.ex5;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;

import com.choa.member.student.StudentDAOImpl;
import com.choa.member.teacher.TeacherDAOImpl;
import com.choa.member.teacher.TeacherDTO;

public class TeacherDAOTest extends MyAbstractTest{

	@Inject
	private TeacherDAOImpl teacherDAOImpl;
	private static TeacherDTO teacherDTO;
	
	@Test
	public void joinTeacher() throws Exception{
		int result = teacherDAOImpl.memberJoin(teacherDTO);
		
		assertEquals(1, result);
	}
	
	@BeforeClass
	public static void test(){
		teacherDTO = new TeacherDTO();
		teacherDTO.setId("t222232");
		teacherDTO.setPw("t222232");
		teacherDTO.setName("t222232");
		teacherDTO.setAge(30);
		teacherDTO.setGrade("t");
		teacherDTO.setTid("t222232");
		teacherDTO.setSubject("korea");
		teacherDTO.setfileName("hi");
		teacherDTO.setoriName("ohi");
	}
}
