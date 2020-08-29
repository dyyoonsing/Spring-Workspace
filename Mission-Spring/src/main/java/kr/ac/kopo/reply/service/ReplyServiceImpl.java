package kr.ac.kopo.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	@Transactional
	public void insertReply(ReplyVO replyVO) {
		replyDAO.insert(replyVO);
		boardDAO.incrementReplyCnt(replyVO.getBoardNo());
	}

	@Override
	public List<ReplyVO> selectAllByBoardNo(int boardNo) {
		
		return replyDAO.selectAll(boardNo); 
	}
	
	/**
	 * 1. DB에서 해당 댓글 삭제(t_reply)
	 * 2. DB에서 해당 게시물 댓글 카운트 감소(t_board)
	 */
	@Override
	public void deleteReply(int replyNo) {
		replyDAO.delete(replyNo);
		//이건 결국 board번호 알아와야겠네! -> boardDAO.reduceReplyCnt(boardNo); 
		
	}

	@Override
	@Transactional
	public void removeReply(ReplyVO replyVO) {
		replyDAO.delete(replyVO.getNo());
		boardDAO.reduceReplyCnt(replyVO.getBoardNo());
	}

}
