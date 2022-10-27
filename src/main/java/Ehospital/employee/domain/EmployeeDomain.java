package Ehospital.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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

    public EmployeeDomain(String employeeName, Long empID, String position, String department, String state, String city, String sex, String maritalDesc, String employmentStatus) {
        this.employeeName = employeeName;
        this.empID = empID;
        this.position = position;
        this.department = department;
        this.state = state;
        this.city = city;
        this.sex = sex;
        this.maritalDesc = maritalDesc;
        this.employmentStatus = employmentStatus;
    }
}
