package pl.temomuko.rxjavabasics.part02customobservablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

/**
 * Created by Rafal on 09.06.2016.
 */
public class ObservableCreationUsingCreate implements Program {

    @Override
    public void run() {
        charsFromStringObservable("RxJava is Lightweight")
                .subscribe(
                        System.out::println,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.print("\n  Completed")
                );
    }

    private Observable<Character> charsFromStringObservable(String string) {
        return Observable.create(
                subscriber -> {
                    for (int i = 0; i < string.length(); i++) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext(string.charAt(i));
                    }
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                }
        );

    }

    public static void main(String[] args) {
        new ObservableCreationUsingCreate().run();
    }
}
