package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Services;
import com.vo.Product;

@Controller
public class AdminController {

	@Resource(name = "productservice")
	Services<String , Product> services;
	
	@RequestMapping("/admin_main.mc")
	public String main() {
		return "admin/admin_main";
	}

	@RequestMapping("/chart.mc")
	public ModelAndView chart() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_main");
		mv.addObject("center", "chart");
		return mv;
	}
	
	@RequestMapping("/table.mc")
	public ModelAndView table() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_main");
		mv.addObject("center", "table");
		return mv;
	}
	

	
	@RequestMapping("/admin_logout.mc")
	public String sign_out(HttpServletRequest request, HttpSession session) {
		session = request.getSession();
		
		if(session != null) {
			session.invalidate();
		}

		return "main";
	}

	
	
	
}