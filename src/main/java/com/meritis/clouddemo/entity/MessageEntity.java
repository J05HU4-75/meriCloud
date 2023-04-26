package com.meritis.clouddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entity")
public class MessageEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	
	private String content;
	
	public MessageEntity() {
		this.content = "";
	}
	
	public MessageEntity(String content) {
		this.content = content;
	}
	
	// getter
	public long  getId() {
		return this.id; 
	}
	
	// getter
	public String getContent() {
		return this.content; 
	}
	
	
}
