package com.example.customannotation.annotation;

import javassist.NotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;


import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TokenSecurityChecker {
    @Around("@annotation(SecureWithToken)")
    public Object Validator(ProceedingJoinPoint call) throws Throwable, NotFoundException {
        Object result = call.proceed();
        if(false) {
            return result;
        } else {
            throw new NotFoundException("Not Authorized");
        }
    }
}
