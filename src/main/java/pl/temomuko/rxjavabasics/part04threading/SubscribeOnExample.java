package pl.temomuko.rxjavabasics.part04threading;

import pl.temomuko.rxjavabasics.part02customobservablecreation.LinesFromTxtFileObservable;
import pl.temomuko.rxjavabasics.util.Program;
import pl.temomuko.rxjavabasics.util.RxJavaUtils;
import rx.schedulers.Schedulers;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Rafal on 09.06.2016.
 */
public class SubscribeOnExample implements Program {

    private static final String CHUCK_NORRIS_JOKES_FILENAME = "chuck_norris_jokes.txt";

    @Override
    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        LinesFromTxtFileObservable.create(CHUCK_NORRIS_JOKES_FILENAME)
                .doOnEach(RxJavaUtils.debug())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        System.out::println,
                        System.err::print,
                        () -> {
                            System.out.print("\n  Completed");
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
        new SubscribeOnExample().run();
    }
}
