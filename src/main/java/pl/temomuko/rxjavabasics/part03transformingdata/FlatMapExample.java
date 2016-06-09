package pl.temomuko.rxjavabasics.part03transformingdata;

import pl.temomuko.rxjavabasics.part02customobservablecreation.CharsFromStringObservable;
import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Rafał on 08.06.2016.
 */
public class FlatMapExample implements Program {

    @Override
    public void run() {
        Observable.just("Dijkstra", "Gates", "Torvalds", "Lovelace", "Neumann")
                .flatMap(CharsFromStringObservable::create)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        System.out::print,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.print("\n  Completed")
                );
    }

    public static void main(String[] args) {
        new FlatMapExample().run();
    }
}
