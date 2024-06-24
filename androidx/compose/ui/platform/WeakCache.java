package androidx.compose.ui.platform;

import androidx.compose.runtime.collection.MutableVector;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/* compiled from: WeakCache.kt */
/* loaded from: classes.dex */
public final class WeakCache<T> {
    public final MutableVector<Reference<T>> values = new MutableVector<>(new Reference[16]);
    public final ReferenceQueue<T> referenceQueue = new ReferenceQueue<>();
}
