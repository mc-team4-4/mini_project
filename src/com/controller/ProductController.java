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
import com.vo.Category;
import com.vo.Product;

@Controller
public class ProductController {
	
	@Resource(name = "productservice")
	Services<String , Product> services;
	
	@RequestMapping("/add_product.mc")
	public ModelAndView add_product() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_main");
		mv.addObject("center", "add_product");
		return mv;
	}
	
	@RequestMapping("/add_product_impl.mc")
	public ModelAndView add_product_impl(Product product, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
	
		try {
			System.out.println(product);

			services.register(product);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('Add Product Complete!');</script>");
			out.flush();
			mv.setViewName("admin/admin_main");
			mv.addObject("center", "add_product");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	


		return mv;
	}
	
	
	
	@RequestMapping("/modify_product.mc")
	public ModelAndView modify_product() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_main");
		mv.addObject("center", "modify_product");
		return mv;
	}

	
}
