package org.nelr.controller;

import java.util.ArrayList;
import java.util.List;

import org.nelr.model.entity.UsuarioEntity;
import org.nelr.model.validation.UserRegisterValidator;
import org.nelr.model.web.MensajeErrorDTO;
import org.nelr.model.web.UsuarioRegistroDTO;
import org.nelr.service.IUsuarioPrivilegioService;
import org.nelr.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController extends BaseController{

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IUsuarioPrivilegioService usuarioPrivilegioService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView index(ModelMap model){
		super.Init("register");
		super.getPage().setTitleName("page.register.titleName");
		return super.getModelAndView();
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerPost(ModelMap model, @ModelAttribute(value="username") String username, @ModelAttribute(value="password") String password,
			@ModelAttribute(value="email") String email, BindingResult bindingResult){
		super.Init("register");
		super.getPage().setTitleName("page.register.titleName");
		
		try {
			
			UserRegisterValidator validator = new UserRegisterValidator();
			
			UsuarioRegistroDTO usuarioRegistroDto = new UsuarioRegistroDTO(username, password, email);
			
			validator.validate(usuarioRegistroDto, bindingResult);
			
			if(bindingResult.hasErrors()){
				
				for(ObjectError error : bindingResult.getAllErrors()){
					if(super.getPage().getListaMensajeError()==null){
						super.getPage().setListaMensajeError(new ArrayList<String>());
					}
					super.getPage().getListaMensajeError().add(error.getDefaultMessage());
				}
				
				return super.getModelAndView();
			}
			
			List<MensajeErrorDTO> errors = usuarioService.validateUserRegister(usuarioRegistroDto);
			
			if(!errors.isEmpty()){
				for(MensajeErrorDTO error : errors){
					if(super.getPage().getListaMensajeError()==null){
						super.getPage().setListaMensajeError(new ArrayList<String>());
					}
					super.getPage().getListaMensajeError().add(error.getEtiqueta());
				}
				return super.getModelAndView();
			}
			
			
			usuarioService.registerUser(usuarioRegistroDto);
			
			UsuarioEntity usuarioEntity = usuarioService.findByUserName(username);
			
			usuarioPrivilegioService.addPrivilegeUser(usuarioEntity);
			
			if(super.getPage().getListaMensajeExito()==null){
				super.getPage().setListaMensajeExito(new ArrayList<String>());
			}
			
			super.getPage().getListaMensajeExito().add("register.success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(super.getPage().getListaMensajeError()==null){
				super.getPage().setListaMensajeError(new ArrayList<String>());
			}
			super.getPage().getListaMensajeError().add(e.getMessage());
		}
		
		return super.getModelAndView();
	}
	
}
