package pl.temomuko.rxjavabasics.part02customobservablecreation;

import pl.temomuko.rxjavabasics.util.Program;

/**
 * Created by Rafal on 09.06.2016.
 */
public class UsingCustomObservable implements Program {

    private static final String CHUCK_NORRIS_JOKES_FILENAME = "chuck_norris_jokes.txt";

    @Override
    public void run() {
        LinesFromTxtFileObservable.create(CHUCK_NORRIS_JOKES_FILENAME)
                .subscribe(
                        System.out::println,
                        System.err::print,
                        () -> System.out.print("\n  Completed")
                );
    }

    public static void main(String[] args) {
        new UsingCustomObservable().run();
    }
}
