package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActualJvm.jvm.kt */
/* loaded from: classes.dex */
public final class WeakReference<T> extends java.lang.ref.WeakReference<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakReference(T reference) {
        super(reference);
        Intrinsics.checkNotNullParameter(reference, "reference");
    }
}
