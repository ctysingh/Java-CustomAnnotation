package com.example.customannotation.controller;

import com.example.customannotation.annotation.SecureWithToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @GetMapping("/test")
    @SecureWithToken
    public List<Integer> testAnnotation(HttpServletRequest request) throws InterruptedException {
        System.out.println("Request is authenticated");
        List<Integer> ret = new ArrayList<>(Arrays.asList(100,2,10));
        return ret;
    }
}
