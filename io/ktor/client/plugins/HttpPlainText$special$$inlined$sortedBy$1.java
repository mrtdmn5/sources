package io.ktor.client.plugins;

import androidx.compose.foundation.BorderStrokeKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public final class HttpPlainText$special$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues(CharsetJVMKt.getName((Charset) t), CharsetJVMKt.getName((Charset) t2));
    }
}
