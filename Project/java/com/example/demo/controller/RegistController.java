package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistController {
//
//	@Autowired
//	TaskRepository taskRepo;

//	@ModelAttribute("sampleForm")
//    public SampleForm setupForm() {
//        SampleForm sample = new SampleForm();
//        return sample;
//    }

	@GetMapping("/Regist")
	public ModelAndView RegistGet(ModelAndView model) {

		// 画面描画用のテンプレート名を指定
		model.setViewName("Regist");
		return model;
	}

	@PostMapping("/Regist")
	public ModelAndView RegistPost(ModelAndView model) {



		// 画面描画用のテンプレート名を指定
		model.setViewName("Regist");
		return model;
	}
}
