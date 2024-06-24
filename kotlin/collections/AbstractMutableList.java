package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: AbstractMutableList.kt */
/* loaded from: classes.dex */
public abstract class AbstractMutableList<E> extends java.util.AbstractList<E> implements List<E>, KMutableList {
    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int r1) {
        return removeAt(r1);
    }

    public abstract E removeAt(int r1);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
