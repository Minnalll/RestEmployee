package com.employee;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.employee.controller.EmployeeController;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class RestEmployeeTest {
	// End Path
	private static final String END_POINT_PATH = "/employee/create";
	
	// prerequisites
	@Autowired
	MockMvc mockMvc;
	// convert Json into String
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	private EmployeeRepo repo;
	@MockBean
	private ServiceImpl service;
	
	@Test
	public void testAddShouldReturn201Created() throws Exception{
		Employee newUser = new Employee(1, "Udaya", "Kumar","D", null, null, null, null);
		
		String requestBody = mapper.writeValueAsString(newUser);
		
		mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
				.content(requestBody))
				.andExpect(status().is2xxSuccessful());		
	}
	@Test
	public void testAddShouldReturn400Created() throws Exception{
		Employee newUser = new Employee(1, null, null,null, null, null, null, null);
		
		String requestBody = mapper.writeValueAsString(newUser);
		
		mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
				.content(requestBody))
				.andExpect(status().is4xxClientError());		
	}
}
