package Ehospital.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeDomain {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "emp_id")
    private Long empID;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "sex")
    private String sex;

    @Column(name = "marital_desc")
    private String maritalDesc;

    @Column(name = "employment_Status")
    private String employmentStatus;

}
