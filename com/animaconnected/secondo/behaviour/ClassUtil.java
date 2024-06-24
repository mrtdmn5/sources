package com.animaconnected.secondo.behaviour;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassUtil.kt */
/* loaded from: classes3.dex */
public final class ClassUtil {
    public static final int $stable = 0;
    public static final ClassUtil INSTANCE = new ClassUtil();

    private ClassUtil() {
    }

    public final Object newInstance(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
