package org.nelr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nelr.model.web.PageDto;
import org.nelr.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 
 * @author nachowin
 * 
 * Need to call Init(String viewContentName) in each RequestMapped method that extends this class
 *
 */
@Controller
public class BaseController extends AbstractController{

	private ModelAndView modelAndView = new ModelAndView();
	private PageDto page;
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private IMenuService menuService;
	
	public void Init(String viewContentName){
		modelAndView.setViewName("template/defaultLayout");
		page = new PageDto(request);
		page.setViewContentName(viewContentName);
		List<String> listaRoles = new ArrayList<String>();
		String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		page.setListaMenuDto(menuService.findMenuByUsuario(userName));
		
		modelAndView.addObject("page", page);
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView model = new ModelAndView("index");
		model.addObject("message", "Welcome!");
		return model;
	}

	public ModelAndView getModelAndView() {
		return modelAndView;
	}

	public void setModelAndView(ModelAndView modelAndView) {
		this.modelAndView = modelAndView;
	}

	public PageDto getPage() {
		return page;
	}

	public void setPage(PageDto page) {
		this.page = page;
	}

	
}
