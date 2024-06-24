package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class ClassValueReferences<T> extends ClassValue<MutableSoftReference<T>> {
    @Override // java.lang.ClassValue
    public final Object computeValue(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new MutableSoftReference();
    }
}
