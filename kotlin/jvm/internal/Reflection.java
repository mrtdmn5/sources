package kotlin.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public final class Reflection {
    public static final KClass[] EMPTY_K_CLASS_ARRAY;
    public static final ReflectionFactory factory;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        factory = reflectionFactory;
        EMPTY_K_CLASS_ARRAY = new KClass[0];
    }

    public static ClassReference getOrCreateKotlinClass(Class cls) {
        factory.getClass();
        return new ClassReference(cls);
    }

    public static TypeReference nullableTypeOf(Class cls) {
        ClassReference orCreateKotlinClass = getOrCreateKotlinClass(cls);
        List emptyList = Collections.emptyList();
        factory.getClass();
        return new TypeReference(orCreateKotlinClass, emptyList, true);
    }

    public static TypeReference typeOf(Class cls) {
        ClassReference orCreateKotlinClass = getOrCreateKotlinClass(cls);
        List emptyList = Collections.emptyList();
        factory.getClass();
        return new TypeReference(orCreateKotlinClass, emptyList, false);
    }
}
