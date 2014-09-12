package be.ticket;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Collection;
import java.util.Date;

@Singleton
public class ClockBean {
    private int count = 0;

    @Resource
    private TimerService timerService;

    @Schedule(second = "*", minute = "*", hour = "*", persistent = false)
    public void printTime() {
        System.out.println("*****");
        System.out.println("TIME " + new Date());
        System.out.println("*****");
        cancelTimerIfNecessary();
    }

    private void cancelTimerIfNecessary() {
        count++;
        if(count == 10) {
            Collection<Timer> timers = timerService.getTimers();
            for (Timer timer : timers) {
                timer.cancel();
            }
        }
    }
}
