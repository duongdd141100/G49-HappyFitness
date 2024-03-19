package src.main.java.com.example.happy_fitness.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.blog.springboot.exception.ResourceNotFoundExeption;
import net.blog.springboot.model.Contact;
import net.blog.springboot.repository.ContactRepository;
import net.blog.springboot.repository.TournamentRepository;
import net.blog.springboot.service.ContactService;
@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactRepository contactRepository;
	
	

	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public List<Contact> getAllContact() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(long id) {
		return contactRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundExeption("COntact", "ID", id));
	}

}
