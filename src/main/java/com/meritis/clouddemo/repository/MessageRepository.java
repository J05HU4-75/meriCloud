package com.meritis.clouddemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.meritis.clouddemo.entity.MessageEntity;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {}
