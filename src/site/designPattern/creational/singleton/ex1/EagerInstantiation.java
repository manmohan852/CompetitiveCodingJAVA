package site.designPattern.creational.singleton.ex1;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class EagerInstantiation implements Serializable, Cloneable {

    // Step 1: private static variable of INSTANCE variable
    private volatile static EagerInstantiation INSTANCE = new EagerInstantiation();

    // Step 2: private constructor
    private EagerInstantiation() {
    }

    // Step 3: Provide public static getInstance() method returning same INSTANCE same time
    public static EagerInstantiation getInstance() {
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
