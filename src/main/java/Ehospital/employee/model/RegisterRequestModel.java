package Ehospital.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModel {

    @NotEmpty(message = "username must not be empty")
    private String username;
    @NotEmpty(message = "password must not be empty")
    private String password;
    @NotEmpty(message = "employee name must be define")
    private String employeeName;
    private Long empID;
    private String position;
    private String department;
    private String state;
    private String city;
    private String sex;
    private String maritalDesc;
    private String employmentStatus;
}
