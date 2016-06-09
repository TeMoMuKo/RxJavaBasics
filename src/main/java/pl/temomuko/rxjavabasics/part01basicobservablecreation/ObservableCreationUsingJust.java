package pl.temomuko.rxjavabasics.part01basicobservablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

/**
 * Created by Rafał on 08.06.2016.
 */
public class ObservableCreationUsingJust implements Program {

    @Override
    public void run() {
        Observable.just("In", "ReactiveX", "an", "observer", "subscribes", "to", "an", "Observable.")
                .subscribe(
                        string -> System.out.print(string + " "),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.print("\n  Completed")
                );
    }

    public static void main(String[] args) {
        new ObservableCreationUsingJust().run();
    }
}
