package Ehospital.employee.service;

import Ehospital.employee.model.LoginRequestModel;
import Ehospital.employee.model.RegisterRequestModel;
import Ehospital.employee.model.RegisterResponseModel;
import Ehospital.employee.repository.EmployeeRepository;
import Ehospital.employee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public RegisterResponseModel register(RegisterRequestModel RegisterRequestModel){
        return null;
    }

    @Override
    public String login(LoginRequestModel loginRequestModel) {
        return null;
    }

    @Override
    public String uniqueId(String username) {
        return null;
    }

    private String generateUniqueId(String username){
        return null;
    }
}
