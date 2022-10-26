package Ehospital.employee.repository;

import Ehospital.employee.domain.EmployeeDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDomain,Long> {
}
