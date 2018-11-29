package com.controller;

import java.io.FileOutputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;

@Controller
public class ProductController {

	@Resource(name="pbiz")
	Biz<Integer, Product> biz;
	
//	@RequestMapping("/padd.mc")
//	public ModelAndView padd() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("main");
//		mv.addObject("center", "product/register");
//		return mv;
//	}
	
	@RequestMapping("/product_details.mc")
	public ModelAndView product_details() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "product_details");
		return mv;
	}
}








