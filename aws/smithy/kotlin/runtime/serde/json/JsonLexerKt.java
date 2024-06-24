package aws.smithy.kotlin.runtime.serde.json;

import aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: JsonLexer.kt */
/* loaded from: classes.dex */
public final class JsonLexerKt {
    public static final Set<Character> DIGITS = CollectionsKt___CollectionsKt.toSet(new CharRange('0', '9'));
    public static final Set<Character> EXP = SetsKt__SetsKt.setOf((Object[]) new Character[]{'e', 'E'});
    public static final Set<Character> PLUS_MINUS = SetsKt__SetsKt.setOf((Object[]) new Character[]{'-', '+'});

    public static final String access$unescape(String str) {
        boolean z;
        StringBuilder sb = new StringBuilder(str.length() + 1);
        int r3 = 0;
        while (r3 < str.length()) {
            char charAt = str.charAt(r3);
            if (charAt == '\\') {
                int r32 = r3 + 1;
                int r4 = r32 + 1;
                char charAt2 = str.charAt(r32);
                int r7 = 10;
                if (charAt2 == 'u') {
                    int r33 = r4 + 4;
                    if (r33 <= str.length()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        String substring = str.substring(r4, r33);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        char decodeEscapedCodePoint = decodeEscapedCodePoint(substring);
                        if (Character.isHighSurrogate(decodeEscapedCodePoint)) {
                            String substring2 = str.substring(r33, r33 + 6);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            if (StringsKt__StringsJVMKt.startsWith(substring2, "\\u", false)) {
                                String substring3 = substring2.substring(2);
                                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                                char decodeEscapedCodePoint2 = decodeEscapedCodePoint(substring3);
                                if (Character.isLowSurrogate(decodeEscapedCodePoint2)) {
                                    Object[] objArr = {Character.valueOf(decodeEscapedCodePoint), Character.valueOf(decodeEscapedCodePoint2)};
                                    for (int r5 = 0; r5 < 2; r5++) {
                                        sb.append(objArr[r5]);
                                    }
                                } else {
                                    throw new IllegalStateException(("Invalid surrogate pair: (" + ((int) decodeEscapedCodePoint) + ", " + ((int) decodeEscapedCodePoint2) + ')').toString());
                                }
                            } else {
                                throw new IllegalStateException(EndpointMode$Companion$$ExternalSyntheticOutline0.m("Expected surrogate pair, found `", substring2, '`').toString());
                            }
                        } else {
                            sb.append(decodeEscapedCodePoint);
                            r7 = 4;
                        }
                        r3 = r4 + r7;
                    } else {
                        throw new IllegalStateException("Unexpected EOF reading escaped high surrogate".toString());
                    }
                } else {
                    if (charAt2 == '\\') {
                        sb.append('\\');
                    } else if (charAt2 == '/') {
                        sb.append('/');
                    } else if (charAt2 == '\"') {
                        sb.append('\"');
                    } else if (charAt2 == 'b') {
                        sb.append('\b');
                    } else if (charAt2 == 'f') {
                        sb.append('\f');
                    } else if (charAt2 == 'r') {
                        sb.append('\r');
                    } else if (charAt2 == 'n') {
                        sb.append('\n');
                    } else if (charAt2 == 't') {
                        sb.append('\t');
                    } else {
                        throw new DeserializationException("Invalid escape character: `" + charAt2 + '`');
                    }
                    r3 = r4;
                }
            } else {
                sb.append(charAt);
                r3++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final char decodeEscapedCodePoint(String str) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        int r1 = 0;
        while (true) {
            boolean z5 = true;
            if (r1 < str.length()) {
                char charAt = str.charAt(r1);
                if ('0' <= charAt && charAt < ':') {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if ('a' <= charAt && charAt < 'g') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        if ('A' <= charAt && charAt < 'G') {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            z5 = false;
                        }
                    }
                }
                if (!z5) {
                    break;
                }
                r1++;
            } else {
                z4 = true;
                break;
            }
        }
        if (z4) {
            CharsKt__CharKt.checkRadix(16);
            return (char) Integer.parseInt(str, 16);
        }
        throw new IllegalStateException(EndpointMode$Companion$$ExternalSyntheticOutline0.m("Invalid unicode escape: `\\u", str, '`').toString());
    }
}
