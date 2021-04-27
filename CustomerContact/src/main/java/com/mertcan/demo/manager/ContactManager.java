package com.mertcan.demo.manager;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mertcan.demo.dto.ContactDTO;
import com.mertcan.demo.entity.Contact;
import com.mertcan.demo.repository.IContactRepo;
import com.mertcan.demo.service.IContactService;

@Service
public class ContactManager implements IContactService{

	@Autowired
	private IContactRepo contactRepo;
    private ModelMapper modelMapper;

    public ContactManager(IContactRepo contactRepo, ModelMapper modelMapper) {
        this.contactRepo = contactRepo;
        this.modelMapper = modelMapper;
    }
	
	@Override
	public void save(Contact contact) {
		contactRepo.save(contact);		
	}

	@Override
	public List<ContactDTO> getAll() {
		List<Contact> listContact = contactRepo.findAll();
		return Arrays.asList(modelMapper.map(listContact, ContactDTO[].class));
	}

	@Override
	public ContactDTO update(Long id, ContactDTO contactDTO) {
		Contact contact = contactRepo.getOne(id);
		contact.setDate(contactDTO.getDate());
		contact.setTime(contactDTO.getTime());
		contact.setSubject(contactDTO.getSubject());
		contact.setDescription(contactDTO.getDescription());
		return modelMapper.map(contact, ContactDTO.class);
	}

	@Override
	public ContactDTO getById(Long id) {
		return modelMapper.map(contactRepo.getOne(id),ContactDTO.class);
	}

	@Override
	public Boolean delete(Long id) {
		contactRepo.deleteById(id);
		return true;
	}
	

}
