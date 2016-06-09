package pl.temomuko.rxjavabasics.part01basicobservablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rafał on 08.06.2016.
 */
public class ObservableCreationUsingTimer implements Program {

    private static final int DELAY_IN_SECONDS = 4;


    @Override
    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Observable.timer(DELAY_IN_SECONDS, TimeUnit.SECONDS)
                .subscribe(
                        System.out::print,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> {
                            System.out.print("\n    Completed");
                            countDownLatch.countDown();
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
