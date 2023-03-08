package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.tlentity;
import com.example.demo.repository.tlrepo;
@Service
public class tlservice {
	@Autowired 
    tlrepo stRepo;
	
	public tlentity saveDetails(tlentity e) {
		return stRepo.save(e);
	}
	public List <tlentity>getDetails()

{
		return stRepo.findAll();
		
}
	public tlentity UpdateDetails(tlentity e1)
	{
		return stRepo.saveAndFlush(e1);
	}
	
	public void deleteDetails (int id)
	{		
	
	    stRepo.deleteById(id);	
	
	}
	public List<tlentity> getSorted(String field)                                                   
	{                                                                                                    
		return stRepo.findAll(Sort.by(Sort.Direction.ASC,field));                                        
	}                                                                                                    
	public List<tlentity> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) { 
		Page<tlentity> page =stRepo.findAll(PageRequest.of(offset, pageSize));                      
		return page.getContent();
	}
}