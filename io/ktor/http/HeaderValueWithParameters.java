package io.ktor.http;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HeaderValueWithParameters.kt */
/* loaded from: classes3.dex */
public abstract class HeaderValueWithParameters {
    public final String content;
    public final List<HeaderValueParam> parameters;

    public HeaderValueWithParameters(String content, List<HeaderValueParam> parameters) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.content = content;
        this.parameters = parameters;
    }

    public final String parameter(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<HeaderValueParam> list = this.parameters;
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex >= 0) {
            int r2 = 0;
            while (true) {
                HeaderValueParam headerValueParam = list.get(r2);
                if (StringsKt__StringsJVMKt.equals(headerValueParam.name, name)) {
                    return headerValueParam.value;
                }
                if (r2 != lastIndex) {
                    r2++;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    public final String toString() {
        List<HeaderValueParam> list = this.parameters;
        boolean isEmpty = list.isEmpty();
        String str = this.content;
        if (!isEmpty) {
            int length = str.length();
            int r4 = 0;
            int r5 = 0;
            for (HeaderValueParam headerValueParam : list) {
                r5 += headerValueParam.value.length() + headerValueParam.name.length() + 3;
            }
            StringBuilder sb = new StringBuilder(length + r5);
            sb.append(str);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (lastIndex >= 0) {
                while (true) {
                    HeaderValueParam headerValueParam2 = list.get(r4);
                    sb.append("; ");
                    sb.append(headerValueParam2.name);
                    sb.append("=");
                    String str2 = headerValueParam2.value;
                    if (HeaderValueWithParametersKt.needQuotes(str2)) {
                        sb.append(HeaderValueWithParametersKt.quote(str2));
                    } else {
                        sb.append(str2);
                    }
                    if (r4 == lastIndex) {
                        break;
                    }
                    r4++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "{\n            val size =…   }.toString()\n        }");
            return sb2;
        }
        return str;
    }
}
