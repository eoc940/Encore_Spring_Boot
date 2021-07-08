package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Board;
import com.encore.spring.service.BoardService;
import com.encore.spring.UploadDataVO;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("boardInput.do")
	public ModelAndView boardInput() {		
		System.out.println("boardInput.do method in");
		
		return new ModelAndView();
	}

	@RequestMapping("boardInsert.do")
	public ModelAndView boardInsert(HttpServletRequest request,HttpSession session, Board vo) throws Exception {
		String msg ="";
		String path="Error";
		List<Board> list=null;
		
		MultipartFile mFile = vo.getUploadFile();
		String fileName = "";
//		System.out.println("vo: "+vo);
//		System.out.println("UploadFile Name: "+mFile.getOriginalFilename());
		
		if((mFile.isEmpty())!=true) {
			fileName = mFile.getOriginalFilename();
			System.out.println("UploadFile Name: "+fileName);
		}
		
		// 3. ���ε��� ������ ������ ��ο��� copy�ؼ� �̵���Ŵ.
		String root = request.getSession().getServletContext().getRealPath("/");
//		System.out.println("ROOT:: "+root);
		String filepath = root+"\\upload\\";
//		String filepath1 = root+"\\upload\\";
		
		// 4. File ��ü ����... transferTo()
		File copyFile = new File(filepath+mFile.getOriginalFilename());
		mFile.transferTo(copyFile); // ���ε��� ������ ī�Ǻ��� �ش� ��ο� ����ȴ�. �̵��Ѵ�
//		System.out.println("path:: "+filepath);
		session.setAttribute("filepath", filepath);

		
		Board board = new Board(vo.getId(), vo.getTitle(), vo.getContents(), fileName);
		System.out.println("board: "+board);
		try {
			boardService.insert(board);
			list=boardService.selectAll();
			path="boardList";
		} catch (Exception e) {
			System.out.println(e);
			msg="�Խñ� ���� �� ���� �߻�..";
		}
		session.setAttribute("msg", msg);
		return new ModelAndView(path,"list",list);
		
	}

	@RequestMapping("boardList.do")
	public ModelAndView boardList(HttpSession session) throws Exception {
		String msg ="";
		String path="Error";
		System.out.println("boardList.do method in");
		List<Board> list=null;
		try {
			list=boardService.selectAll();
			path="boardList";
		} catch (Exception e) {
			System.out.println(e);
			msg="�Խñ� �ҷ����� �� ���� �߻�..";
		}
		session.setAttribute("msg", msg);
		return new ModelAndView(path,"list",list);

	}

	@RequestMapping("boardDetail.do")
	public ModelAndView boardDetail(String no, HttpSession session) throws Exception {
		String msg ="";
		String path="Error";
		Board vo = null;
		try {
			vo =boardService.selectOne(no);
			path="boardDetail";
		}catch(Exception e) {
			System.out.println(e);
			msg="�Խñ� �ε��� ������ �߻��Ͽ����ϴ�.";
			
		}
		session.setAttribute("msg", msg);
		return new ModelAndView(path,"vo",vo);
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(HttpServletRequest request, String filename) throws Exception{
		System.out.println("filename:: "+filename);
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		System.out.println("download path "+path);
		HashMap map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView", map);
	}
}
