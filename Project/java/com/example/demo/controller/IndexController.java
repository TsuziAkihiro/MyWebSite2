package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Article;
import com.example.demo.entity.ArticleRepository;
import com.example.demo.entity.User;

@Controller
public class IndexController {


	@Autowired
	ArticleRepository artRepo;

	@Autowired
	HttpSession session;

	@GetMapping("/Index")
	public ModelAndView indexGet(ModelAndView model) {

		User u = (User)session.getAttribute("user");

		if("admin".equals(u.getUser_id())) {

			// 画面描画用のテンプレート名を指定
			model.setViewName("redirect:Management");
			return model;

		}else {



			// 記事リスト取得
			List<Article> artList = artRepo.findAll();

			// 取得したリストをモデルに設定
			model.addObject("artList", artList);

			// 画面描画用のテンプレート名を指定
			model.setViewName("Index");
			return model;

		}
	}

	@GetMapping("/Delete")
	public ModelAndView delete(ModelAndView model) {


		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Index");
		return model;
	}
}
