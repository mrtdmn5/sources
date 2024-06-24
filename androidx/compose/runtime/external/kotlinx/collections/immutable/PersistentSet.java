package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import java.util.Collection;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ImmutableSet.kt */
/* loaded from: classes.dex */
public interface PersistentSet<E> extends ImmutableSet<E>, Collection, KMappedMarker {
    PersistentOrderedSet add(Recomposer.RecomposerInfoImpl recomposerInfoImpl);

    @Override // java.util.Set, java.util.Collection
    PersistentOrderedSet remove(Object obj);
}
