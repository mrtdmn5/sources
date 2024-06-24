package io.ktor.utils.io;

import androidx.compose.foundation.BorderStrokeKt;
import java.lang.reflect.Constructor;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public final class ExceptionUtilsJvmKt$tryCopyException$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
    }
}
