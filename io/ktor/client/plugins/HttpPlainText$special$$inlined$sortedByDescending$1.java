package io.ktor.client.plugins;

import androidx.compose.foundation.BorderStrokeKt;
import java.util.Comparator;
import kotlin.Pair;

/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public final class HttpPlainText$special$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues((Float) ((Pair) t2).second, (Float) ((Pair) t).second);
    }
}
