package com.example.demo.controller;

import java.util.Date;

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
public class EditController {


	@ModelAttribute("userForm")
    public UserForm setupForm() {
        UserForm user = new UserForm();
        return user;
    }

	@Autowired
	HttpSession session;

	@Autowired
	UserRepository userRepo;



	@GetMapping("/Edit")
	public ModelAndView editGet(ModelAndView model) {

		User u = (User)session.getAttribute("user");

		if(u == null){
			// セッションにログイン情報がない場合ログイン画面へ
			model.setViewName("redirect:/");
			return model;
		}

		// 画面描画用のテンプレート名を指定
		model.setViewName("Edit");
		return model;
	}

	@PostMapping("/Edit")
	public ModelAndView editPost(ModelAndView model,
			@ModelAttribute UserForm userForm
			) {

		// 重複チェック
		User checkUser = userRepo.findByUserIdEquals(userForm.getUser_id());

		if(checkUser != null) {

			// もし登録されている情報が見つかれば登録に戻る
			model.setViewName("redirect:Edit");
			return model;
		}

		User u = (User)session.getAttribute("user");

		String password = support.changeMD5(userForm.getPassword());

		// 取得したパラメータをもとに登録用データを作成
		User user = new User();
		user.setId(u.getId());
		user.setUser_id(userForm.getUser_id());
		user.setPassword(password);
		user.setCreateDate(u.getCreateDate());
		user.setUpdateDate(new Date());

		// 登録
		userRepo.save(user);

		// 保存
	    session.setAttribute("user",user);

		// 画面描画用のテンプレート名を指定
		model.setViewName("redirect:Index");
		return model;
	}
}
