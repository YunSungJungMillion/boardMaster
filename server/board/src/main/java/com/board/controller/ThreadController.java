package com.board.controller;

import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.board.model.Thread;
import com.board.repository.ThreadRepository;

@RestController
public class ThreadController {
	
	@Autowired
	private ThreadRepository threadRepository;

	
	@RequestMapping(value = "/getThread", method = RequestMethod.GET)
	public List<Thread> getAll(){
		return threadRepository.findAll();
	}
	 
	@RequestMapping(value = "thread/{id}", method = RequestMethod.GET)
	public Thread getThreadbyID(@PathVariable final long id){
		
		Optional<Thread> data = threadRepository.findById(id);
		return data.orElse(new Thread());
	}
	
	@RequestMapping(value = "cThread", method = RequestMethod.POST)
	public  ResponseEntity<Thread> createThread(@RequestBody final Thread t)
	{
		boolean success = true;
		// 비지니스 서비스 차원에서 에라가 발생 되었다면 exception은 서비스를 중단하는게 좋다고 한다
		// 근데 이런 익셉션을 다예외해서 분기로 범벅해놓으면 보기도 싫고 코드를 중지할 부분을 플머가 정해줘야한다.
		// 예외로 중단시키고 예외를 따로 만들어서 response를 리턴시키거나
		// map에다가 메세지를 잘 넣어서 보내는 방법도 있다.
		// map같은경우는 간단한 것을 구현할때
		// 서비스가 매우 복잡하다면 exception으로 쓰로우 해버려서 정지시키는게 좋다고 한다.
		
		ResponseEntity<Thread> response = null;
		try 
		{		
			threadRepository.save(t);
		
		}
		catch(Exception e)
		{
			success = false;
			response = new ResponseEntity<Thread>(t,HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(success)
		{	
			response = new ResponseEntity<Thread>(t,HttpStatus.CREATED);
		}
		
		
		
		return response;
	}
	
	@RequestMapping(value = "dThread/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteThread(@PathVariable final long id)
	{
		boolean success = false;
		ResponseEntity<String> response = null;
		try 
		{	
			threadRepository.deleteById(id);
			success = true;
		}
		catch(Exception ex) 
		{
			response = new ResponseEntity<String>(String.format("게시글 아이디 : %d 는 DB에 존재하지 않습니다.", id ),HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(success) 
		{
			response = new ResponseEntity<String>(String.format("게시글 아이디 : %d 삭제", id ),HttpStatus.ACCEPTED);
		}
		
		return response;
	}
	
	@RequestMapping(value = "gThreadPage/{page}", method = RequestMethod.GET)
	public List<Thread> getPagedResult(@PathVariable final int page)
	{
		PageRequest pageable = PageRequest.of(page, 10);
		 Page<Thread> pThread = threadRepository.findAll(pageable);
		return pThread.toList();
	}
	
	
	
	@RequestMapping(value = "/uThread/", method = RequestMethod.POST)
	public Thread updateThread(@RequestBody final Thread t)
	{
		Thread target = threadRepository.
				findById(t.getId()).
				orElseThrow(() -> new ResourceAccessException("can't find thread to be updated"));
		
		target.setTitle(t.getTitle());
		target.setContents(t.getContents());
		
		threadRepository.save(target);
		return target;		
	}

		
}

