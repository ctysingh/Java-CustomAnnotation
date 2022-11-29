package com.example.customannotation.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);

    public Object getEmployeeById(Integer empId) {
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException exception) {
            LOGGER.error("Error occurred in business service : {}",exception.getMessage());
        }
        return empId;
    }
}
