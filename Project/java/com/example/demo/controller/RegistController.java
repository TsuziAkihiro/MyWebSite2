package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/Regist", method = RequestMethod.GET)
	public ModelAndView Regist(ModelAndView model) {
		// TODOリスト取得
//		List<Task> taskList = taskRepo.findAll();

		// 取得したリストをモデルに設定
//		model.addObject("taskList", taskList);

		// 画面描画用のテンプレート名を指定
		model.setViewName("Regist");
		return model;
	}
}
