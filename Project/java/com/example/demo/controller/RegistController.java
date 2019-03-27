package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import com.example.demo.form.UserForm;

@Controller
public class RegistController {

	@Autowired
	UserRepository userRepo;

	@ModelAttribute("userForm")
    public UserForm setupForm() {
        UserForm user = new UserForm();
        return user;
    }

	@GetMapping("/Regist")
	public ModelAndView RegistGet(ModelAndView model) {


		// 画面描画用のテンプレート名を指定
		model.setViewName("Regist");
		return model;
	}

	@PostMapping("/Regist")
	public ModelAndView RegistPost(ModelAndView model,
			@ModelAttribute UserForm userForm
			) {

		// 取得したパラメータをもとに登録用データを作成
		User user = new User();
		user.setUser_id(userForm.getUser_id());
		user.setPassword(userForm.getPassword());
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());

		// 登録
		userRepo.save(user);


		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Index");
		return model;
	}
}
