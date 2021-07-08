package com.encore.board.domain;
/*
 * 게시글에 대한 정보를 담고 있는 클래스
 * 해당 게시글은 로그인한 사람만 쓸수있다.
 * ::
 * BoardVO와 MemberVO는 무슨관계??-----Hasing 관계
 */
public class BoardVO {
	
	private int no;
	private String title;
	private String content;
	private int count;
	private String writeDate;
	
	private MemberVO memberVO;

	public BoardVO(int no, String title, String content, int count,
			String writeDate, MemberVO memberVO) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
		this.memberVO = memberVO;
	}

	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String content, int count,
			String writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content="
				+ content + ", count=" + count + ", writeDate=" + writeDate
				+ ", memberVO=" + memberVO + "]";
	}	
}

















