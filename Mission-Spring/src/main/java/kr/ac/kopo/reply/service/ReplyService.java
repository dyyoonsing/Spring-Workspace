package kr.ac.kopo.reply.service;

import java.util.List;

import kr.ac.kopo.reply.vo.ReplyVO;

public interface ReplyService {
	
	void insertReply(ReplyVO replyVO);
	List<ReplyVO> selectAllByBoardNo(int boardNo);
	void deleteReply(int replyNo);
	void removeReply(ReplyVO replyVO);

}
