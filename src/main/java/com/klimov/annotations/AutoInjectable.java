package com.klimov.annotations;

import java.lang.annotation.*;

/**
 * Annotation to mark fields for automatic injection.
 * @author s.a.klimov
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoInjectable {}
