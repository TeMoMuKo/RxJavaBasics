package pl.temomuko.rxjavabasics.part01observablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

/**
 * Created by Rafał on 08.06.2016.
 */
public class ObservableCreationUsingInterval implements Program {

    private static final int RANGE_START = 1;
    private static final int RANGE_COUNT = 10;

    @Override
    public void run() {
        getRangeObservable().subscribe(
                System.out::println,
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("Completed")
        );
    }

    private Observable<Integer> getRangeObservable() {
        return Observable.range(RANGE_START, RANGE_COUNT);
    }

    public static void main(String[] args) {
        new ObservableCreationUsingInterval().run();
    }
}
