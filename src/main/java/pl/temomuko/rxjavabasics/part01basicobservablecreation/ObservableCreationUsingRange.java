package pl.temomuko.rxjavabasics.part01basicobservablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

/**
 * Created by Rafał on 08.06.2016.
 */
public class ObservableCreationUsingRange implements Program {

    private static final int RANGE_START = 1;
    private static final int RANGE_COUNT = 10;

    @Override
    public void run() {
        Observable.range(RANGE_START, RANGE_COUNT).subscribe(
                System.out::println,
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.print("\n  Completed")
        );
    }

    public static void main(String[] args) {
        new ObservableCreationUsingRange().run();
    }
}
