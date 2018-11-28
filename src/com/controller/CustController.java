package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Cust;

@Controller
public class CustController {
	
	@Resource(name = "cbiz")
	Biz<String, Cust> biz;

	@RequestMapping("/clist.mc")
	public ModelAndView clist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Cust> list = null;
		mv.setViewName("main");
		try {
			list = biz.get();
			mv.addObject("clist", list);
			mv.addObject("center", "cust/clist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/cjson.mc")
	@ResponseBody
	public List<Cust> cjson(){
		List<Cust> list = null;
		try {
			list = biz.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
}





