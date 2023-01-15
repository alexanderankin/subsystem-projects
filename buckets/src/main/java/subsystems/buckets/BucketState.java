package subsystems.buckets;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import subsystems.buckets.Positions.*;

@Slf4j
@Accessors(chain = true)
@Data
class BucketState {
    private static PositionValidator PV = new PositionValidator();

    /**
     * ObserverRelativeToCenter
     */
    Orientation observer;
    /**
     * ObservedRelativeToCenter
     */
    Orientation observed;
    /**
     * ObservedRelativeToObserver
     */
    Orientation relative;

    Distance distance;
    RelativeVelocity relativeVelocity;

    boolean isValid() {
        if (Boolean.FALSE.equals(PV.valid1(this))) {
            log.trace("not valid due to position validation 1: {}", this);
            return false;
        }

        if (Boolean.FALSE.equals(PV.valid2(this))) {
            log.trace("not valid due to position validation 2: {}", this);
            return false;
        }

        return true;
    }
}
