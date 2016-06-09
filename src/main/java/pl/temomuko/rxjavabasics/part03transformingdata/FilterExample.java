package pl.temomuko.rxjavabasics.part03transformingdata;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

/**
 * Created by Rafał on 08.06.2016.
 */
public class FilterExample implements Program {

    private static final int RANGE_START = 1;
    private static final int RANGE_COUNT = 10;

    @Override
    public void run() {
        System.out.println("Even numbers from " + RANGE_START + " to " + RANGE_COUNT + " : ");
        Observable.range(RANGE_START, RANGE_COUNT)
                .filter(value -> value % 2 == 0)
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.print("\n  Completed")
                );
    }

    public static void main(String[] args) {
        new FilterExample().run();
    }
}
