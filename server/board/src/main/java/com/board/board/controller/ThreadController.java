package com.board.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.board.board.repository.ThreadRepository;
@RestController
public class ThreadController {
	
	@Autowired
	private ThreadRepository threadRepository;
	
	public void insertThread(String Title, String Contents) {
		
	}
		
	}
