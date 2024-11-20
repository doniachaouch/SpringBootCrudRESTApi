package edu.polytech.crud_rest_api.controller;

import edu.polytech.crud_rest_api.exception.RessourceNotFoundException;
import edu.polytech.crud_rest_api.model.Employee;
import edu.polytech.crud_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create employee with Rest Api
    @PostMapping
    public  Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    // build get employee by id with Rest Api
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->new RessourceNotFoundException("Employee not exist with id:"+id));
        return ResponseEntity.ok(employee);

    }
    //build update employee with REST api
    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable Long id ,@RequestBody Employee employeeDetails){
        Employee upadateEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new RessourceNotFoundException("Employee not exist with id:" +id ));
        upadateEmployee.setFirstName(employeeDetails.getFirstName());
        upadateEmployee.setLastName(employeeDetails.getLastName());
        upadateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(upadateEmployee);
        return ResponseEntity.ok(upadateEmployee);
    }

    //build delete employee with Rest api
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new RessourceNotFoundException("Employee not exixt with id:"+id));

        employeeRepository.delete(employee);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
