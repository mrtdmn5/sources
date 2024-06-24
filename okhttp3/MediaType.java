package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.internal._MediaTypeCommonKt;

/* compiled from: MediaType.kt */
/* loaded from: classes4.dex */
public final class MediaType {
    public final String mediaType;
    public final String type;

    public MediaType(String mediaType, String str, String str2, String[] strArr) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        this.mediaType = mediaType;
        this.type = str;
    }

    public final boolean equals(Object obj) {
        Regex regex = _MediaTypeCommonKt.TYPE_SUBTYPE;
        if ((obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).mediaType, this.mediaType)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Regex regex = _MediaTypeCommonKt.TYPE_SUBTYPE;
        return this.mediaType.hashCode();
    }

    public final String toString() {
        Regex regex = _MediaTypeCommonKt.TYPE_SUBTYPE;
        return this.mediaType;
    }
}
