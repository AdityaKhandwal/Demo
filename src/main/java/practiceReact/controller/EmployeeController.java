package practiceReact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import practiceReact.entity.EmployeeEntity;
import practiceReact.service.EmployeeServiceClass;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceClass serviceClass;

    @PostMapping(value = "/register", consumes = "multipart/form-data")
    public ResponseEntity<String> registerEmployee(
            @ModelAttribute EmployeeEntity entity,
            @RequestParam("file") MultipartFile file) {

        try {
            serviceClass.employeeRegister(entity, file);
            return ResponseEntity.ok("Data updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Data not updated successfully");
        }
    }
}
