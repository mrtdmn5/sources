package aws.smithy.kotlin.runtime.util;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: CaseInsensitiveMap.kt */
/* loaded from: classes.dex */
public final class CaseInsensitiveString {
    public final int hash;
    public final String s;

    public CaseInsensitiveString(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.s = s;
        String lowerCase = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.hash = lowerCase.hashCode();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof CaseInsensitiveString) && StringsKt__StringsJVMKt.equals(((CaseInsensitiveString) obj).s, this.s)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.hash;
    }

    public final String toString() {
        return this.s;
    }
}
