package edu.polytech.crud_rest_api.repository;

import edu.polytech.crud_rest_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all crud database methods
}
