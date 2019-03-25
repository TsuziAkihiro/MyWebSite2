package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepo;

//	@ModelAttribute("sampleForm")
//    public SampleForm setupForm() {
//        SampleForm sample = new SampleForm();
//        return sample;
//    }

	@GetMapping("/")
	public ModelAndView loginGet(ModelAndView model) {


		model.setViewName("Login");
		return model;
	}


	@PostMapping("/")
	public ModelAndView loginPost(ModelAndView model) {



		model.setViewName("redirect:Index");
		return model;
	}


}
