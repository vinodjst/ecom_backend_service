package com.shopee.ecom.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessAspect {

    @Before("@annotation(AdminOnly)")
    public void checkAdminAccess(){

        System.out.println("checking admin access");

        boolean isAdmin = true;

        if(!isAdmin){
            throw new RuntimeException("Access Denied");
        }
    }
}
