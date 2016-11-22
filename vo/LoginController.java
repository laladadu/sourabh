package com.aartek.prestigepoint.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





import com.aartek.prestigepoint.model.LoginDto;
import com.aartek.prestigepoint.service.LoginService;
import com.aartek.prestigepoint.serviceImpl.LoginServiceImpl;
import com.aartek.prestigepoint.vo.LoginVO;









/**
 * Servlet implementation class LoginController
 */
@Controller
public class LoginController  {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@RequestMapping("/login")
	public String showLogin(Map<String, Object> map) {
		map.put("AdminLogin", new LoginVO());
	
		
		return "login";

	}
	@Autowired
	private LoginService  loginService;
	
	
	@RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("AdminLogin") LoginVO login) {
		
		LoginVO vo=loginService.validate(login);
		System.out.println(vo.getEmail_id());
		if(vo!=null)
		{
			System.out.println("valid user");
			return "welcome";	
		}
		else
		{
			System.out.println("invalid user");
			return "login";
		}
		
	}
	
}
