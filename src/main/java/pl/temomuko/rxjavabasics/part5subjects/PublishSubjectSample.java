package pl.temomuko.rxjavabasics.part5subjects;

import pl.temomuko.rxjavabasics.util.Program;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by rafal on 29.09.2016.
 */
public class PublishSubjectSample implements Program {

    private static final PublishSubject<String> PUBLISH_SUBJECT = PublishSubject.create();

    @Override
    public void run() {
        subscribeToPublishSubject(1);

        PUBLISH_SUBJECT.onNext("Cupcake");
        PUBLISH_SUBJECT.onNext("Donut");
        PUBLISH_SUBJECT.onNext("Eclair");

        subscribeToPublishSubject(2);

        PUBLISH_SUBJECT.onNext("Froyo");
        PUBLISH_SUBJECT.onNext("Gingerbread");

        subscribeToPublishSubject(3);

        PUBLISH_SUBJECT.onCompleted();
        //PUBLISH_SUBJECT.onError(new Throwable());

        subscribeToPublishSubject(4);
    }

    private void subscribeToPublishSubject(int subscriptionId) {
        PUBLISH_SUBJECT.subscribe(
                string -> System.out.println("Subscription " + subscriptionId + " : " + string),
                System.err::println,
                () -> System.out.println("Subscription " + subscriptionId + " : " + "Completed"));
    }

    public static void main(String[] args) {
        new PublishSubjectSample().run();
    }
}
