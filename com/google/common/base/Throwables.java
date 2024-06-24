package com.google.common.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class Throwables {
    public static final Object jla;

    static {
        Object obj;
        Method method;
        Object obj2 = null;
        try {
            obj = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            obj = null;
        }
        jla = obj;
        if (obj != null) {
            try {
                Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
            } catch (ThreadDeath e2) {
                throw e2;
            } catch (Throwable unused2) {
            }
        }
        if (obj != null) {
            try {
                try {
                    method = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceDepth", Throwable.class);
                } catch (ThreadDeath e3) {
                    throw e3;
                } catch (Throwable unused3) {
                    method = null;
                }
                if (method != null) {
                    try {
                        obj2 = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
                    } catch (ThreadDeath e4) {
                        throw e4;
                    } catch (Throwable unused4) {
                    }
                    method.invoke(obj2, new Throwable());
                }
            } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused5) {
            }
        }
    }

    public static void propagateIfPossible(Throwable th) throws Throwable {
        if (!IOException.class.isInstance(th)) {
            if (!(th instanceof RuntimeException)) {
                if (!(th instanceof Error)) {
                    return;
                } else {
                    throw ((Error) th);
                }
            }
            throw ((RuntimeException) th);
        }
        throw ((Throwable) IOException.class.cast(th));
    }
}
