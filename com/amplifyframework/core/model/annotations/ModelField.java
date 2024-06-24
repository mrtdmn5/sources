package com.amplifyframework.core.model.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface ModelField {
    AuthRule[] authRules() default {};

    boolean isReadOnly() default false;

    boolean isRequired() default false;

    String targetType() default "";
}
