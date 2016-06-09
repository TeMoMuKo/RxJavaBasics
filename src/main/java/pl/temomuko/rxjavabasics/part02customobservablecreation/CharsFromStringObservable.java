package pl.temomuko.rxjavabasics.part02customobservablecreation;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Rafal on 09.06.2016.
 */
public class CharsFromStringObservable implements Observable.OnSubscribe<Character> {

    private final String mString;

    public static Observable<Character> create(String string) {
        return Observable.create(new CharsFromStringObservable(string));
    }

    private CharsFromStringObservable(String string) {
        mString = string;
    }

    @Override
    public void call(Subscriber<? super Character> subscriber) {
        for (int i = 0; i < mString.length(); i++) {
            if (subscriber.isUnsubscribed()) {
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subscriber.onNext(mString.charAt(i));
        }
        if (!subscriber.isUnsubscribed()) {
            subscriber.onCompleted();
        }
    }
}
