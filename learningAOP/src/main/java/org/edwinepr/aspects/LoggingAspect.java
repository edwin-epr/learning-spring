package org.edwinepr.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.edwinepr.model.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue) throws Throwable {
        logger.info("Method executed and returned: " + returnedValue);
    }

    @Before("@annotation(ToLog)")
    public void logBefore(JoinPoint joinPoint) throws Throwable {
        logger.info("Before method: " + joinPoint.getSignature().getName());
    }
}
