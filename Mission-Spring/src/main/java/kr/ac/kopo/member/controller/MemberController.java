package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//mav에 addObject하는 애들은 다 request, 단 이름이 "loginVO"인 경우 session 영역에 등록시킨다!!!! (배열형태) - 단, 이 경우 session.invalidate로 삭제가 안됨!!!
//@SessionAttributes({"loginVO", "msg", ...})에 등록될 경우 session에 저장됨
@SessionAttributes({"loginVO"})
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
//	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login")
//	@RequestMapping(value="/login", method= RequestMethod.POST)
	public ModelAndView login(MemberVO member, HttpSession session) {
		
		MemberVO loginVO = memberService.login(member);
		ModelAndView mav = new ModelAndView();
		
		if(loginVO == null) {
			//로그인 실패
			mav.setViewName("redirect:/login");
		}else {
			//로그인성공
			String dest = (String)session.getAttribute("dest");
			if(dest == null) {
				//로그인 인터셉터 안거친것 - 메인페이지로가면됨
				mav.setViewName("redirect:/");
			}else {
				//로그인 인터셉터 거친 것
				mav.setViewName("redirect:" + dest);
				session.removeAttribute("dest");
			}
			
			mav.addObject("loginVO", loginVO);
		}
		return mav;
	}
	     
	//SessionAttributes로 등록할 경우에는 sessionstatus로 삭제해야 함
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		
		//session은 안에 아무것도 없는게 complete하다고 생각~! complete으로 session안에 삭제
		status.setComplete();
		
		return "redirect:/";
	}
}
