package kr.ac.kopo.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@CrossOrigin
@RestController
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@PostMapping("/reply")
	public void addReply(ReplyVO replyVO) {
		
		replyService.insertReply(replyVO);
	}
	
	@GetMapping("/reply/{boardNo}")
	public List<ReplyVO> getList(@PathVariable("boardNo") int boardNo){
		
		//System.out.println("조회할 게시물 번호 : " + boardNo);
		
		return replyService.selectAllByBoardNo(boardNo);
	}
	
	//@RequestMapping(value="/reply/{replyNo}", method=RequestMethod.DELETE)
	@DeleteMapping("/reply/{replyNo}")
	public void delete(@PathVariable("replyNo") int replyNo) {
		//System.out.println("삭제할 댓글 번호 : " + replyNo);
		replyService.deleteReply(replyNo);
		
	}
	
	
	@DeleteMapping("/reply/{replyNo}/{boardNo}")
	public void deleteReply(@PathVariable("replyNo") int replyNo, @PathVariable("boardNo") int boardNo) {
		System.out.println(replyNo + " : " + boardNo);
		
		ReplyVO replyVO = new ReplyVO();
		replyVO.setNo(replyNo);
		replyVO.setBoardNo(boardNo);
		
		replyService.removeReply(replyVO);
	}
}
