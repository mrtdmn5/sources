package kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Annotations.kt */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface Serializable {
    Class<? extends KSerializer<?>> with() default KSerializer.class;
}
