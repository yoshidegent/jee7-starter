package be.ticket.dao;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {
    @AroundInvoke
    public Object log(InvocationContext ic) {
        System.out.println("Intercepted call to " + ic.getMethod().getName());
        try {
            return ic.proceed();
        } catch (Exception exception) {
            throw new RuntimeException("Broken call", exception);
        }
    }
}
