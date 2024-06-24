package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class SkippableUpdater<T> {
    public final Composer composer;

    public final boolean equals(Object obj) {
        if (!(obj instanceof SkippableUpdater)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.composer, ((SkippableUpdater) obj).composer)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.composer.hashCode();
    }

    public final String toString() {
        return "SkippableUpdater(composer=" + this.composer + ')';
    }
}
