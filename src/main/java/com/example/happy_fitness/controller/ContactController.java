package src.main.java.com.example.happy_fitness.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.blog.springboot.model.Coach;
import net.blog.springboot.model.Contact;
import net.blog.springboot.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	private ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	@GetMapping
	public List<Contact> getAllContact(){
		return contactService.getAllContact();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Contact> getBlogById(@PathVariable("id") long coachId){
		return new ResponseEntity<Contact>(contactService.getContactById(coachId), HttpStatus.OK);
	}
}
