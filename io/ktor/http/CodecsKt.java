package io.ktor.http;

import io.ktor.utils.io.charsets.EncodingKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.Charsets;

/* compiled from: Codecs.kt */
/* loaded from: classes3.dex */
public final class CodecsKt {
    public static final Set<Character> HEX_ALPHABET;
    public static final ArrayList SPECIAL_SYMBOLS;
    public static final Set<Byte> URL_ALPHABET;
    public static final Set<Character> URL_ALPHABET_CHARS;
    public static final ArrayList URL_PROTOCOL_PART;
    public static final Set<Character> VALID_PATH_PART;

    static {
        ArrayList plus = CollectionsKt___CollectionsKt.plus(new CharRange('0', '9'), CollectionsKt___CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', 'Z')));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(plus, 10));
        Iterator it = plus.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        URL_ALPHABET = CollectionsKt___CollectionsKt.toSet(arrayList);
        URL_ALPHABET_CHARS = CollectionsKt___CollectionsKt.toSet(CollectionsKt___CollectionsKt.plus(new CharRange('0', '9'), CollectionsKt___CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', 'Z'))));
        HEX_ALPHABET = CollectionsKt___CollectionsKt.toSet(CollectionsKt___CollectionsKt.plus(new CharRange('0', '9'), CollectionsKt___CollectionsKt.plus(new CharRange('a', 'f'), new CharRange('A', 'F'))));
        Set of = SetsKt__SetsKt.setOf((Object[]) new Character[]{':', '/', '?', '#', '[', ']', '@', '!', '$', '&', '\'', '(', ')', '*', ',', ';', '=', '-', '.', '_', '~', '+'});
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(of, 10));
        Iterator it2 = of.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        URL_PROTOCOL_PART = arrayList2;
        VALID_PATH_PART = SetsKt__SetsKt.setOf((Object[]) new Character[]{':', '@', '!', '$', '&', '\'', '(', ')', '*', '+', ',', ';', '=', '-', '.', '_', '~'});
        SetsKt.plus(URL_ALPHABET_CHARS, SetsKt__SetsKt.setOf((Object[]) new Character[]{'!', '#', '$', '&', '+', '-', '.', '^', '_', '`', '|', '~'}));
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'-', '.', '_', '~'});
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(listOf, 10));
        Iterator it3 = listOf.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it3.next()).charValue()));
        }
        SPECIAL_SYMBOLS = arrayList3;
    }

    public static final String access$percentEncode(byte b) {
        boolean z;
        int r1;
        int r6;
        int r62 = b & 255;
        char[] cArr = new char[3];
        boolean z2 = false;
        cArr[0] = '%';
        int r12 = r62 >> 4;
        if (r12 >= 0 && r12 < 10) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            r1 = r12 + 48;
        } else {
            r1 = ((char) (r12 + 65)) - '\n';
        }
        cArr[1] = (char) r1;
        int r63 = r62 & 15;
        if (r63 >= 0 && r63 < 10) {
            z2 = true;
        }
        if (z2) {
            r6 = r63 + 48;
        } else {
            r6 = ((char) (r63 + 65)) - '\n';
        }
        cArr[2] = (char) r6;
        return new String(cArr);
    }

    public static final int charToHexDigit(char c) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if ('0' <= c && c < ':') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return c - '0';
        }
        char c2 = 'A';
        if ('A' <= c && c < 'G') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            c2 = 'a';
            if ('a' > c || c >= 'g') {
                z3 = false;
            }
            if (!z3) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static final String decodeScan(String str, int r16, int r17, boolean z, Charset charset) {
        int r3 = r16;
        while (r3 < r17) {
            char charAt = str.charAt(r3);
            if (charAt != '%' && (!z || charAt != '+')) {
                r3++;
            } else {
                int r4 = r17 - r16;
                if (r4 > 255) {
                    r4 /= 3;
                }
                StringBuilder sb = new StringBuilder(r4);
                if (r3 > r16) {
                    sb.append((CharSequence) str, r16, r3);
                }
                byte[] bArr = null;
                while (r3 < r17) {
                    char charAt2 = str.charAt(r3);
                    if (z && charAt2 == '+') {
                        sb.append(' ');
                    } else if (charAt2 == '%') {
                        if (bArr == null) {
                            bArr = new byte[(r17 - r3) / 3];
                        }
                        int r8 = 0;
                        while (r3 < r17 && str.charAt(r3) == '%') {
                            int r9 = r3 + 2;
                            if (r9 < r17) {
                                int r11 = r3 + 1;
                                int charToHexDigit = charToHexDigit(str.charAt(r11));
                                int charToHexDigit2 = charToHexDigit(str.charAt(r9));
                                if (charToHexDigit != -1 && charToHexDigit2 != -1) {
                                    bArr[r8] = (byte) ((charToHexDigit * 16) + charToHexDigit2);
                                    r3 += 3;
                                    r8++;
                                } else {
                                    throw new URLDecodeException("Wrong HEX escape: %" + str.charAt(r11) + str.charAt(r9) + ", in " + ((Object) str) + ", at " + r3);
                                }
                            } else {
                                throw new URLDecodeException("Incomplete trailing HEX escape: " + str.subSequence(r3, str.length()).toString() + ", in " + ((Object) str) + " at " + r3);
                            }
                        }
                        sb.append(new String(bArr, 0, r8, charset));
                    } else {
                        sb.append(charAt2);
                    }
                    r3++;
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                return sb2;
            }
        }
        if (r16 == 0 && r17 == str.length()) {
            return str;
        }
        String substring = str.substring(r16, r17);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String decodeURLPart$default(String str) {
        int length = str.length();
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return decodeScan(str, 0, length, false, charset);
    }

    public static String decodeURLQueryComponent$default(String str, int r3, int r4, boolean z, int r6) {
        Charset charset;
        if ((r6 & 1) != 0) {
            r3 = 0;
        }
        if ((r6 & 2) != 0) {
            r4 = str.length();
        }
        if ((r6 & 4) != 0) {
            z = false;
        }
        if ((r6 & 8) != 0) {
            charset = Charsets.UTF_8;
        } else {
            charset = null;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return decodeScan(str, r3, r4, z, charset);
    }

    public static final String encodeURLParameter(String str, final boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "UTF_8.newEncoder()");
        forEach(EncodingKt.encode(newEncoder, str, 0, str.length()), new Function1<Byte, Unit>() { // from class: io.ktor.http.CodecsKt$encodeURLParameter$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Byte b) {
                byte byteValue = b.byteValue();
                boolean contains = CodecsKt.URL_ALPHABET.contains(Byte.valueOf(byteValue));
                StringBuilder sb2 = sb;
                if (!contains && !CodecsKt.SPECIAL_SYMBOLS.contains(Byte.valueOf(byteValue))) {
                    if (z && byteValue == 32) {
                        sb2.append('+');
                    } else {
                        sb2.append(CodecsKt.access$percentEncode(byteValue));
                    }
                } else {
                    sb2.append((char) byteValue);
                }
                return Unit.INSTANCE;
            }
        });
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String encodeURLPath(String str, boolean z) {
        int r3;
        int r4;
        final StringBuilder sb = new StringBuilder();
        Charset charset = Charsets.UTF_8;
        int r2 = 0;
        while (r2 < str.length()) {
            char charAt = str.charAt(r2);
            if ((z || charAt != '/') && !URL_ALPHABET_CHARS.contains(Character.valueOf(charAt)) && !VALID_PATH_PART.contains(Character.valueOf(charAt))) {
                if (charAt == '%' && (r4 = r2 + 2) < str.length()) {
                    int r5 = r2 + 1;
                    Character valueOf = Character.valueOf(str.charAt(r5));
                    Set<Character> set = HEX_ALPHABET;
                    if (set.contains(valueOf) && set.contains(Character.valueOf(str.charAt(r4)))) {
                        sb.append(charAt);
                        sb.append(str.charAt(r5));
                        sb.append(str.charAt(r4));
                        r2 += 3;
                    }
                }
                if (new CharRange((char) 55296, (char) 57343).contains(charAt)) {
                    r3 = 2;
                } else {
                    r3 = 1;
                }
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
                int r32 = r3 + r2;
                forEach(EncodingKt.encode(newEncoder, str, r2, r32), new Function1<Byte, Unit>() { // from class: io.ktor.http.CodecsKt$encodeURLPath$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Byte b) {
                        sb.append(CodecsKt.access$percentEncode(b.byteValue()));
                        return Unit.INSTANCE;
                    }
                });
                r2 = r32;
            } else {
                sb.append(charAt);
                r2++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0031, code lost:            throw new java.io.EOFException("No readable bytes available.");     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void forEach(io.ktor.utils.io.core.ByteReadPacket r6, kotlin.jvm.functions.Function1<? super java.lang.Byte, kotlin.Unit> r7) {
        /*
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r6, r0)
            if (r1 != 0) goto L8
            goto L38
        L8:
            int r2 = r1.writePosition     // Catch: java.lang.Throwable -> L28
            int r3 = r1.readPosition     // Catch: java.lang.Throwable -> L28
            r4 = 0
            if (r2 <= r3) goto L11
            r5 = r0
            goto L12
        L11:
            r5 = r4
        L12:
            if (r5 == 0) goto L32
            if (r3 == r2) goto L2a
            int r2 = r3 + 1
            r1.readPosition = r2     // Catch: java.lang.Throwable -> L28
            java.nio.ByteBuffer r2 = r1.memory     // Catch: java.lang.Throwable -> L28
            byte r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L28
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)     // Catch: java.lang.Throwable -> L28
            r7.invoke(r2)     // Catch: java.lang.Throwable -> L28
            goto L8
        L28:
            r7 = move-exception
            goto L3b
        L2a:
            java.io.EOFException r7 = new java.io.EOFException     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = "No readable bytes available."
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L28
            throw r7     // Catch: java.lang.Throwable -> L28
        L32:
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r6, r1)     // Catch: java.lang.Throwable -> L39
            if (r1 != 0) goto L8
        L38:
            return
        L39:
            r7 = move-exception
            r0 = r4
        L3b:
            if (r0 == 0) goto L40
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r6, r1)
        L40:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CodecsKt.forEach(io.ktor.utils.io.core.ByteReadPacket, kotlin.jvm.functions.Function1):void");
    }
}
