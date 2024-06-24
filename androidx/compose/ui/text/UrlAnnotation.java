package androidx.compose.ui.text;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlAnnotation.kt */
/* loaded from: classes.dex */
public final class UrlAnnotation {
    public final String url;

    public UrlAnnotation(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UrlAnnotation)) {
            return false;
        }
        if (Intrinsics.areEqual(this.url, ((UrlAnnotation) obj).url)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("UrlAnnotation(url="), this.url, ')');
    }
}
