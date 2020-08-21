package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.ac.kopo.MyConfig;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
	
	private SqlSession session;
	
	public BoardDAO() {
		this.session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void work() {
//		insert();
//		select();
//		selectOne();
//		selectWhere();
//		selectWhere2();
		selectNos();
//		selectMap();
//		selectMap2();
	}
	
	@Test
	public void selectMap2() {
		
		  //12번 게시물 조회 
//		  Map<String, Object> map = session.selectOne("dao.boardDAO.selectMap2", 12); 
//		  Set<String> keys =  map.keySet(); 
//		  for(String key : keys) { System.out.println(key); }
		 
		
		 //게시물 2번 조회
	      Map<String,Object> map = session.selectOne("dao.BoardDAO.selectMap2",2);
	      Set<String> keys = map.keySet();
	      for(String key : keys) {  //key는 컬럼명 & alias(view_cnt아닌 viewCnt) 값이 들어갈 것
	         System.out.println(key+" : "+map.get(key));  
	      }
	}
	
	private void selectMap() {
		
		Map<String, String> map = new HashMap<>();
		map.put("title", "mybatis");
		map.put("writer", "hong");
		
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectMap", map);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	private void selectNos() {
		int[] nos = {1, 2, 6, 8, 10, 13, 12};
		
		BoardVO vo = new BoardVO();
		vo.setNos(nos);
		
//		List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos", vo);
//		List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos2", nos);
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos3", nos);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	private void selectWhere2() {
		//제목이 '제목'으로 시작하고 사용자가 user인 게시글 조회
		BoardVO vo = new BoardVO();
		vo.setTitle("제목");
		vo.setWriter("user");
		
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectWhere2", vo);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	private void selectWhere() {
		BoardVO vo = new BoardVO();
		//방법1. 제목이 myBatis, 작성자 hong인 게시글 조회
//		vo.setTitle("mybatis");
//		vo.setWriter("hong");
		
		//방법2. 작성자가 'user'인 게시글 조회 - and 자동제거
//		vo.setWriter("user");
		
		//방법3. 제목이 삽입연습...인 게시글 조회
		vo.setTitle("삽입연습...");
		
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectWhere", vo);
		for(BoardVO board : list) {
			System.out.println(board);
		}
		
	}
	
	private void selectOne() {
		//2번 게시글 조회
//		BoardVO board = session.selectOne("dao.BoardDAO.selectByNo", 2);
		BoardVO vo = new BoardVO();
		vo.setNo(5);
		BoardVO board = session.selectOne("dao.BoardDAO.selectByNo3", vo);
		System.out.println(board);
		
	}
	
	private void insert() {
		
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
	
	private void select() {
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectBoard");
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}

}