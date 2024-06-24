package io.ktor.http;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes3.dex */
public final class IllegalHeaderNameException extends IllegalArgumentException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public IllegalHeaderNameException(java.lang.String r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headerName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Header name '"
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = "' contains illegal character '"
            r0.append(r1)
            char r1 = r3.charAt(r4)
            r0.append(r1)
            java.lang.String r1 = "' (code "
            r0.append(r1)
            char r3 = r3.charAt(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 41
            java.lang.String r3 = androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0.m(r0, r3, r4)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.IllegalHeaderNameException.<init>(java.lang.String, int):void");
    }
}
