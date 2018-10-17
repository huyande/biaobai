package com.biaob.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageBoardController {

	@RequestMapping(value="message/{vid}")
	public String message(@PathVariable("vid") Integer vid) {
		
		return "留言板";
	}
}
