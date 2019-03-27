package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.ArticleForm;

@Controller
public class WriteController {
//
//	@Autowired
//	TaskRepository taskRepo;

	@ModelAttribute("articleForm")
    public ArticleForm setupForm() {
        ArticleForm article = new ArticleForm();
        return article;
    }

	@GetMapping("/Write")
	public ModelAndView WriteGet(ModelAndView model) {


		// 画面描画用のテンプレート名を指定
		model.setViewName("Write");
		return model;
	}

	@PostMapping("/Write")
	public ModelAndView WritePost(ModelAndView model,
			@ModelAttribute ArticleForm articleForm
			) {


		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Index");
		return model;
	}
}
