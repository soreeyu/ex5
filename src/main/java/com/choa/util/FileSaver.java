package com.choa.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

//세이브 전용 클래스
public class FileSaver {
	
	public String filesave(String realPath, String oriName, byte [] fileData) throws Exception{
		File file = new File(realPath);
		
		if(!file.exists()){
			file.mkdirs();
		}
		//upload 폴더에 저장되는 실제 파일 이름
		String fileName = UUID.randomUUID().toString()+"_"+oriName;
		File taget = new File(file, fileName);
		FileCopyUtils.copy(fileData, taget);
		
		return fileName;
		
	}
}
