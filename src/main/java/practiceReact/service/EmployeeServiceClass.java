package practiceReact.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import practiceReact.JpaRepository.EmployeeJpaRepository;
import practiceReact.entity.EmployeeEntity;

@Service
public class EmployeeServiceClass {

    @Autowired
    private EmployeeJpaRepository repository;

    public void employeeRegister(EmployeeEntity entity, MultipartFile file)
            throws IOException {

        // 1️⃣ Save employee to DB
        repository.save(entity);

        // 2️⃣ Save file
        if (file != null && !file.isEmpty()) {

            String uploadDir = "D:/uploads/";

            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs(); // 🔥 THIS WAS MISSING
            }

            File dest = new File(uploadDir + file.getOriginalFilename());
            file.transferTo(dest);
        }
    }
}

