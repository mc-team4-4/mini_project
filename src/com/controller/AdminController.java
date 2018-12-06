package com.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Services;
import com.vo.Category;
import com.vo.Product;

@Controller
public class AdminController {

	@Resource(name = "productservice")
	Services<String , Product> product_services;
	@Resource(name = "categoryservice")
	Services<String , Category> category_services;
	String img_array = "";
	
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

	
	@RequestMapping("/add_product.mc")
	public ModelAndView add_product() {
		ModelAndView mv = new ModelAndView();
		img_array = "";
		mv.setViewName("admin/admin_main");
		mv.addObject("center", "add_product");
		return mv;
	}
	
	@RequestMapping("/add_product_impl.mc")
	public ModelAndView add_product_impl(Product product, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {
			System.out.println(product);
			product_services.register(product);
			img_array = "";
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
	

	@RequestMapping("/image_upload.mc")
	public ModelAndView image_upload(@RequestParam(value = "file") MultipartFile file, HttpServletResponse response,Model model){
		ModelAndView mv = new ModelAndView();
		
		try {
			String orginalName = file.getOriginalFilename();
			if(img_array.isEmpty()) {
				img_array += orginalName;
				
			}else {
				img_array += ","+orginalName;
				
			}
			
			model.addAttribute("img", img_array);
			mv.setViewName("admin/admin_main");
			mv.addObject("center", "add_product");
	
		}catch (Exception e) {
			// TODO: handle exception
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