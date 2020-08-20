package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
	
	private SqlSession session;
	
	public BoardDAO() {
		this.session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void work() {
		
//		session.insert("dao.BoardDAO.insertBoard");
//		//자동커밋 아니어서 커밋해줘야함
//		session.commit();
		
		BoardVO board = new BoardVO();
		board.setTitle("삽입연습...");
		board.setWriter("user");
		board.setContent("VO이용하여 삽입~~");
		
		
		session.insert("dao.BoardDAO.insertBoard2", board);
		session.commit();
		
		System.out.println("삽입완료!");
	}

}