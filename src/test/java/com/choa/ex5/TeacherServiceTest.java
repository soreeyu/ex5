package com.choa.ex5;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;

import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

public class TeacherServiceTest extends MyAbstractTest{

	@Inject
	private TeacherServiceImpl teacherServiceImpl;
	private static TeacherDTO teacherDTO;
	
	@Test
	public void joinTeacher() throws Exception{
		int result = teacherServiceImpl.joinService(teacherDTO);
		
		assertEquals(1, result);
	}
	
	@BeforeClass
	public static void teacher(){
		teacherDTO = new TeacherDTO();
		teacherDTO.setId("t22532");
		teacherDTO.setPw("t22532");
		teacherDTO.setName("t22532");
		teacherDTO.setAge(30);
		teacherDTO.setGrade("t");
		teacherDTO.setTid("t22532");
		teacherDTO.setSubject("korea");
		teacherDTO.setfileName("hi");
		teacherDTO.setoriName("ohi");
	}
	
}
