package com.example.customannotation.annotation;

import javassist.NotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;


import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class TokenSecurityChecker {
    @Around("@annotation(SecureWithToken)")
    public Object Validator(ProceedingJoinPoint call) throws Throwable, NotFoundException {

        Object[] args = call.getArgs();
        String access_token=null;
        for(Object obj: args){
            if(obj instanceof HttpServletRequest) {
                access_token = ((HttpServletRequest) obj).getHeader("access_token"); //access_token supplied in header
                if (access_token == null) {
                    access_token = ((HttpServletRequest) obj).getParameter("access_token"); // access_roken supplied in request parameters    }
                }
            }
        }
        Object result = call.proceed();
        if(access_token != null && access_token.equals("validtoken") ) {
            return result;
        } else {
            throw new NotFoundException("Not Authorized");
        }
    }
}
