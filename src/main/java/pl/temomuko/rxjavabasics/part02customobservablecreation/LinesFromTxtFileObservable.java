package pl.temomuko.rxjavabasics.part02customobservablecreation;

import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Rafal on 09.06.2016.
 */

public class LinesFromTxtFileObservable implements Observable.OnSubscribe<String> {

    private final String mFilename;

    public static Observable<String> create(String filename) {
        return Observable.create(new LinesFromTxtFileObservable(filename));
    }

    private LinesFromTxtFileObservable(String filename) {
        mFilename = filename;
    }

    @Override
    public void call(Subscriber<? super String> subscriber) {
        try {
            InputStream fileInputStream = ClassLoader.getSystemClassLoader()
                    .getResourceAsStream(mFilename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            subscriber.add(Subscriptions.create(() -> {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onNext(line);
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }

        } catch (IOException e) {
            subscriber.onError(e);
        }
    }
}
