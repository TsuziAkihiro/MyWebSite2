package com.example.demo.controller;

import javax.servlet.http.HttpSession;

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
public class LoginController {


	@Autowired
	UserRepository userRepo;

	@Autowired
	HttpSession session;


	@ModelAttribute("userForm")
    public UserForm setupForm() {
        UserForm user = new UserForm();
        return user;
    }



	@GetMapping("/")
	public ModelAndView loginGet(ModelAndView model) {


		model.setViewName("Login");
		return model;
	}


	@PostMapping("/")
	public ModelAndView loginPost(ModelAndView model,
			@ModelAttribute UserForm userForm
	) {

		User us = new User();
		us.setUser_id(userForm.getUser_id());

	    // 保存
	    session.setAttribute("user", us);


	    if("admin".equals(userForm.getUser_id())) {
			model.setViewName("redirect:Management");
			return model;

	    }else {
			model.setViewName("redirect:Index");
			return model;
	    }
	}


	@GetMapping("/Logout")
	public ModelAndView logoutGet(ModelAndView model) {


		session.invalidate();

		model.setViewName("redirect:/");
		return model;
	}
}
