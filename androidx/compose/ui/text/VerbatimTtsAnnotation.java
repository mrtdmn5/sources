package androidx.compose.ui.text;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TtsAnnotation.kt */
/* loaded from: classes.dex */
public final class VerbatimTtsAnnotation extends TtsAnnotation {
    public final String verbatim;

    public VerbatimTtsAnnotation(String verbatim) {
        Intrinsics.checkNotNullParameter(verbatim, "verbatim");
        this.verbatim = verbatim;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerbatimTtsAnnotation)) {
            return false;
        }
        if (Intrinsics.areEqual(this.verbatim, ((VerbatimTtsAnnotation) obj).verbatim)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.verbatim.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("VerbatimTtsAnnotation(verbatim="), this.verbatim, ')');
    }
}
