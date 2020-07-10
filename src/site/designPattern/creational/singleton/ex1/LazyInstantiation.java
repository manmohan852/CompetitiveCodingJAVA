package site.designPattern.creational.singleton.ex1;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class LazyInstantiation implements Serializable, Cloneable {
    // Step 1: private static variable of INSTANCE variable
    private volatile static LazyInstantiation INSTANCE;

    // Step 2: private constructor
    private LazyInstantiation() {
    }

    // Step 3: Provide public static getInstance() method
    // returning INSTANCE after checking
    public static LazyInstantiation getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazyInstantiation();
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
