package com.bitacademy.myportal.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {
	private static String SAVE_PATH = "/upload";
	private static final Logger logger = LoggerFactory.getLogger(FileuploadService.class);
	
	public String store(MultipartFile mFile) {
		//실제 클라이언트에서의 파일 이름
		//rename이 필요할 것 같음
		String originalFilename = mFile.getOriginalFilename();
		Long size = mFile.getSize();
		String savedFilename = "";
		
		logger.debug("원본 파일명:" + originalFilename);
		logger.debug("파일의 사이즈" + size);
		
		//파일명 변경
		//확장자 분리
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		logger.debug("파일의 확장자:"+ extName);
		//파일명 생성 (시스템 날짜를 기준으로 생성)
		Calendar cal = Calendar.getInstance();
		savedFilename = String.valueOf(cal.getTimeInMillis()) +extName;
		logger.debug("새로 만든 파일명:" + savedFilename);
		
		try {
		writeFile(mFile, savedFilename);
		}catch(Exception e) {
			throw new RuntimeException(e);
			//익셉션의 전환 : 커스텀 익셉션 만들어 처리할 것을 권장
		}
		return savedFilename;
	}

	// 실제 저장을 위한 메서드
		private void writeFile(MultipartFile mFile, String saveFilename) throws IOException{
			byte[] fileData = mFile.getBytes();
			
			//저장을 위해 FileoutputStream을 생성
			FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			fos.write(fileData);
			fos.close();
		}
		
}
