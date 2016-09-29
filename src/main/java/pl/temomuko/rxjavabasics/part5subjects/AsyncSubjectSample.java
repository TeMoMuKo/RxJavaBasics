package pl.temomuko.rxjavabasics.part5subjects;

import pl.temomuko.rxjavabasics.util.Program;
import rx.subjects.AsyncSubject;

/**
 * Created by rafal on 29.09.2016.
 */
public class AsyncSubjectSample implements Program {

    private static final AsyncSubject<String> ASYNC_SUBJECT = AsyncSubject.create();

    @Override
    public void run() {
        subscribeToAsyncSubject(1);

        ASYNC_SUBJECT.onNext("Cupcake");
        ASYNC_SUBJECT.onNext("Donut");
        ASYNC_SUBJECT.onNext("Eclair");

        subscribeToAsyncSubject(2);

        ASYNC_SUBJECT.onNext("Froyo");
        ASYNC_SUBJECT.onNext("Gingerbread");

        subscribeToAsyncSubject(3);

        ASYNC_SUBJECT.onCompleted();
        //ASYNC_SUBJECT.onError(new Throwable());

        subscribeToAsyncSubject(4);
    }

    private void subscribeToAsyncSubject(int subscriptionId) {
        ASYNC_SUBJECT.subscribe(
                string -> System.out.println("Subscription " + subscriptionId + " : " + string),
                System.err::println,
                () -> System.out.println("Subscription " + subscriptionId + " : " + "Completed"));
    }

    public static void main(String[] args) {
        new AsyncSubjectSample().run();
    }
}
