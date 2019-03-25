package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagementController {
//
//	@Autowired
//	TaskRepository taskRepo;

//	@ModelAttribute("sampleForm")
//    public SampleForm setupForm() {
//        SampleForm sample = new SampleForm();
//        return sample;
//    }

	@GetMapping("/Management")
	public ModelAndView managementGet(ModelAndView model) {


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
