import org.glassfish.hk2.api.Factory;

/**
 * Created by root on 1/21/17.
 */
public class InstanceFactory<T> implements Factory<T> {

    private T instance;

    public InstanceFactory(T instance) {
        this.instance = instance;
    }

    @Override
    public void dispose(T t) {
    }

    @Override
    public T provide() {
        return instance;
    }

}