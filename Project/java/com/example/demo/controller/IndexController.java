package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/Index", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {

		// TODOリスト取得
//		List<User> taskList = taskRepo.findAll();

		// 取得したリストをモデルに設定
//		model.addObject("taskList", taskList);

		// 画面描画用のテンプレート名を指定
		model.setViewName("Index");
		return model;
	}
}
