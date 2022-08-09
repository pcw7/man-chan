package com.ch.mc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String insert(@RequestParam("file") MultipartFile mf, Article article, HttpSession session, Model model) throws IOException {
        String fileName = mf.getOriginalFilename(); // 원래 파일명
        System.out.println(fileName);
		String real = session.getServletContext().getRealPath("/resources/upload");
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
		fos.write(mf.getBytes());
		fos.close();
		int fileSize = (int)mf.getSize();
		
		String member_id = (String) session.getAttribute("id");
		article.setMember_id(member_id);
		article.setThumbnail(fileName);
        int result = as.insert(article);
//        model.addAttribute("fileName", fileName);
//        model.addAttribute("fileSize", fileSize);
//        model.addAttribute("article", article);
        model.addAttribute("result", result);
        return "insert"; 
    }
	
}