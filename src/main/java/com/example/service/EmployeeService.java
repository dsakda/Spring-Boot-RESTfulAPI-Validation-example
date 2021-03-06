package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id : " + employeeId));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException {

        Employee employee = getEmployeeById(employeeId);

        employee.setEmailAddress(employeeDetails.getEmailAddress());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setPassportNumber(employeeDetails.getPassportNumber());
        employee.setBirthDay(employeeDetails.getBirthDay());

        return saveEmployee(employee);
    }

    public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
        Employee employee = getEmployeeById(employeeId);
        employeeRepository.delete(employee);
    }
}
