package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Services;
import com.vo.User;

@Controller
public class UserController {

	@Resource(name = "userservice")
	Services<String , User> user_services;
	
	@RequestMapping("/user_detail.mc")
	public ModelAndView user_detail(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User dbuser = null;
		
		String email = (String) session.getAttribute("login_user_email");
		System.out.println("Seesion: "+ email);
		
		try {
			dbuser = user_services.get(email);
			session.setAttribute("user_email", dbuser.getEmail());
			session.setAttribute("user_password", dbuser.getPassword());
			session.setAttribute("user_name", dbuser.getName());
			session.setAttribute("user_phone_number", dbuser.getPhone_number());
			if(dbuser.getStatus()==null) {
				session.setAttribute("user_status", "-");
				
			}
			else {
				session.setAttribute("user_status", dbuser.getStatus());
				
			}
			
			session.setAttribute("user_address", dbuser.getAddress());
			mv.setViewName("user/user_detail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return mv;
	}
	

	@RequestMapping("/user_detail_impl.mc")
	public ModelAndView user_detail_impl(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		try {
			if(user.getPassword().equals(user.getPassword_confirm()) && user.getPassword().equals(user.getPassword_current())) {
				user_services.modify(user);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Modify Complete!');</script>");
				out.flush();

				session.removeAttribute("user_email");
				session.removeAttribute("user_password");
				session.removeAttribute("user_name");
				session.removeAttribute("user_phone_number");
				session.removeAttribute("user_status");
				session.removeAttribute("user_address");
	
				mv.setViewName("main");
				
			}
			else if(user.getPassword().equals(user.getPassword_confirm()) && !user.getPassword().equals(user.getPassword_current())) {
				user_services.modify(user);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Modify Complete! Please Resign in');</script>");
				out.flush();
				
				session.removeAttribute("user_email");
				session.removeAttribute("user_password");
				session.removeAttribute("user_name");
				session.removeAttribute("user_phone_number");
				session.removeAttribute("user_status");
				session.removeAttribute("user_address");
				session.removeAttribute("login_user_email");

				mv.setViewName("sign_in");
			}
			else {
				mv.setViewName("user/modify_fail");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('Passwords are different'); history.go(-1);</script>");
				out.flush();
			
			}

		} catch (Exception e) {
		
			try {
				mv.setViewName("user/modify_fail");
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
	
	
	@RequestMapping("/withdrawal.mc")
	public ModelAndView withdrawal(User user, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String email = user.getEmail();
		System.out.println("Withdrawal E-mail: "+ email);
		
		try {
			user_services.remove(email);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('Withdrawal Complete!');</script>");
			out.flush();
			
			session.removeAttribute("user_email");
			session.removeAttribute("user_password");
			session.removeAttribute("user_name");
			session.removeAttribute("user_phone_number");
			session.removeAttribute("user_status");
			session.removeAttribute("user_address");
			session.removeAttribute("login_user_email");
		
			
			mv.setViewName("main");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		return mv;
	}

}





