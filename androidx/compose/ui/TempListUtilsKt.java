package androidx.compose.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TempListUtils.kt */
/* loaded from: classes.dex */
public final class TempListUtilsKt {
    public static String fastJoinToString$default(List list, String str) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int size = list.size();
        int r4 = 0;
        for (int r3 = 0; r3 < size; r3++) {
            Object obj = list.get(r3);
            boolean z = true;
            r4++;
            if (r4 > 1) {
                sb.append((CharSequence) str);
            }
            if (obj != null) {
                z = obj instanceof CharSequence;
            }
            if (z) {
                sb.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb.append(((Character) obj).charValue());
            } else {
                sb.append((CharSequence) String.valueOf(obj));
            }
        }
        sb.append((CharSequence) "");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "fastJoinTo(StringBuilder…form)\n        .toString()");
        return sb2;
    }
}
