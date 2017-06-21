package com.choa.ex5;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.util.FileSaver;

@Controller
public class FileUploadController {

	@RequestMapping("/test/fileUpForm")
	public void fileUp(){
		
	}
	
	//1.MultipartHttpServletRequest 사용 하는 방법
	//@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload1(String name , MultipartHttpServletRequest request) throws Exception{
		System.out.println("NAME : "+ name);
		
		MultipartFile f = request.getFile("f1");
		System.out.println("GET NAME : "+f.getName()); //파라미터 이름
		System.out.println("ORI NAME : "+f.getOriginalFilename());//파일의 이름
		System.out.println("size : "+ f.getSize()); //파일의 사이즈
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		FileSaver fs = new FileSaver();	//파일 저장하는 클래스
		fs.filesave(path, f.getOriginalFilename(), f.getBytes());
	}
	
	
	
	
	//2.MultipartFile 사용 하는 방법
	//@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload2(String name, MultipartFile f1, HttpSession session) throws Exception{ //처음부터 MultipartFile 이걸로 받아오는데 변수명을 파라미터 이름과 동일하게 한다.
		System.out.println("GET NAME : "+f1.getName()); //파라미터 이름
		System.out.println("ORI NAME : "+f1.getOriginalFilename());//파일의 이름
		System.out.println("size : "+ f1.getSize()); //파일의 사이즈
		String path = session.getServletContext().getRealPath("resources/upload");
		FileSaver fs = new FileSaver();
		fs.filesave(path, f1.getOriginalFilename(), f1.getBytes());
	}
	
	//3. DTO
	@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUplopad3(FileDTO fileDTO, HttpSession session) throws Exception{
		String path = session.getServletContext().getRealPath("resources/upload");
		FileSaver fs = new FileSaver();
		String oriName = fileDTO.getF1().getOriginalFilename();
		byte [] fileData = fileDTO.getF1().getBytes();
		fs.filesave(path, oriName, fileData);
	}
	
	
	/*//파일을 디스크에 저장하는 메서드
	private String upload1(MultipartFile f, String path) throws Exception{
			System.out.println(path);
			String fileName = UUID.randomUUID().toString(); //랜덤아이디 만들기
			System.out.println(fileName);
			fileName = fileName+"_"+f.getOriginalFilename();
			File file = new File(path, fileName);
			
			FileCopyUtils.copy(f.getBytes(), file);	//스프링 프레임 워크에서 제공하는 파일 저장클래스
			
			return fileName;
	}*/
}
