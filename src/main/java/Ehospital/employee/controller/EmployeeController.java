package Ehospital.employee.controller;

import Ehospital.employee.model.LoginRequestModel;
import Ehospital.employee.model.RegisterRequestModel;
import Ehospital.employee.model.RegisterResponseModel;
import Ehospital.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/register")
    public ResponseEntity<RegisterResponseModel> register(@Valid @RequestBody RegisterRequestModel registerRequestModel){
        return ResponseEntity.ok(employeeService.register(registerRequestModel));
    }
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestModel loginRequestModel){
        return ResponseEntity.ok(employeeService.login(loginRequestModel));
    }
    @GetMapping(path = "unique-id" )
    public ResponseEntity<String> getUniqueId(@RequestParam(value = "username") String username){
        return ResponseEntity.ok(employeeService.uniqueId(username));
    }

}
