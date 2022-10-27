package Ehospital.employee.service;

import Ehospital.employee.domain.EmployeeDomain;
import Ehospital.employee.domain.UserDomain;
import Ehospital.employee.model.LoginRequestModel;
import Ehospital.employee.model.RegisterRequestModel;
import Ehospital.employee.model.RegisterResponseModel;
import Ehospital.employee.repository.EmployeeRepository;
import Ehospital.employee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public RegisterResponseModel register(RegisterRequestModel registerRequestModel) {
        try {
            EmployeeDomain employeeDomain = new EmployeeDomain(registerRequestModel.getEmployeeName(),
                    registerRequestModel.getEmpID(),
                    registerRequestModel.getPosition(),
                    registerRequestModel.getDepartment(),
                    registerRequestModel.getState(),
                    registerRequestModel.getCity(),
                    registerRequestModel.getSex(),
                    registerRequestModel.getMaritalDesc(),
                    registerRequestModel.getEmploymentStatus());

            employeeRepository.save(employeeDomain);
            UserDomain userDomain = new UserDomain(registerRequestModel.getUsername(), registerRequestModel.getPassword());
            userDomain.setEmployeeId(employeeDomain.getId());

            String uniqueId = generateUniqueId(registerRequestModel.getEmployeeName());
            userDomain.setUniqueId(uniqueId);
            userRepository.save(userDomain);
            return new RegisterResponseModel("user registered successfully", uniqueId);

        } catch (Exception e) {
            throw new BadCredentialsException("error on registering user");
        }
    }

    @Override
    public String login(LoginRequestModel loginRequestModel) {
        if (loginRequestModel.getUniqueId() != null) {
            UserDomain userDomain = userRepository.findByUniqueId(loginRequestModel.getUniqueId());
            if (userDomain == null)
                throw new UsernameNotFoundException("username not found");
            else if (!loginRequestModel.getPassword().equals(userDomain.getPassword()))
                throw new BadCredentialsException("password incorrect");
        } else if (loginRequestModel.getUsername() != null) {
            UserDomain userDomain = userRepository.findByUsername(loginRequestModel.getUsername());
            if (userDomain == null)
                throw new UsernameNotFoundException("username not found");
            else if (!loginRequestModel.getPassword().equals(userDomain.getPassword()))
                throw new BadCredentialsException("password incorrect");
        }
        return "ok";
    }

    @Override
    public String uniqueId(String username) {
        UserDomain userDomain = userRepository.findByUsername(username);
        if (userDomain != null)
            return userDomain.getUniqueId();
        else throw new UsernameNotFoundException("username not found");
    }

    private String generateUniqueId(String employeeName) {
        String idChar = employeeName + "1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (stringBuilder.length() < 10) { // length of the random string.
            int index = (int) (random.nextFloat() * idChar.length());
            stringBuilder.append(idChar.charAt(index));
        }
        return stringBuilder.toString();
    }
}
