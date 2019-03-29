package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleRepository;
import com.example.demo.entity.User;
import com.example.demo.form.ArticleForm;

@Controller
public class WriteController {


	@Autowired
	ArticleRepository artRepo;

	@Autowired
	HttpSession session;

	@ModelAttribute("articleForm")
    public ArticleForm setupForm() {
        ArticleForm article = new ArticleForm();
        return article;
    }

	@GetMapping("/Write")
	public ModelAndView WriteGet(ModelAndView model) {


		User u = (User)session.getAttribute("user");

		if(u == null){
			// セッションにログイン情報がない場合ログイン画面へ
			model.setViewName("redirect:/");
			return model;
		}

		// 画面描画用のテンプレート名を指定
		model.setViewName("Write");
		return model;
	}

	@PostMapping("/Write")
	public ModelAndView WritePost(ModelAndView model
			,@ModelAttribute ArticleForm articleForm
			) {

		User u = (User) session.getAttribute("user");

		Article article = new Article();
		article.setUser_id(u.getUser_id());
		article.setTitle(articleForm.getTitle());
		article.setText(articleForm.getText());
		article.setCreateDate(new Date());

		// 登録
		artRepo.save(article);

		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Index");
		return model;
	}
}
