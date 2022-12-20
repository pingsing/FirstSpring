package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("basic...............");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {		// 커맨드 객체
		
		log.info(""+dto);
		
		return "ex01";
	}
}
