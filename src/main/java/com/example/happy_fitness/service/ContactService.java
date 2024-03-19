package src.main.java.com.example.happy_fitness.service;

import java.util.List;

import net.blog.springboot.model.Contact;


public interface ContactService {
	List<Contact> getAllContact();
	Contact getContactById(long id);
}
