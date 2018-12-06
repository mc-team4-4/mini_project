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
import com.vo.Product;
import com.vo.Shoppingcart;
import com.vo.User;

@Controller
public class MainController {

	@Resource(name = "userservice")
	Services<String , User> user_services;
	@Resource(name = "productservice")
	Services<String , Product> product_services;
	@Resource(name = "shoppingcartservice")
	Services<String , Shoppingcart> shoppingcart_services;

	ArrayList<String> front_main_img_list = new ArrayList<String>();
	@RequestMapping("/main.mc")
	public ModelAndView main(HttpServletResponse response) {
		front_main_img_list.clear();
		ModelAndView mv = new ModelAndView();
		ArrayList<Product> p_list = null;
		
		String front_main_img = null;
		
		
		try {
			
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
			mv.setViewName("main");
			mv.addObject("p_list", p_list);
			mv.addObject("front_main_img_list", front_main_img_list);
			mv.addObject("center", "main_product");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
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
	
	
	ArrayList<Product> db_product_list = new ArrayList<>();
	ArrayList<String> cart_img_list = new ArrayList<>();
	ArrayList<Shoppingcart> db_shoppingcart = null;
	
	@RequestMapping("/cart.mc")
	public ModelAndView cart(HttpServletRequest request, HttpSession session) {
		db_product_list.clear();
		cart_img_list.clear();
		
		ModelAndView mv = new ModelAndView();
		
		String email = (String) session.getAttribute("login_user_email");
		System.out.println("cart_email: "+email);
		
		
		Product dbproduct = null;
		String select_cartimg = null;
		String select_split_img = null;
		
		int price=0;
		int amount=0;
		int total=0;
		try {
			db_shoppingcart = shoppingcart_services.get_list(email);
			
			for(Shoppingcart shoppingcart: db_shoppingcart) {
				int product_id = shoppingcart.getProduct_id();
				
				dbproduct = product_services.get(""+product_id);
				
				select_cartimg = dbproduct.getImg();
				int index = select_cartimg.indexOf(",");

				if (index == -1) {
					select_split_img = select_cartimg;
					cart_img_list.add(select_split_img);

				} else {
					select_split_img = select_cartimg.substring(0, index);
					cart_img_list.add(select_split_img);
					
				}
			
				db_product_list.add(dbproduct);
				
				price = dbproduct.getPrice();
				amount = shoppingcart.getAmount();
				total += price* amount;
			}
			
			System.out.println("total: " + total);
			System.out.println(db_shoppingcart);
			System.out.println(db_product_list);
			
			mv.setViewName("main");
			mv.addObject("db_shoppingcart", db_shoppingcart);
			mv.addObject("db_product_list", db_product_list);
			mv.addObject("cart_img_list", cart_img_list);
			mv.addObject("total", Integer.toString(total));
			mv.addObject("center", "cart");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

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

	@RequestMapping("/sing_in_impl.mc")
	public ModelAndView sing_in_impl(@RequestParam(value="email", required=true) String email, @RequestParam(value="password", required=true) String password, HttpSession session, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User dbuser = null;
		
		try {
			dbuser = user_services.get(email);
			
			if(email.equals("admin@admin.com")) {
				session.setAttribute("login_admin_email", dbuser.getEmail());
				session.setAttribute("login_admin_name", dbuser.getName());
				mv.setViewName("redirect:admin_main.mc");
			}
			else {
				if(dbuser.getPassword().equals(password)) {
					session.setAttribute("login_user_email", dbuser.getEmail());
					mv.setViewName("redirect:main.mc");
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

		return "redirect:main.mc";
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
				user_services.register(user);
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





