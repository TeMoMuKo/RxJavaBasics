package pl.temomuko.rxjavabasics.util;

import rx.Notification;
import rx.functions.Action1;

/**
 * Created by Rafał on 08.06.2016.
 */
public class RxJavaUtils {
    private static final String DEBUG = " DEBUG: ";

    public static <T> Action1<Notification<? super T>> debug(String description) {
        return (Notification<? super T> notification) -> {
            switch (notification.getKind()) {
                case OnNext:
                    System.out.println("    " + DEBUG + description + Thread.currentThread().getName() + " VALUE: " + notification.getValue());
                    break;
                case OnError:
                    System.err.println("    " + DEBUG + description + Thread.currentThread().getName() + " ERROR");
                    break;
                case OnCompleted:
                    System.out.println("    " + DEBUG + description + Thread.currentThread().getName() + " COMPLETION"
                    );
                    break;
                default:
                    break;
            }
        };
    }
}
