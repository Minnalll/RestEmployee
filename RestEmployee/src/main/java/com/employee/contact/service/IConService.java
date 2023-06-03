package com.employee.contact.service;

import java.util.List;

import com.employee.contact.model.EmpContact;
import com.employee.model.Employee;

public interface IConService {
	
	public EmpContact getContact(int contactid);
	
	List<EmpContact> getContacts();
	
	String deleteContact (int contactid);

	EmpContact updateContact(int contactid, EmpContact contact);

//	EmpContact createContact(int ecode, EmpContact contact);
	
	public List<EmpContact> findByIsActive();

	EmpContact createContact(EmpContact contact); 

}
