package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.UserForm;

@Controller
public class EditController {



	@ModelAttribute("userForm")
    public UserForm setupForm() {
        UserForm user = new UserForm();
        return user;
    }



	@GetMapping("/Edit")
	public ModelAndView editGet(ModelAndView model) {

		// 画面描画用のテンプレート名を指定
		model.setViewName("Edit");
		return model;
	}

	@PostMapping("/Edit")
	public ModelAndView editPost(ModelAndView model,
			@ModelAttribute UserForm userForm
			) {


		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Index");
		return model;
	}
}
