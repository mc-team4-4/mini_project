package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
import com.vo.User;

@Controller
public class MainController {

	@Resource(name = "userservice")
	Services<String , User> services;
	@Resource(name = "productservice")
	Services<String , Product> product_services;
	@Resource(name = "categoryservice")
	Services<String , Category> categoryservices;
	
//	@RequestMapping("/main.mc")
//	public String main() {
//
//		return "main";
//	
//	}


	ArrayList<String> front_main_img_list = new ArrayList<String>();
	@RequestMapping("/main.mc")
	public ModelAndView main(HttpServletResponse response) {
		front_main_img_list.clear();
		ModelAndView mv = new ModelAndView();
		ArrayList<Product> p_list = null;
		
		String front_main_img = null;
		
		
		try {
			mv.setViewName("main");
			p_list = product_services.get();
	
			for(Product product : p_list) {
				
				String main_img = product.getImg();
				int index = main_img.indexOf(",");
//				System.out.println(index);
				if(index==-1) {
					front_main_img = main_img;
				}
				else {
					front_main_img = main_img.substring(0, index);	
				}
				front_main_img_list.add(front_main_img);
			
				
	
				
			}
			
			System.out.println(front_main_img_list);
			
			mv.addObject("p_list", p_list);
			mv.addObject("front_main_img_list", front_main_img_list);
			mv.addObject("center", "main_product");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("center", "main_product_null");	
			
		}

		
		return mv;
		
	}
	

	@RequestMapping("/shop.mc")
	public ModelAndView shop() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "shop");
		return mv;
	}
	
	@RequestMapping("/lunch_box.mc")
	public ModelAndView lunch_box() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "shop");
		mv.addObject("product_center", "lunch_box");
		return mv;
	}
	
	@RequestMapping("/diet_program.mc")
	public ModelAndView diet_program() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "shop");
		mv.addObject("product_center", "diet_program");
		return mv;
	}
	
	@RequestMapping("/health_drink.mc")
	public ModelAndView health_drink() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "shop");
		mv.addObject("product_center", "health_drink");
		return mv;
	}
	
	@RequestMapping("/health_snack.mc")
	public ModelAndView health_snack() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("center", "shop");
		mv.addObject("product_center", "health_snack");
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
	

	ArrayList<String> select_product_img_list = new ArrayList<String>();
	
	@RequestMapping("/product_details.mc")
	public ModelAndView product_details(@RequestParam(value = "product_id") String product_id ) {
		String select_product_mainimg_list=null;
		select_product_img_list.clear();
		ModelAndView mv = new ModelAndView();
		Product select_product_list= null;
		Category select_category=null;
		try {
			
			select_product_list = product_services.get(product_id);
			System.out.println(select_product_list);
			
			String getCategory_id = Integer.toString(select_product_list.getCategory_id());
			System.out.println("getCategory_id: "+getCategory_id);
			select_category = categoryservices.get(getCategory_id);
			System.out.println(select_category);

			
			
			String select_product_img = select_product_list.getImg();
			
			System.out.println(select_product_img);
			String select_product_split_img = null;

		
			int index = select_product_img.indexOf(",");
			
			
			
			
			if(index==-1) {
				select_product_split_img = select_product_img;
				select_product_img_list.add(select_product_split_img);
				
			}
			else {
				int temp=0;
					
				while(index >-1){
				
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
			System.out.println(select_product_img_list);
			select_product_mainimg_list = (select_product_img_list.get(0));
			select_product_img_list.remove(0);
			mv.setViewName("main");
			mv.addObject("select_product_list", select_product_list);
			mv.addObject("select_product_mainimg_list", select_product_mainimg_list);
			mv.addObject("select_product_img_list", select_product_img_list);
			mv.addObject("select_category", select_category);
			mv.addObject("center", "product_details");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping("/sign_in.mc")
	public ModelAndView sign_in() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sign_in");
		return mv;
	}

	@RequestMapping("/sing_in_impl.mc")
	public ModelAndView sing_in_impl(@RequestParam(value="email", required=true) String email, @RequestParam(value="password", required=true) String password, HttpSession session, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User dbuser = null;
		
		try {
			dbuser = services.get(email);
			
			if(email.equals("admin@admin.com")) {
				session.setAttribute("login_admin_email", dbuser.getEmail());
				session.setAttribute("login_admin_name", dbuser.getName());
				mv.setViewName("admin/admin_main");
				
			}
			else {
				if(dbuser.getPassword().equals(password)) {
					session.setAttribute("login_user_email", dbuser.getEmail());
					mv.setViewName("main");
				}else {
					mv.setViewName("sign_in_fail");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('Sign in is fail. Please check on your E-mail or Password.'); history.go(-1);</script>");
					out.flush();
					
				}
			}
			

		} catch (Exception e) {

			try {
				mv.setViewName("sign_in_fail");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Sign in is fail. Please check on your E-mail or Password.'); history.go(-1);</script>");
				out.flush();
						
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping("/sign_out.mc")
	public String sign_out(HttpServletRequest request, HttpSession session) {
		session = request.getSession();
		
		if(session != null) {
			session.invalidate();
		}
		
		return "main";
	}
	
	
	@RequestMapping("/sign_up.mc")
	public ModelAndView sign_up() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sign_up");
		
		return mv;
	}
	
	@RequestMapping("/sing_up_impl.mc")
	public ModelAndView sing_up_impl(User user, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {

			if (user.getPassword().equals(user.getPassword_confirm())) {
				services.register(user);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Sign up Complete!');</script>");
				out.flush();
				mv.setViewName("main");

			} else {
				mv.setViewName("sign_up_fail");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Passwords are different'); history.go(-1);</script>");
				out.flush();

			}
			


		} catch (Exception e) {
		
			try {
				mv.setViewName("sign_up_fail");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Passwords are different'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
		return mv;
	}


}





