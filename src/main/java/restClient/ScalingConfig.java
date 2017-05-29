package restClient;

/**
 * Created by root on 4/7/17.
 */
public class ScalingConfig {

    public enum TypeEnum {
        FIXED_NUM_SEGMENTS,

        BY_RATE_IN_KBYTES_PER_SEC,

        BY_RATE_IN_EVENTS_PER_SEC;
    }

    private TypeEnum type = null;

    private Integer targetRate = null;

    private Integer scaleFactor = null;

    private Integer minSegments = null;

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Integer getTargetRate() {
        return targetRate;
    }

    public void setTargetRate(Integer targetRate) {
        this.targetRate = targetRate;
    }

    public Integer getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(Integer scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public Integer getMinSegments() {
        return minSegments;
    }

    public void setMinSegments(Integer minSegments) {
        this.minSegments = minSegments;
    }
}
