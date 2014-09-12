package be.ticket;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Collection;
import java.util.Date;

//@Singleton
//@Startup
public class ClockBean {
    public static final String CLOCK_KEY = "clock";
    private int count = 0;

    @Resource
    private TimerService timerService;

    @Schedule(second = "*", minute = "*", hour = "*", persistent = false)
    public void printTheTime(Timer timer) {
        System.out.println("*****");
        System.out.println("TIME " + new Date());
        System.out.println("*****");
        cancelTimerIfNecessary(timer);

    }

    private void cancelTimerIfNecessary(Timer timer) {
        count++;
        if(count == 10) {
            timer.cancel();
        }
    }
}
