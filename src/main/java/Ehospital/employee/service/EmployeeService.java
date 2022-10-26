package Ehospital.employee.service;

import Ehospital.employee.model.LoginRequestModel;
import Ehospital.employee.model.RegisterRequestModel;
import Ehospital.employee.model.RegisterResponseModel;

public interface EmployeeService {

    RegisterResponseModel register(RegisterRequestModel RegisterRequestModel);
    String login(LoginRequestModel loginRequestModel);
    String uniqueId(String username);
}
