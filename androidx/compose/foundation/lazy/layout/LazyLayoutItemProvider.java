package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutItemProvider.kt */
/* loaded from: classes.dex */
public interface LazyLayoutItemProvider {
    void Item(int r1, Object obj, Composer composer, int r4);

    default Object getContentType(int r1) {
        return null;
    }

    default int getIndex(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return -1;
    }

    int getItemCount();

    default Object getKey(int r2) {
        return new DefaultLazyKey(r2);
    }
}
