package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
/* loaded from: classes3.dex */
public final class TextKt {
    public static final CaseInsensitiveString caseInsensitive(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new CaseInsensitiveString(str);
    }

    public static final char toLowerCasePreservingASCII(char c) {
        boolean z;
        boolean z2 = true;
        if ('A' <= c && c < '[') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return (char) (c + ' ');
        }
        if (c < 0 || c >= 128) {
            z2 = false;
        }
        if (!z2) {
            return Character.toLowerCase(c);
        }
        return c;
    }
}
