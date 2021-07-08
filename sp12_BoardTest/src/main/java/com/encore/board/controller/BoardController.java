package com.encore.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.board.domain.BoardVO;
import com.encore.board.domain.MemberVO;
import com.encore.board.model.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public String write(BoardVO bvo, HttpSession session, Model model) throws Exception { // bvo는 자동바인딩 되어 객체로 리턴됨
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if(mvo==null) return "redirect:index"; // 로그인 상태가 아니다
		
		bvo.setMemberVO(mvo); // boardVO가 memberVO를 hasing함
		System.out.println(bvo);
		model.addAttribute("bvo", bvo);
		boardService.write(bvo);
		return "board/show_content";
	}
	
	@RequestMapping("list.do")
	public String showList(Model model) {
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO vo : boardList) System.out.println(vo);
		model.addAttribute("list", boardList);
		return "board/list";
	}
	
	@RequestMapping("showContent.do")
	public String boardDetail(int no, Model model) {
		boardService.plusCount(no);
		BoardVO bvo = boardService.getBoard(no);
		System.out.println(bvo);
		model.addAttribute("bvo", bvo);
		return "board/show_content";
	}
	
	
	
	@RequestMapping("delete.do")
	public String deleteBoard(int no, Model model) {
		boardService.deleteBoard(no);
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("list", boardList);
		return "board/list";
	}
	
	@RequestMapping("updateView.do")
	public String pageToUpdate(int no, Model model) {
		BoardVO bvo = boardService.getBoard(no);
		model.addAttribute("bvo", bvo);
		return "board/update";
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO bvo, Model model) {
		boardService.updateBoard(bvo);
		bvo = boardService.getBoard(bvo.getNo());
		model.addAttribute("bvo", bvo);
		return "board/show_content";
	}
}
