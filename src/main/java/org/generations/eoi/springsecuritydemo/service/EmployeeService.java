package org.generations.eoi.springsecuritydemo.service;

import org.generations.eoi.springsecuritydemo.entity.Employee;
import org.generations.eoi.springsecuritydemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Long id){
        return employeeRepository.findById(id);
    }

    public Employee getEmployeeByUserName(String username){
        return employeeRepository.findByUsername(username);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }


}
