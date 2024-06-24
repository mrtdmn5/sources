package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;

/* compiled from: CompositionLocalMap.kt */
/* loaded from: classes.dex */
public interface CompositionLocalMap {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: CompositionLocalMap.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final PersistentCompositionLocalHashMap Empty = PersistentCompositionLocalHashMap.Empty;
    }

    Object get(ProvidableCompositionLocal providableCompositionLocal);
}
