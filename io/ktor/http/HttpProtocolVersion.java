package io.ktor.http;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpProtocolVersion.kt */
/* loaded from: classes3.dex */
public final class HttpProtocolVersion {
    public static final HttpProtocolVersion HTTP_1_1 = new HttpProtocolVersion("HTTP", 1, 1);
    public final int major;
    public final int minor;
    public final String name;

    public HttpProtocolVersion(String str, int r2, int r3) {
        this.name = str;
        this.major = r2;
        this.minor = r3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpProtocolVersion)) {
            return false;
        }
        HttpProtocolVersion httpProtocolVersion = (HttpProtocolVersion) obj;
        if (Intrinsics.areEqual(this.name, httpProtocolVersion.name) && this.major == httpProtocolVersion.major && this.minor == httpProtocolVersion.minor) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.minor) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.major, this.name.hashCode() * 31, 31);
    }

    public final String toString() {
        return this.name + '/' + this.major + '.' + this.minor;
    }
}
