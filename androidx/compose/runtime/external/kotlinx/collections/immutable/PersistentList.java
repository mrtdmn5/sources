package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList$removeAll$1;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import java.util.Collection;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ImmutableList.kt */
/* loaded from: classes.dex */
public interface PersistentList<E> extends ImmutableList<E>, Collection, KMappedMarker {
    @Override // java.util.List
    PersistentList<E> add(int r1, E e);

    @Override // java.util.List, java.util.Collection
    PersistentList<E> add(E e);

    @Override // java.util.List, java.util.Collection
    PersistentList<E> addAll(Collection<? extends E> collection);

    PersistentVectorBuilder builder();

    @Override // java.util.List, java.util.Collection
    PersistentList<E> remove(E e);

    PersistentList removeAll(AbstractPersistentList$removeAll$1 abstractPersistentList$removeAll$1);

    @Override // java.util.List, java.util.Collection
    PersistentList<E> removeAll(Collection<? extends E> collection);

    PersistentList<E> removeAt(int r1);

    @Override // java.util.List
    PersistentList<E> set(int r1, E e);
}
