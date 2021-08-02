package com.codegym.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Aspect
@Component
public class BookAspect {
    @Pointcut("within(com.codegym.controller.BookController*)")
    public void addMethodsPointCut() {
    }

    int count = 0;

    @Around("addMethodsPointCut()")
    public Object aroundCallMethod(ProceedingJoinPoint proceedingJoinPoint) {
        System.err.println("Time: " + LocalDate.now());
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        count++;
        System.err.println(value + "; Number active on page:" + " " + count);
        return value;
    }

    @Pointcut("execution(* com.codegym.controller.BookController.borrow(..))")
    public void addMethodsPointCutAfterBorrow() {
    }

    int countAfterBorrow = 0;

    @AfterReturning("addMethodsPointCutAfterBorrow()")
    public void AfterCallMethodBorrow(JoinPoint joinPoint) {
        countAfterBorrow++;
        System.err.println("Time:" + LocalDate.now() + ";" + joinPoint.getSignature().getName() + "; Number Active Borrow Book: " + countAfterBorrow);
    }

    @Pointcut("execution(* com.codegym.controller.BookController.returnBook(..))")
    public void addMethodsPointCutAfterReturn() {
    }

    int countAfterReturn = 0;

    @AfterReturning("addMethodsPointCutAfterReturn()")
    public void AfterCallMethodReturn(JoinPoint joinPoint) {
        countAfterReturn++;
        System.err.println("Time:" + LocalDate.now() + ";" + joinPoint.getSignature().getName() + "; Number Active Return Book: " + countAfterReturn);
    }
}
