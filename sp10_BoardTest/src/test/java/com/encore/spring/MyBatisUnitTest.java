package com.encore.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.spring.domain.Board;


public class MyBatisUnitTest {

	public static void main(String[] args) throws Exception{
		//1. 설정문서 읽어들여서
				Reader r = Resources.getResourceAsReader("spring/SqlMapConfig.xml");
				//2. SqlSessionFactory
				SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(r);
				//3. SqlSession
				SqlSession session= factory.openSession();
				//4. 쿼리문 수행..
				List<Board> list=session.selectList("BoardMapper.selectAll");
				for(Board vo: list) System.out.println(vo);
				
				System.out.println("\n=============================\n");
				
				//Board b = new Board(2,"encore","안녕하세요","게시글입니다", "path");
//				session.insert("BoardMapper.insert", b);

				Board board=session.selectOne("BoardMapper.selectOne",1);
				System.out.println(board);
				
				System.out.println("\n=============================\n");
	
				List<Board> list2=session.selectList("BoardMapper.selectAll");
				for(Board vo: list2) System.out.println(vo);
				
	}

}
