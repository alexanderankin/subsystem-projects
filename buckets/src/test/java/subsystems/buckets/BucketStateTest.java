package subsystems.buckets;

import org.junit.jupiter.api.Test;
import subsystems.buckets.Positions.Distance;
import subsystems.buckets.Positions.Orientation;
import subsystems.buckets.Positions.RelativeVelocity;

class BucketStateTest {

    @Test
    void printValidList() {
        int counter = 0;
        for (Orientation o1 : Orientation.values()) {
            for (Orientation o2 : Orientation.values()) {
                for (Orientation oo : Orientation.values()) {
                    BucketState bucketState = new BucketState()
                            .setObserver(o1)
                            .setObserved(o2)
                            .setRelative(oo)
                            .setDistance(Distance.INCREASING)
                            .setRelativeVelocity(RelativeVelocity.INCREASING);

                    if (bucketState.isValid()) {
                        counter++;
                        System.out.println(bucketState);
                    } else {
                        System.out.println("heres what was not valid: " + bucketState);
                    }
                }
            }
        }
        System.out.println(counter);
    }

    @Test
    void test_only3() {
        /*
            observer=LEFT,   observed=LEFT,   relative=LEFT   -
            observer=LEFT,   observed=LEFT,   relative=RIGHT  -
            observer=LEFT,   observed=LEFT,   relative=EQUALS -
            observer=LEFT,   observed=RIGHT,  relative=LEFT   -
            observer=LEFT,   observed=RIGHT,  relative=RIGHT  -
            observer=LEFT,   observed=RIGHT,  relative=EQUALS -
            observer=LEFT,   observed=EQUALS, relative=LEFT   -
            observer=LEFT,   observed=EQUALS, relative=RIGHT  -
            observer=LEFT,   observed=EQUALS, relative=EQUALS -
            observer=RIGHT,  observed=LEFT,   relative=LEFT   -
            observer=RIGHT,  observed=LEFT,   relative=RIGHT  -
            observer=RIGHT,  observed=LEFT,   relative=EQUALS -
            observer=RIGHT,  observed=RIGHT,  relative=LEFT   -
            observer=RIGHT,  observed=RIGHT,  relative=RIGHT  -
            observer=RIGHT,  observed=RIGHT,  relative=EQUALS -
            observer=RIGHT,  observed=EQUALS, relative=LEFT   -
            observer=RIGHT,  observed=EQUALS, relative=RIGHT  -
            observer=RIGHT,  observed=EQUALS, relative=EQUALS -
            observer=EQUALS, observed=LEFT,   relative=LEFT   -
            observer=EQUALS, observed=LEFT,   relative=RIGHT  -
            observer=EQUALS, observed=LEFT,   relative=EQUALS -
            observer=EQUALS, observed=RIGHT,  relative=LEFT   -
            observer=EQUALS, observed=RIGHT,  relative=RIGHT  -
            observer=EQUALS, observed=RIGHT,  relative=EQUALS -
            observer=EQUALS, observed=EQUALS, relative=LEFT   -
            observer=EQUALS, observed=EQUALS, relative=RIGHT  -
            observer=EQUALS, observed=EQUALS, relative=EQUALS -
         */
        for (Orientation o1 : Orientation.values()) {
            for (Orientation o2 : Orientation.values()) {
                for (Orientation oo : Orientation.values()) {
                    BucketState bucketState = new BucketState()
                            .setObserver(o1)
                            .setObserved(o2)
                            .setRelative(oo)
                            .setDistance(Distance.INCREASING)
                            .setRelativeVelocity(RelativeVelocity.INCREASING);

                    System.out.println(bucketState);
                }
            }
        }
    }

    @Test
    void test() {
        /*
            BucketState(observer=LEFT, observed=LEFT, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=LEFT, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=RIGHT, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=LEFT, observed=EQUALS, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=LEFT, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=RIGHT, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=RIGHT, observed=EQUALS, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=LEFT, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=RIGHT, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=LEFT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=LEFT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=LEFT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=LEFT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=RIGHT, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=RIGHT, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=RIGHT, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=RIGHT, distance=DECREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=EQUALS, distance=INCREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=EQUALS, distance=INCREASING, acceleration=DECREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=EQUALS, distance=DECREASING, acceleration=INCREASING)
            BucketState(observer=EQUALS, observed=EQUALS, relative=EQUALS, distance=DECREASING, acceleration=DECREASING)
         */
        for (Orientation o1 : Orientation.values()) {
            for (Orientation o2 : Orientation.values()) {
                for (Orientation oo : Orientation.values()) {
                    for (Distance d : Positions.Distance.values()) {
                        for (RelativeVelocity a : RelativeVelocity.values()) {
                            BucketState bucketState = new BucketState()
                                    .setObserver(o1)
                                    .setObserved(o2)
                                    .setRelative(oo)
                                    .setDistance(d)
                                    .setRelativeVelocity(a);

                            System.out.println(bucketState);
                        }
                    }
                }
            }
        }
    }

}
