package pl.temomuko.rxjavabasics.part02acustomobservablecreationwithfromemitter;

import pl.temomuko.rxjavabasics.util.Program;
import rx.AsyncEmitter;
import rx.Observable;
import rx.subscriptions.Subscriptions;

import java.io.*;

/**
 * Created by Rafal on 09.06.2016.
 */
public class ObservableCreationUsingFromEmitter implements Program {

    private static final String CHUCK_NORRIS_JOKES_FILENAME = "chuck_norris_jokes.txt";

    @Override
    public void run() {
        linesFromTxtObservable()
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> System.out.print("\n  Completed")
                );
    }

    private Observable<String> linesFromTxtObservable() {
        return Observable.fromEmitter(emitter -> {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    ClassLoader.getSystemClassLoader().getResourceAsStream(CHUCK_NORRIS_JOKES_FILENAME)))) {

                emitter.setCancellation(bufferedReader::close);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    emitter.onNext(line);
                }

            } catch (IOException e) {
                emitter.onError(e);
            }
        }, AsyncEmitter.BackpressureMode.BUFFER);

    }

    public static void main(String[] args) {
        new ObservableCreationUsingFromEmitter().run();
    }
}
