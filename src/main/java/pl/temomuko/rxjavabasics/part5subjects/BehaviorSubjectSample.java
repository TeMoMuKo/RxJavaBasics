package pl.temomuko.rxjavabasics.part5subjects;

import pl.temomuko.rxjavabasics.util.Program;
import rx.subjects.BehaviorSubject;

/**
 * Created by rafal on 29.09.2016.
 */
public class BehaviorSubjectSample implements Program {

    private static final BehaviorSubject<String> BEHAVIOR_SUBJECT = BehaviorSubject.create();

    @Override
    public void run() {
        subscribeToBehaviorSubject(1);

        BEHAVIOR_SUBJECT.onNext("Cupcake");
        BEHAVIOR_SUBJECT.onNext("Donut");
        BEHAVIOR_SUBJECT.onNext("Eclair");

        subscribeToBehaviorSubject(2);

        BEHAVIOR_SUBJECT.onNext("Froyo");
        BEHAVIOR_SUBJECT.onNext("Gingerbread");

        subscribeToBehaviorSubject(3);

        BEHAVIOR_SUBJECT.onCompleted();
        //BEHAVIOR_SUBJECT.onError(new Throwable());

        subscribeToBehaviorSubject(4);
    }

    private void subscribeToBehaviorSubject(int subscriptionId) {
        BEHAVIOR_SUBJECT.subscribe(
                string -> System.out.println("Subscription " + subscriptionId + " : " + string),
                System.err::println,
                () -> System.out.println("Subscription " + subscriptionId + " : " + "Completed"));
    }

    public static void main(String[] args) {
        new BehaviorSubjectSample().run();
    }
}
