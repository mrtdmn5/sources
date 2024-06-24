package com.google.common.collect;

import io.ktor.utils.io.ExceptionUtilsJvmKt;

/* loaded from: classes3.dex */
public final class Lists {
    public static final void access$rethrowClosed(Throwable th) {
        Throwable th2;
        try {
            th2 = ExceptionUtilsJvmKt.tryCopyException(th, th);
        } catch (Throwable unused) {
            th2 = null;
        }
        if (th2 == null) {
            throw th;
        }
        throw th2;
    }
}
