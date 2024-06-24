package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutKeyIndexMap.kt */
/* loaded from: classes.dex */
public interface LazyLayoutKeyIndexMap {

    /* compiled from: LazyLayoutKeyIndexMap.kt */
    /* loaded from: classes.dex */
    public static final class Empty implements LazyLayoutKeyIndexMap {
        public static final /* synthetic */ Empty $$INSTANCE = new Empty();

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
        public final int getIndex(Object key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return -1;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
        public final /* bridge */ /* synthetic */ Object getKey(int r1) {
            return null;
        }
    }

    int getIndex(Object obj);

    Object getKey(int r1);
}
