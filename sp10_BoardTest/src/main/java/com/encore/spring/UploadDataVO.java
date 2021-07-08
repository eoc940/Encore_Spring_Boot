package com.encore.spring;

import org.springframework.web.multipart.MultipartFile;

//폼에 대한 정보를 저장하는 vo
public class UploadDataVO {
	private String userName; //사용자명을 입력받는 폼
	
	
	//업로드된 파일을 저장하는 변수를 하나 지정
	private MultipartFile uploadFile;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public MultipartFile getUploadFile() {
		return uploadFile;
	}


	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	
}
