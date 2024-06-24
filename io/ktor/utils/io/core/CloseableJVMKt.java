package io.ktor.utils.io.core;

import java.lang.reflect.Method;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;

/* compiled from: CloseableJVM.kt */
/* loaded from: classes3.dex */
public final class CloseableJVMKt {
    public static final SynchronizedLazyImpl AddSuppressedMethod$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: io.ktor.utils.io.core.CloseableJVMKt$AddSuppressedMethod$2
        @Override // kotlin.jvm.functions.Function0
        public final Method invoke() {
            try {
                return Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                return null;
            }
        }
    });

    public static final void addSuppressedInternal(Throwable th, Throwable th2) {
        Method method = (Method) AddSuppressedMethod$delegate.getValue();
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
