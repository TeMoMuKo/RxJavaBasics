package pl.temomuko.rxjavabasics.part01basicobservablecreation;

import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rafal on 09.06.2016.
 */
public class ObservableCreationUsingFrom implements Program {

    @Override
    public void run() {
        List<String> list = Arrays.asList("R", "x", "J", "a", "v", "a");
        Observable.from(list).subscribe(
                System.out::print,
                throwable -> System.out.print(throwable.getMessage()),
                () -> System.out.print("\n    Completed")
        );
    }


    public static void main(String[] args) {
        new ObservableCreationUsingFrom().run();
    }
}
