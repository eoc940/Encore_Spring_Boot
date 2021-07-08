package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.UploadDataVO;

@Controller
public class FileController {
	
	@RequestMapping("fileUpload.do")
	public ModelAndView fileUpload(HttpServletRequest request, UploadDataVO vo) throws Exception {
		// 1. 업로드된 파일의 정보를 가지고 있는 MultipartFile을 하나 받아온다... vo에서
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("mFile :: " + mFile);
		
		/*
		 * 2. 업로드된 파일이 있다면
		 *    파일의 사이즈
		 *    업로드한 파일의 이름
		 *    업로드한 파일의 파라미터명
		 */
		if((mFile.isEmpty()) != true) { //업로드된 파일이 있다면
			System.out.println("파일의 사이즈 :: " + mFile.getSize());
			System.out.println("업로드된 파일명 :: " + mFile.getOriginalFilename());
			System.out.println("파일의 파라미터명 :: " + mFile.getName());
		}
		
		// 3. 업로드한 파일을 지정한 경로에다 copy해서 이동시킴.../upload/copy해온 파일이 저장됨
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		
		// 4. File 객체 생성...mFile.transferTo()
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile); // 업로드한 파일의 카피본이 해당경로에 저장된다...이동한다
		System.out.println("path :: " + path);

		return new ModelAndView("upload_result", "uploadfile", mFile.getOriginalFilename());
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(HttpServletRequest request, String filename) throws Exception {
		System.out.println("filename :: " + filename);
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		System.out.println("downpath :: " + path);
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView", map);
	}
	
}
