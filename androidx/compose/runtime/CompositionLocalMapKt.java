package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionLocalMap.kt */
/* loaded from: classes.dex */
public final class CompositionLocalMapKt {
    public static final Object read(PersistentCompositionLocalMap persistentCompositionLocalMap, ProvidableCompositionLocal key) {
        Intrinsics.checkNotNullParameter(persistentCompositionLocalMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (persistentCompositionLocalMap.containsKey(key)) {
            State state = (State) persistentCompositionLocalMap.get((Object) key);
            if (state != null) {
                return state.getValue();
            }
            return null;
        }
        return key.defaultValueHolder.getValue();
    }
}
