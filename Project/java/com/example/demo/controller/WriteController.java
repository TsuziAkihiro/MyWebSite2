package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WriteController {
//
//	@Autowired
//	TaskRepository taskRepo;

//	@ModelAttribute("sampleForm")
//    public SampleForm setupForm() {
//        SampleForm sample = new SampleForm();
//        return sample;
//    }

	@GetMapping("/Write")
	public ModelAndView WriteGet(ModelAndView model) {

		// 画面描画用のテンプレート名を指定
		model.setViewName("Write");
		return model;
	}

	@PostMapping("/Write")
	public ModelAndView WritePost(ModelAndView model) {


		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Index");
		return model;
	}
}
