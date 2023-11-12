package com.klimov.somepackage;

import com.klimov.annotations.AutoInjectable;

/**
 * @author s.a.klimov
 */
public class SomeBean {
    /**
     * Default constructor.
     */
    public SomeBean() {}

    /**
     * Auto-injectable field representing SomeInterface.
     */
    @AutoInjectable
    private SomeInterface field1;

    /**
     * Auto-injectable field representing SomeOtherInterface.
     */
    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Performs the action associated with the injected fields.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomething();
    }
}
