package restClient;

/**
 * Created by root on 4/7/17.
 */
public class StreamProperty {


    private String scopeName = null;

    private String streamName = null;

    private ScalingConfig scalingPolicy = null;

    private RetentionConfig retentionPolicy = null;

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public ScalingConfig getScalingPolicy() {
        return scalingPolicy;
    }

    public void setScalingPolicy(ScalingConfig scalingPolicy) {
        this.scalingPolicy = scalingPolicy;
    }

    public RetentionConfig getRetentionPolicy() {
        return retentionPolicy;
    }

    public void setRetentionPolicy(RetentionConfig retentionPolicy) {
        this.retentionPolicy = retentionPolicy;
    }
}


