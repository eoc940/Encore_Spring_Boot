package com.encore.spring;

import org.springframework.web.multipart.MultipartFile;

//���� ���� ������ �����ϴ� vo
public class UploadDataVO {
	private String userName; //����ڸ��� �Է¹޴� ��
	
	
	//���ε�� ������ �����ϴ� ������ �ϳ� ����
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
