package edu.polytech.crud_rest_api;

import edu.polytech.crud_rest_api.model.Employee;
import edu.polytech.crud_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudRestApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRestApiApplication.class, args);
    }
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Donia");
        employee.setLastName("Chaouch");
        employee.setEmailId("donia@gmail.com");
        employeeRepository.save(employee);


        Employee employee1 = new Employee();
        employee1.setFirstName("Zayn");
        employee1.setLastName("Slimene");
        employee1.setEmailId("Zayn@gmail.com");
        employeeRepository.save(employee1);
    }
}
