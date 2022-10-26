package Ehospital.employee.domain;

import Ehospital.employee.model.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "emp_id")
    private Long empID;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    @Enumerated(EnumType.ORDINAL)
    private DepartmentEnum department;

    @Column(name = "state")
    @Enumerated(EnumType.ORDINAL)
    private StateEnum state;

    @Column(name = "city")
    private String city;

    @Column(name = "sex")
    @Enumerated(EnumType.ORDINAL)
    private SexEnum sex;

    @Column(name = "marital_desc")
    @Enumerated(EnumType.ORDINAL)
    private MaritalDescEnum maritalDesc;

    @Column(name = "employment_Status")
    @Enumerated(EnumType.ORDINAL)
    private EmploymentStatusEnum employmentStatus;

}
