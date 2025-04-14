package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Contact;

import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByUserId(Integer userId);
	
	@Query("SELECT c FROM Contact c WHERE c.userId = :userId and c.id = :contactId")
	Contact findSingleContact(@Param("userId") Integer userId, @Param("contactId")Integer contactId);
}
