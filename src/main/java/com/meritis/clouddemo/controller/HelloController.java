package com.meritis.clouddemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meritis.clouddemo.entity.MessageEntity;
import com.meritis.clouddemo.repository.MessageRepository;

@RestController
public class HelloController {
	
	private MessageRepository messageRepository;
	
	public HelloController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	@RequestMapping("/messagestatic")
	public String getMessage() {
		return "Hello Meritis";
	}
	
	@GetMapping("/messages")
	public ResponseEntity<List<MessageEntity>> getMessages() {
		try {
			List<MessageEntity> messages = new ArrayList<MessageEntity>();

			messageRepository.findAll().forEach(messages::add);
			
			if (messages.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(messages, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/messages/{id}")
	public ResponseEntity<MessageEntity> getTutorialById(@PathVariable("id") long id) {
		try {
			Optional<MessageEntity> messageEntity = messageRepository.findById(id);
	
			if (messageEntity.isPresent()) {
				return new ResponseEntity<>(messageEntity.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PostMapping("/messages")
	public ResponseEntity<MessageEntity> createTutorial(@RequestBody MessageEntity messageEntity) {
		try {
			MessageEntity _messageEntity = messageRepository
					.save(new MessageEntity(messageEntity.getContent()));
			return new ResponseEntity<>(_messageEntity, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
