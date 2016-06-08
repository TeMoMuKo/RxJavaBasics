package pl.temomuko.rxjavabasics.part01observablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

/**
 * Created by Rafał on 08.06.2016.
 */
public class ObservableCreationUsingJust implements Program {

    @Override
    public void run() {
        getAboutObserverObservable().subscribe(
                string -> System.out.print(string + " "),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("Completed")
        );
    }

    private Observable<String> getAboutObserverObservable() {
        return Observable.just("In", "ReactiveX", "an", "observer", "subscribes", "to", "an", "Observable.");
    }

    public static void main(String[] args) {
        new ObservableCreationUsingJust().run();
    }
}
