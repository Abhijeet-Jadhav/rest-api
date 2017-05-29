package restClient;

/**
 * Created by root on 4/7/17.
 */
public class RetentionConfig {

    public enum TypeEnum {
        INFINITE,

        LIMITED_DAYS,

        LIMITED_SIZE_MB;
    }

    private TypeEnum type = null;

    private Long value = null;

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
