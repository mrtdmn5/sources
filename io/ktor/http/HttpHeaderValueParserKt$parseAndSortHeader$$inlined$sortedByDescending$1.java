package io.ktor.http;

import androidx.compose.foundation.BorderStrokeKt;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public final class HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues(Double.valueOf(((HeaderValue) t2).quality), Double.valueOf(((HeaderValue) t).quality));
    }
}
