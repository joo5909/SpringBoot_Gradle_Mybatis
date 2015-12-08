package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.domain.SwinfoDto;
import com.main.service.SwinfoService;

@Controller
public class MainController {
	
	@Autowired
	private SwinfoService swinfoService;
	
	@RequestMapping(value={"/test"}, method={RequestMethod.GET,RequestMethod.HEAD})
	public String interimMpi(Model model, String skey) {
	
		List<SwinfoDto.SwinfoDtl> swinfo = swinfoService.getSwinfo(skey);
		

		model.addAttribute("swinfo", swinfo);
		return "main";
	}
}
