package subsystems.buckets;

import static subsystems.buckets.Positions.Orientation.*;

public class PositionValidator {
    public Boolean valid1(BucketState bucketState) {
        boolean observedAndObserverMatches = isObservedAndObserverMatches(bucketState);

        if ((bucketState.getObserver() == LEFT_OF || bucketState.getObserver() == RIGHT_OF) &&
                observedAndObserverMatches) {

            return bucketState.getRelative() != CENTER;
        }

        return null;
    }

    public Boolean valid2(BucketState bucketState) {
        boolean observedAndObserverMatches = isObservedAndObserverMatches(bucketState);

        if (!observedAndObserverMatches) {
            if (bucketState.getObserved() == LEFT_OF) {
                return bucketState.getRelative() == RIGHT_OF;
            }
            if (bucketState.getObserved() == RIGHT_OF) {
                return bucketState.getRelative() == LEFT_OF;
            }
        }

        // todo add center rules, for now assume it will be valid
        return null;
    }

    private boolean isObservedAndObserverMatches(BucketState bucketState) {
        return bucketState.getObserved() == bucketState.getObserver();
    }
}
