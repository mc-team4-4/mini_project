package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
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
	Services<String , Product> product_services;
	@Resource(name = "categoryservice")
	Services<String , Category> category_services;

	ArrayList<String> select_product_img_list = new ArrayList<String>();
	
	@RequestMapping("/product_details.mc")
	public ModelAndView product_details(@RequestParam(value = "product_id") String product_id,  HttpSession session, HttpServletResponse response) {
		select_product_img_list.clear();
		ModelAndView mv = new ModelAndView();

		String email = (String) session.getAttribute("login_user_email");
		
		
		String select_product_mainimg_list = null;
		Product select_product_list = null;
		Category select_category = null;
		try {

			select_product_list = product_services.get(product_id);

			String getCategory_id = Integer.toString(select_product_list.getCategory_id());
			select_category = category_services.get(getCategory_id);

			String select_product_img = select_product_list.getImg();
			String select_product_split_img = null;

			int index = select_product_img.indexOf(",");

			if (index == -1) {
				select_product_split_img = select_product_img;
				select_product_img_list.add(select_product_split_img);

			} else {
				int temp = 0;

				while (index > -1) {

					select_product_split_img = select_product_img.substring(temp, index);
					temp = index + 1;
					index = select_product_img.indexOf(",", index + 1);
					select_product_img_list.add(select_product_split_img);

					if (index < 0) {

						index = select_product_img.length();
						select_product_split_img = select_product_img.substring(temp, index);

						select_product_img_list.add(select_product_split_img);
						break;
					}

				}

			}

			select_product_mainimg_list = (select_product_img_list.get(0));
			select_product_img_list.remove(0);
			mv.setViewName("main");
			mv.addObject("select_product_list", select_product_list);
			mv.addObject("select_product_mainimg_list", select_product_mainimg_list);
			mv.addObject("select_product_img_list", select_product_img_list);
			mv.addObject("select_category", select_category);
			mv.addObject("login_user_email", email);
			mv.addObject("center", "product_details");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return mv;
	}
	
	


	
}
