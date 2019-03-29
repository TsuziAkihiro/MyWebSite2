package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;

@Controller
public class ManagementController {

	@Autowired
	HttpSession session;

//	@Autowired
//	TaskRepository taskRepo;

//	@ModelAttribute("sampleForm")
//    public SampleForm setupForm() {
//        SampleForm sample = new SampleForm();
//        return sample;
//    }

	@GetMapping("/Management")
	public ModelAndView managementGet(ModelAndView model) {


		User u = (User)session.getAttribute("user");

		if(u == null){
			// セッションにログイン情報がない場合ログイン画面へ
			model.setViewName("redirect:/");
			return model;
		}

		// 画面描画用のテンプレート名を指定
		model.setViewName("Management");
		return model;
	}

	@PostMapping("/Management")
	public ModelAndView managementPost(ModelAndView model) {


		// 画面描画用のテンプレート名を指定
		model.setViewName("Management");
		return model;
	}
}
