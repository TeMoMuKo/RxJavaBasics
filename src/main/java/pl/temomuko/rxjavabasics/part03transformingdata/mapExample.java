package pl.temomuko.rxjavabasics.part03transformingdata;

import com.sun.xml.internal.ws.util.StringUtils;
import pl.temomuko.rxjavabasics.util.Program;
import rx.Observable;

/**
 * Created by Rafał on 08.06.2016.
 */
public class MapExample implements Program {

    @Override
    public void run() {
        Observable.just("dijkstra", "gates", "torvalds", "lovelace", "neumann")
                .map(StringUtils::capitalize)
                .map(str -> {
                    str += "a";
                    return str;
                })
                .toList()
                .subscribe(
                        System.out::print,
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.print("\n  Completed")
                );
    }

    public static void main(String[] args) {
        new MapExample().run();
    }
}
