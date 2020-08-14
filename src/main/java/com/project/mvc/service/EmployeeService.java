package com.project.mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mvc.exception.RecordNotFoundException;
import com.project.mvc.model.EmployeeDto;
import com.project.mvc.model.EmployeeEntity;
import com.project.mvc.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	ModelMapper modelMapper = new ModelMapper();
	EmployeeDto empDto = new EmployeeDto();

	public List<EmployeeDto> getAllEmployees() {
		String exp = "\n\n\n\t\t\t";
		final Logger logger = LoggerFactory.getLogger(this.getClass());
		List<EmployeeEntity> employeeList = repository.findAll();
		
		if (employeeList != null) {
			logger.info("getting Data From Dto classes*******" + exp + employeeList.toString());
			
			  return ((List<EmployeeEntity>)
			  repository.findAll()).stream().map(this::convertEntitytoDto)
			  .collect(Collectors.toList());
			 
		} else {
			return new ArrayList<EmployeeDto>();
		}
	}

	private EmployeeDto convertEntitytoDto(EmployeeEntity entity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		EmployeeDto empDto = modelMapper.map(entity, EmployeeDto.class);
		return empDto;
	}

	public EmployeeEntity getEmployeeById(Integer id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(entity.getId());

		if (employee.isPresent()) {
			EmployeeEntity newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteEmployeeById(Integer id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}