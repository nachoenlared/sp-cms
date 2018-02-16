package org.nelr.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.nelr.controller.BaseController;
import org.nelr.model.web.MenuDto;
import org.nelr.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController extends BaseController{

	
	@Autowired
	IMenuService menuService;
	
	@RequestMapping("/admin")
	public ModelAndView index(ModelMap model){
		super.Init("admin/admin");
		super.getPage().setTitleName("page.admin.titleName");
		
		List<MenuDto> listaOpcionesMenuAdmin = new ArrayList<MenuDto>();
		listaOpcionesMenuAdmin= menuService.findMenuByPrivilegio("ADMIN");
		super.getModelAndView().addObject("listaOpcionesMenuAdmin", listaOpcionesMenuAdmin);
		
		return super.getModelAndView();
	}
	
}
