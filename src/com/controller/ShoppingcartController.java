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
import com.vo.Shoppingcart;



@Controller
public class ShoppingcartController {

	@Resource(name = "shoppingcartservice")
	Services<String , Shoppingcart> shoppingcart_services;
	
	@RequestMapping("/shoppingcart.mc")
	public ModelAndView shoppingcart(Shoppingcart shoppingcart, HttpSession session, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		System.out.println(shoppingcart);
		try {
			shoppingcart_services.register(shoppingcart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mv.setViewName("redirect:cart.mc");

		return mv;
	}
	
}





