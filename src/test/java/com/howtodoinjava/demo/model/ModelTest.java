package com.howtodoinjava.demo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.InjectService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.DemoApplicationTests;
import com.project.mvc.exception.RecordNotFoundException;
import com.project.mvc.model.EmployeeEntity;
import com.project.mvc.repository.EmployeeRepository;
import com.project.mvc.service.EmployeeService;

public class ModelTest extends DemoApplicationTests {

	@MockBean
	EmployeeService service;
	@Mock
	EmployeeRepository repo;
	@Mock
	EmployeeEntity entity = new EmployeeEntity();
	List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();

	@Before
	public void initialize() {

		entity.setFirstName("vishak");
		entity.setId(10);
		entity.setEmail("vvv");
		entity.setLastName("w");
		list.add(entity);

	}

//	@Test
//	public void getAllEmployees_serviceTest() {
//		when(service.getAllEmployees()).thenReturn(list);
//	}

	@Test
	public void getEmployeesById_serviceTest() throws RecordNotFoundException {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setId(10);
		entity.setFirstName("vishak");

		entity.setEmail("vvv");
		entity.setLastName("w");
		list.add(entity);
		int id = 10;
		//when(repo.findById(id)).thenReturn(Optional.of(entity));
		when(service.getEmployeeById(id)).thenReturn((entity));
		// assertEquals(repo.findById(id), repo.findById(id));
	}

	@Test
	public void entityCheck() {
		assertEquals(entity, entity);
	}

}
