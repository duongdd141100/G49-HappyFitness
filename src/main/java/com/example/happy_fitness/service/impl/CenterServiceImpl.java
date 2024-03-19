package src.main.java.com.example.happy_fitness.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.blog.springboot.model.Center;
import net.blog.springboot.repository.BlogRepository;
import net.blog.springboot.repository.CenterRepository;
import net.blog.springboot.service.CenterService;
@Service
public class CenterServiceImpl implements CenterService {

	
	private CenterRepository centerRepository;

	public CenterServiceImpl(CenterRepository centerRepository) {
		super();
		this.centerRepository = centerRepository;
	}

	@Override
	public List<Center> getAllCenter() {
		return centerRepository.findAll();
	}

	@Override
	public Center getCenterById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
