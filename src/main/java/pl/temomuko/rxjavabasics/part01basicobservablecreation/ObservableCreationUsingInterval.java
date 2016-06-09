package pl.temomuko.rxjavabasics.part01basicobservablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rafał on 08.06.2016.
 */
public class ObservableCreationUsingInterval implements Program {

    private static final int INITIAL_DELAY_IN_SECONDS = 0;
    private static final int INTERVAL_IN_SECONDS = 1;


    @Override
    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Observable.interval(INITIAL_DELAY_IN_SECONDS, INTERVAL_IN_SECONDS, TimeUnit.SECONDS)
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> {
                            countDownLatch.countDown();
                            System.out.print("\n    Completed");
                        }
                );
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ObservableCreationUsingTimer().run();
    }
}
