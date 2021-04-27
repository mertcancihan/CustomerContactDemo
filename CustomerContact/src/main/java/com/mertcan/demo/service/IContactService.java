package com.mertcan.demo.service;

import java.util.List;

import com.mertcan.demo.dto.ContactDTO;
import com.mertcan.demo.entity.Contact;

public interface IContactService {
	
	void save(Contact contact);

    List<ContactDTO> getAll();
    
    ContactDTO update (Long id, ContactDTO contactDTO);
    
    ContactDTO getById(Long id);
    
    Boolean delete(Long id);
}
