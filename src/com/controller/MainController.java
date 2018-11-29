package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Cust;

@Controller
public class MainController {

	@Resource(name = "cbiz")
	Biz<String , Cust> biz;
	
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
	
	
	@RequestMapping("/sign_in.mc")
	public ModelAndView sign_in() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sign_in");
		return mv;
	}

	@RequestMapping("/sign_up.mc")
	public ModelAndView sign_up() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sign_up");
		return mv;
	}

}





