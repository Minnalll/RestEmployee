package com.employee.contact.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.contact.model.EmpContact;
import com.employee.contact.repository.ContactRepo;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;

@Service
public class ConServiceImpl implements IConService {
	@Autowired
	private ContactRepo repo;
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public EmpContact getContact(int contactid) {
		return this.repo.findById(contactid)
				.orElseThrow(()->new ResourceNotFoundException("Contact ID not FOund : " + contactid));
	}

	@Override
	public List<EmpContact> getContacts() {
		List<EmpContact> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public String deleteContact(int eCode) {
		Optional<EmpContact> findById = repo.findById(eCode);
		if (findById.isPresent()) {
			repo.deleteById(eCode);
			return "Contact : " + eCode +" is deleted from DB.";
		}
		return null;
	}
	
	public EmpContact updateContact(int ecode,EmpContact contact) {
		return this.repo.findById(ecode)
				.map(conl -> {

					if (null == contact.getContacttype()) {	
					} else {
						conl.setContacttype(contact.getContacttype());
					}
					if (null == contact.getContactvalue()) {						
					} 
					else {
						conl.setContactvalue(contact.getContactvalue());
					}
					if (null == contact.getIsactive()) {							
					} else {
						conl.setIsactive(contact.getIsactive());
					}
					return repo.save(conl);
				})
				.orElseThrow(() ->new ResourceNotFoundException("Contact not found with id :" + ecode));
	}

	@Override
	public EmpContact createContact(EmpContact contact) {
			return repo.save(contact);
	}
	
	public List<EmpContact> findByIsActive() {
		return findByIsActive();
	} 
	
	

	
}
