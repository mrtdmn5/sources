package androidx.compose.ui.text;

import androidx.compose.ui.text.font.TypefaceCompatApi26$toAndroidString$1;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TempListUtils.kt */
/* loaded from: classes.dex */
public final class TempListUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static String fastJoinToString$default(ArrayList arrayList, String separator, TypefaceCompatApi26$toAndroidString$1 typefaceCompatApi26$toAndroidString$1, int r11) {
        CharSequence prefix;
        int r3;
        String truncated;
        if ((r11 & 1) != 0) {
            separator = ", ";
        }
        String postfix = "";
        if ((r11 & 2) != 0) {
            prefix = "";
        } else {
            prefix = null;
        }
        if ((r11 & 4) == 0) {
            postfix = null;
        }
        if ((r11 & 8) != 0) {
            r3 = -1;
        } else {
            r3 = 0;
        }
        if ((r11 & 16) != 0) {
            truncated = "...";
        } else {
            truncated = null;
        }
        Function1 function1 = typefaceCompatApi26$toAndroidString$1;
        if ((r11 & 32) != 0) {
            function1 = 0;
        }
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int size = arrayList.size();
        int r1 = 0;
        for (int r4 = 0; r4 < size; r4++) {
            Object obj = arrayList.get(r4);
            r1++;
            boolean z = true;
            if (r1 > 1) {
                sb.append((CharSequence) separator);
            }
            if (r3 >= 0 && r1 > r3) {
                break;
            }
            if (function1 != 0) {
                sb.append((CharSequence) function1.invoke(obj));
            } else {
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
        }
        if (r3 >= 0 && r1 > r3) {
            sb.append((CharSequence) truncated);
        }
        sb.append((CharSequence) postfix);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "fastJoinTo(StringBuilder…form)\n        .toString()");
        return sb2;
    }
}
