package org.nelr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{

	@RequestMapping("/login")
	public ModelAndView index(ModelMap model){
		super.Init("login");
		super.getPage().setTitleName("page.login.titleName");
		return super.getModelAndView();
	}
	
}
