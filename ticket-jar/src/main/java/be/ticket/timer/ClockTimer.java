package be.ticket.timer;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Date;

/**
 * Created by MLPAU49 on 12/09/2014.
 */

@Singleton
public class ClockTimer {

    @Resource
    private TimerService timerService;

    private int count = 0;

    @Schedule(hour = "*",minute = "*", second = "*", persistent = false)
    public void printTheTime(Timer timer) {
        System.out.println("Master time tells you it is now: " + new Date());
        count++;
        if (count > 10) {
            timer.cancel();
        }
    }
}
