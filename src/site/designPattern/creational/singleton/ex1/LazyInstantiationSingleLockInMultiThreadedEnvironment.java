package site.designPattern.creational.singleton.ex1;

import java.io.ObjectStreamException;
import java.io.Serializable;

//Lazy initializtion in a multi-threaded environment
public class LazyInstantiationSingleLockInMultiThreadedEnvironment implements Serializable, Cloneable {

    // Step 1: private static variable of INSTANCE variable
    private static volatile LazyInstantiationSingleLockInMultiThreadedEnvironment INSTANCE;

    // Step 2: private constructor
    private LazyInstantiationSingleLockInMultiThreadedEnvironment() {
    }

    // Step 3: Provide public static getInstance() method returning INSTANCE after checking
    public static LazyInstantiationSingleLockInMultiThreadedEnvironment getInstance() {
        // synchronized block
        synchronized (LazyInstantiationSingleLockInMultiThreadedEnvironment.class){
            if(null == INSTANCE){
                INSTANCE = new LazyInstantiationSingleLockInMultiThreadedEnvironment();
            }
            return INSTANCE;
        }
    }

    // to suppress creating new object during de-serialization
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // directly throw Clone Not Supported Exception
        throw new CloneNotSupportedException();
    }
}
