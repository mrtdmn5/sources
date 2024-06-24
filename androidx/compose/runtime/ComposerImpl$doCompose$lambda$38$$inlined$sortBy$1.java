package androidx.compose.runtime;

import androidx.compose.foundation.BorderStrokeKt;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes.dex */
public final class ComposerImpl$doCompose$lambda$38$$inlined$sortBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues(Integer.valueOf(((Invalidation) t).location), Integer.valueOf(((Invalidation) t2).location));
    }
}
