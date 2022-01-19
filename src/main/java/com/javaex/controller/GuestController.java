package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guest")
public class GuestController {
	
	//필드
	@Autowired
	private GuestBookDao guestbookDao;
	//생성자
	
	//메소드 g,s
	
	//메소드 일반
	@RequestMapping(value="/addList", method = {RequestMethod.GET, RequestMethod.POST})
	public String test(Model model) {
		
		System.out.println("guest/addList");
		
		List<GuestbookVo> guestbookList = guestbookDao.getList();
		//컨트롤러가 --> DS 데이터를 보낸다
		model.addAttribute("guestbookList",guestbookList);
		
		return "addList";
	}
	
	@RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		
		System.out.println("guest/add");
		
		guestbookDao.guestbookInsert(guestbookVo);
		System.out.println(guestbookVo);
		
		return "redirect:/guest/addList";
	}
	
	@RequestMapping(value="/deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		
		System.out.println("guest/deleteForm");
		
		return "deleteForm";
		
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("password") String password,
						 @RequestParam("no") int no) {
		
		guestbookDao.guestbookDelete(no, password);
		
		return "redirect:/guest/addList";
	}
	
}
