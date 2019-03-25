package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
//
//	@Autowired
//	TaskRepository taskRepo;

//	@ModelAttribute("sampleForm")
//    public SampleForm setupForm() {
//        SampleForm sample = new SampleForm();
//        return sample;
//    }

	@GetMapping("/Index")
	public ModelAndView indexGet(ModelAndView model) {

		// 画面描画用のテンプレート名を指定
		model.setViewName("Index");
		return model;
	}
}
