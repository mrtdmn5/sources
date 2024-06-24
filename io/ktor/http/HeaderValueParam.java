package io.ktor.http;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes3.dex */
public final class HeaderValueParam {
    public final boolean escapeValue;
    public final String name;
    public final String value;

    public HeaderValueParam(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
        this.escapeValue = false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof HeaderValueParam) {
            HeaderValueParam headerValueParam = (HeaderValueParam) obj;
            if (StringsKt__StringsJVMKt.equals(headerValueParam.name, this.name) && StringsKt__StringsJVMKt.equals(headerValueParam.value, this.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        String lowerCase2 = this.value.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase2.hashCode() + (hashCode * 31) + hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HeaderValueParam(name=");
        sb.append(this.name);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", escapeValue=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.escapeValue, ')');
    }
}
