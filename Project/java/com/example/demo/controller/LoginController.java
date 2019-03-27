package com.example.demo.controller;

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

		User user = new User();
		user.setUser_id(userForm.getUser_id());
		user.setPassword(userForm.getPassword());


		model.setViewName("redirect:Index");
		return model;
	}


}
