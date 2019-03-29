package com.example.demo.controller;

import java.util.List;

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
public class ManagementController {

	@Autowired
	HttpSession session;

	@Autowired
	UserRepository userRepo;

//	@ModelAttribute("sampleForm")
//    public SampleForm setupForm() {
//        SampleForm sample = new SampleForm();
//        return sample;
//    }

	@GetMapping("/Management")
	public ModelAndView managementGet(ModelAndView model) {


		User u = (User)session.getAttribute("user");

		if(u == null){
			// セッションにログイン情報がない場合ログイン画面へ
			model.setViewName("redirect:/");
			return model;
		}

		// ユーザー取得
		List<User> userList = userRepo.findByUserIdNot("admin");

		// 取得したリストをモデルに設定
		model.addObject("userList", userList);

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

	@GetMapping("/UserDelete")
	public ModelAndView userDeleteGet(ModelAndView model,
			@ModelAttribute UserForm userForm
			) {

		// 削除処理
		userRepo.deleteById(userForm.getId());

		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Management");
		return model;
	}
}
