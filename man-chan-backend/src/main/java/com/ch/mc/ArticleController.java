package com.ch.mc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mc.model.Article;
import com.ch.mc.model.Member;
import com.ch.mc.service.ArticleService;
import com.ch.mc.service.MemberService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService as;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("insertForm")
	public String insertForm(int ano, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		model.addAttribute("ano", ano);
		return "insertForm";
	}
	
	@RequestMapping("insert")
	public String insert(Article article, HttpSession session, Model model) throws IOException {
		String member_id = (String) session.getAttribute("id");
		article.setMember_id(member_id);
        int result = as.insert(article);
        model.addAttribute("result", result);
        return "insert"; 
    }
	
}