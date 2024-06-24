package io.ktor.util;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: Text.kt */
/* loaded from: classes3.dex */
public final class CaseInsensitiveString {
    public final String content;
    public final int hash;

    public CaseInsensitiveString(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        String lowerCase = content.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.hash = lowerCase.hashCode();
    }

    public final boolean equals(Object obj) {
        CaseInsensitiveString caseInsensitiveString;
        String str;
        if (obj instanceof CaseInsensitiveString) {
            caseInsensitiveString = (CaseInsensitiveString) obj;
        } else {
            caseInsensitiveString = null;
        }
        if (caseInsensitiveString != null && (str = caseInsensitiveString.content) != null && StringsKt__StringsJVMKt.equals(str, this.content)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.hash;
    }

    public final String toString() {
        return this.content;
    }
}
