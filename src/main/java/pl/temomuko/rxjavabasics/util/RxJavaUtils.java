package pl.temomuko.rxjavabasics.util;

import rx.Notification;
import rx.functions.Action1;

/**
 * Created by Rafał on 08.06.2016.
 */
public class RxJavaUtils {
    private static final String DEBUG = "Debug: ";

    public static <T> Action1<Notification<? super T>> debug() {
        return (Notification<? super T> notification) -> {
            switch (notification.getKind()) {
                case OnNext:
                    System.out.println("    " + DEBUG + Thread.currentThread().getName() + " VALUE: " + notification.getValue());
                    break;
                case OnError:
                    System.err.println("    " + DEBUG + Thread.currentThread().getName() + " ERROR");
                    break;
                case OnCompleted:
                    System.out.println("    " + DEBUG + Thread.currentThread().getName() + " COMPLETION"
                    );
                    break;
                default:
                    break;
            }
        };
    }
}
