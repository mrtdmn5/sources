package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;

/* compiled from: CompositionLocalMap.kt */
/* loaded from: classes.dex */
public interface PersistentCompositionLocalMap extends PersistentMap<CompositionLocal<Object>, State<? extends Object>>, CompositionLocalMap {
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder();
}
