package io.ktor.utils.io;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ExceptionUtilsJvm.kt */
/* loaded from: classes3.dex */
public final class ExceptionUtilsJvmKt {
    public static final int throwableFields = fieldsCountOrDefault(-1, Throwable.class);
    public static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    public static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();

    public static final int fieldsCountOrDefault(int r7, Class cls) {
        Object createFailure;
        Reflection.getOrCreateKotlinClass(cls);
        int r1 = 0;
        do {
            try {
                Field[] declaredFields = cls.getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
                int r5 = 0;
                for (Field field : declaredFields) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        r5++;
                    }
                }
                r1 += r5;
                cls = cls.getSuperclass();
            } catch (Throwable th) {
                createFailure = ResultKt.createFailure(th);
            }
        } while (cls != null);
        createFailure = Integer.valueOf(r1);
        Object valueOf = Integer.valueOf(r7);
        if (createFailure instanceof Result.Failure) {
            createFailure = valueOf;
        }
        return ((Number) createFailure).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0127 A[EDGE_INSN: B:60:0x0127->B:61:0x0127 BREAK  A[LOOP:3: B:44:0x00cb->B:91:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[LOOP:3: B:44:0x00cb->B:91:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E extends java.lang.Throwable> E tryCopyException(E r12, java.lang.Throwable r13) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ExceptionUtilsJvmKt.tryCopyException(java.lang.Throwable, java.lang.Throwable):java.lang.Throwable");
    }
}
