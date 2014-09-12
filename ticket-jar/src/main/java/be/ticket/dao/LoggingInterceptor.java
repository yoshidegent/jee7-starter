package be.ticket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.InvocationContext;

public class LoggingInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    public Object log(InvocationContext ic) {
        logger.info("Intercepted call to " + ic.getMethod().getName());
        try {
            return ic.proceed();
        } catch (Exception exception) {
            throw new RuntimeException("Broken call", exception);
        }
    }
}
