package com.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Services;
import com.vo.User;

@Controller
public class MainController {

	@Resource(name = "userservice")
	Services<String , User> services;
	
	@RequestMapping("/main.mc")
	public String main() {
		return "main";
	}

	@RequestMapping("/shop.mc")
	public ModelAndView shop() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "shop");
		return mv;
	}
	
	@RequestMapping("/cart.mc")
	public ModelAndView cart() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "cart");
		return mv;
	}
	
	
	
	@RequestMapping("/checkout.mc")
	public ModelAndView checkout() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "checkout");
		return mv;
	}
	
	@RequestMapping("/product_details.mc")
	public ModelAndView product_details() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "product_details");
		return mv;
	}
	
	@RequestMapping("/sign_in.mc")
	public ModelAndView sign_in() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sign_in");
		return mv;
	}

	@RequestMapping("/sing_in_impl.mc")
	public ModelAndView sing_in_impl(@RequestParam(value="email", required=true) String email, @RequestParam(value="password", required=true) String password, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		User dbuser = null;
		try {
			dbuser = services.get(email);
			if(dbuser.getPassword().equals(password)) {
				session.setAttribute("login_user", dbuser);
				mv.addObject("main");
			}else {
				mv.addObject("center", "sign_in_fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	

	@RequestMapping("/sign_up.mc")
	public ModelAndView sign_up() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sign_up");
		return mv;
	}
	
	@RequestMapping("/sing_up_impl.mc")
	public ModelAndView sing_up_impl(User user, HttpServletResponse response) {
		System.out.println(user.toString());
	
		ModelAndView mv = new ModelAndView();
		
		
		try {
			if(user.getPassword().equals(user.getPassword_confirm())) {
				services.register(user);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Sign up Complete!');</script>");
				out.flush();
				mv.setViewName("main");
				
			}
			else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Passwords are different'); history.go(-1);</script>");
				out.flush();

			}

		} catch (Exception e) {
			mv.setViewName("sign_up_fail");
//			e.printStackTrace();
		}
		
		return mv;
	}


}





