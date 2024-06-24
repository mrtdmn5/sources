package aws.sdk.kotlin.runtime.http;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsUserAgentMetadata.kt */
/* loaded from: classes.dex */
public final class AwsUserAgentMetadataKt {
    public static final Set<Character> VALID_TCHAR = SetsKt__SetsKt.setOf((Object[]) new Character[]{'!', '#', '$', '%', '&', '\'', '*', '+', '-', '.', '^', '_', '`', '|', '~'});

    public static final String access$encodeUaToken(String str) {
        boolean z;
        boolean z2;
        boolean z3;
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int r3 = 0; r3 < length; r3++) {
            char charAt = str.charAt(r3);
            if (charAt == ' ') {
                sb.append("_");
            } else {
                boolean z4 = true;
                if ('a' <= charAt && charAt < '{') {
                    z = true;
                } else {
                    z = false;
                }
                if (z || ('A' <= charAt && charAt < '[')) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || ('0' <= charAt && charAt < ':')) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    z4 = VALID_TCHAR.contains(Character.valueOf(charAt));
                }
                if (z4) {
                    sb.append(charAt);
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
