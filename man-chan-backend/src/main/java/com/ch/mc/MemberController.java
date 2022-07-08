package com.ch.mc;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.mc.model.Member;
import com.ch.mc.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// 회원가입 입력
	@RequestMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	// 아이디 중복체크
	@RequestMapping(value= "idChk", produces = "text/html;charset=utf-8")
	@ResponseBody  // jsp를 통하지않고 직접 문자를 전달
	public String idChk(String id) {
		String msg = "";
		Member member = ms.select(id);
		if (member == null) msg = "사용가능한 아이디입니다.";
		else msg = "이미 사용 중인 아이디입니다.";
		return msg;		
	}
	
	// 별명 중복체크
	@RequestMapping(value= "member/nickNameChk", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String nickNameChk(String nickName) {
		String msg = "";
		Member member = ms.selectNickName(nickName);
		if (member == null) msg = "사용가능한 별명입니다.";
		else msg = "이미 사용 중인 별명입니다.";
		return msg;		
	}
	
	// 회원가입 결과
	@RequestMapping("join")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		Member member2 = ms.select(member.getId());
		Member member3 = ms.selectNickName(member.getNickName());
		if (member2 == null && member3 == null) {
			// BCryptPasswordEncoder를 이용한 암호화
			String encPassword = passwordEncoder.encode(member.getPassword());
			member.setPassword(encPassword);
			result = ms.insert(member);
		} else if (member2 != null) {
			result = -1; // 이미 가입된 아이디
		} else if (member3 != null) {
			result = -2; // 이미 가입된 닉네임
		}
		model.addAttribute("result", result);
		return "join";
	}
	
}
