package com.employee.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.contact.model.EmpContact;
import com.employee.contact.service.ConServiceImpl;
import com.employee.service.ServiceImpl;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ConServiceImpl service;
	
	@GetMapping("/findall")
	public List<EmpContact> findAll(){
		return service.getContacts();
	}
	
	@GetMapping("/findcon/{contactid}")
	public EmpContact findAll(@PathVariable int contactid){
		return service.getContact(contactid);
	}
	
	@PostMapping("/createcontact")
	public EmpContact createContact(@RequestBody EmpContact contact) {
		return service.createContact(contact);
	}
	
	@DeleteMapping("/deletecon/{contactid}")
	public String deleteContact (@PathVariable int contactid) {	
		return service.deleteContact(contactid);
	} 
	
	@PutMapping("/updatecon/{ecode}")
	public EmpContact updateContact(@PathVariable int ecode,@RequestBody EmpContact contact) {		
		return service.updateContact(ecode, contact);
	}
	
	@GetMapping("/isactive")
	public List<EmpContact> findByIsActive() {
		return findByIsActive();
	} 
	

}
