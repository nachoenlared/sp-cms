package org.nelr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BaseController{

	
	@RequestMapping({"/index", "/"})
	public ModelAndView index(ModelMap model){
		super.Init("index");
		super.getPage().setTitleName("page.index.titleName");
		return super.getModelAndView();
	}

	
	
}
