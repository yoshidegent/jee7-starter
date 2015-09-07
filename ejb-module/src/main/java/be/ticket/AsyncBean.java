package be.ticket;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

@Stateless
@Asynchronous
public class AsyncBean {
    public Future<Integer> whatIsTheAnswerToLifeTheUniverseAndEverything() {
        for(int i = 0; i < 10; i++) {
            yawn();
            System.out.println("**************** WORKING ON IT ");
        }
        System.out.println("***************** FINISHED WORK! + ");
        return new AsyncResult<>(42);
    }

    private void yawn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
