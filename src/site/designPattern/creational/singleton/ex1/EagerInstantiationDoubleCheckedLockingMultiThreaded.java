package site.designPattern.creational.singleton.ex1;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class EagerInstantiationDoubleCheckedLockingMultiThreaded implements Serializable, Cloneable{
    // Step 1: private static variable of INSTANCE variable
    private volatile static EagerInstantiationDoubleCheckedLockingMultiThreaded INSTANCE = new EagerInstantiationDoubleCheckedLockingMultiThreaded();

    // Step 2: private constructor
    private EagerInstantiationDoubleCheckedLockingMultiThreaded() {
    }

    // Step 3: Provide public static getInstance() method returning same INSTANCE same time
    public static EagerInstantiationDoubleCheckedLockingMultiThreaded getInstance() {
        // double-checking lock
        if (null == INSTANCE) {
            // synchronized block
            synchronized (EagerInstantiationDoubleCheckedLockingMultiThreaded.class) {
                if (null == INSTANCE) {
                    INSTANCE = new EagerInstantiationDoubleCheckedLockingMultiThreaded();
                }
            }
        }
        return INSTANCE;
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
