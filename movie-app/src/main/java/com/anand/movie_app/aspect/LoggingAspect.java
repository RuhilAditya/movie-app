package com.anand.movie_app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.anand.movie_app.service.CustomerProfileService.saveCustomer(..))")
    public void logBefore (JoinPoint joinPoint) {
        System.out.println("[Before] Method called: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.anand.movie_app.service.CustomerProfileService.getCustomerById(..))")
    public void lofAfter (JoinPoint joinPoint) {
        System.out.println("[After] Completed: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(* com.anand.movie_app.service.CustomerProfileService.getCustomerById(..))",
            returning = "result"
    )    public void logAfterReturning (Object result) {
        if(result != null) {
            System.out.println("[AfterReturning] Category fetched: " + result);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.anand.movie_app.service.CustomerProfileService.deleteCustomer(..))",
            throwing = "ex"
    )
    public void logException (Throwable e) {
        System.out.println("[AfterThrowing] Exception caught: " + e.getMessage());
    }

    @Around("execution(* com.anand.movie_app.controller.CustomerProfileController.*(..))")
    public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("[Around] Execution time of " + joinPoint.getSignature().getName() + ": " + duration + " ms");
        return result;
    }
}
