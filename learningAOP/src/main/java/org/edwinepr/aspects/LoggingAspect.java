package org.edwinepr.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.edwinepr.model.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* org.edwinepr.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(args) +
                " will execute");

        Comment comment = new Comment();
        comment.setText("Spring and AOP are amazing!");
        Object[] newArgs = {comment};

        Object returnedByMethod = joinPoint.proceed(newArgs);
        logger.info("Method executed and returned: " + returnedByMethod);
        return "FAILED";
    }
}
