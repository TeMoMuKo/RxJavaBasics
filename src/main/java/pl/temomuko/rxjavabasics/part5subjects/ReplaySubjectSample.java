package pl.temomuko.rxjavabasics.part5subjects;

import pl.temomuko.rxjavabasics.util.Program;
import rx.subjects.ReplaySubject;

/**
 * Created by rafal on 29.09.2016.
 */
public class ReplaySubjectSample implements Program {

    private static final ReplaySubject<String> REPLAY_SUBJECT = ReplaySubject.createWithSize(2);

    @Override
    public void run() {
        subscribeToReplaySubject(1);

        REPLAY_SUBJECT.onNext("Cupcake");
        REPLAY_SUBJECT.onNext("Donut");
        REPLAY_SUBJECT.onNext("Eclair");

        subscribeToReplaySubject(2);

        REPLAY_SUBJECT.onNext("Froyo");
        REPLAY_SUBJECT.onNext("Gingerbread");

        subscribeToReplaySubject(3);

        REPLAY_SUBJECT.onCompleted();
        //REPLAY_SUBJECT.onError(new Throwable());

        subscribeToReplaySubject(4);
    }

    private void subscribeToReplaySubject(int subscriptionId) {
        REPLAY_SUBJECT.subscribe(
                string -> System.out.println("Subscription " + subscriptionId + " : " + string),
                System.err::println,
                () -> System.out.println("Subscription " + subscriptionId + " : " + "Completed"));
    }

    public static void main(String[] args) {
        new ReplaySubjectSample().run();
    }
}
