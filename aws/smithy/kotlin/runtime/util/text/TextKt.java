package aws.smithy.kotlin.runtime.util.text;

import com.animaconnected.secondo.notification.model.Contact;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Text.kt */
/* loaded from: classes.dex */
public final class TextKt {
    public static final Set<Character> VALID_PCHAR_DELIMS = SetsKt__SetsKt.setOf((Object[]) new Character[]{'/', ':', '@', '!', '$', '&', '\'', '(', ')', '*', '+', ',', ';', '=', '-', '.', '_', '~'});
    public static final Set<Character> upperHexSet;

    static {
        Set<Character> set;
        int length = "0123456789ABCDEF".length();
        if (length != 0) {
            if (length != 1) {
                int length2 = "0123456789ABCDEF".length();
                if (length2 > 128) {
                    length2 = 128;
                }
                set = new LinkedHashSet<>(MapsKt__MapsJVMKt.mapCapacity(length2));
                for (int r2 = 0; r2 < "0123456789ABCDEF".length(); r2++) {
                    set.add(Character.valueOf("0123456789ABCDEF".charAt(r2)));
                }
            } else {
                set = SetsKt__SetsKt.setOf(Character.valueOf("0123456789ABCDEF".charAt(0)));
            }
        } else {
            set = EmptySet.INSTANCE;
        }
        upperHexSet = set;
    }

    public static final void percentEncodeTo(byte b, StringBuilder sb) {
        int r2 = b & 255;
        sb.append('%');
        sb.append("0123456789ABCDEF".charAt(r2 >> 4));
        sb.append("0123456789ABCDEF".charAt(r2 & 15));
    }

    public static final LinkedHashMap splitAsQueryString(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = StringsKt__StringsKt.split$default(str, new String[]{Contact.PHONE_NUMBERS_DELIMITER}, 0, 6).iterator();
        while (it.hasNext()) {
            List split$default = StringsKt__StringsKt.split$default((String) it.next(), new String[]{"="}, 2, 2);
            String str3 = (String) split$default.get(0);
            int size = split$default.size();
            if (size != 1) {
                if (size == 2) {
                    str2 = (String) split$default.get(1);
                } else {
                    throw new IllegalArgumentException("invalid query string: " + split$default);
                }
            } else {
                str2 = "";
            }
            if (linkedHashMap.containsKey(str3)) {
                Object obj = linkedHashMap.get(str3);
                Intrinsics.checkNotNull(obj);
                ((List) obj).add(str2);
            } else {
                linkedHashMap.put(str3, CollectionsKt__CollectionsKt.mutableListOf(str2));
            }
        }
        return linkedHashMap;
    }

    public static String urlDecodeComponent$default(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        byte[] bArr = null;
        int r3 = 0;
        while (r3 < str.length()) {
            char charAt = str.charAt(r3);
            if (charAt == '%') {
                if (bArr == null) {
                    bArr = new byte[(str.length() - r3) / 3];
                }
                int r6 = 0;
                while (r3 + 2 < str.length() && charAt == '%') {
                    int r8 = r3 + 3;
                    String substring = str.substring(r3 + 1, r8);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(16, substring);
                    if (intOrNull == null) {
                        break;
                    }
                    byte intValue = (byte) intOrNull.intValue();
                    int r7 = r6 + 1;
                    bArr[r6] = intValue;
                    if (r8 < str.length()) {
                        charAt = str.charAt(r8);
                    }
                    r6 = r7;
                    r3 = r8;
                }
                sb.append(StringsKt__StringsJVMKt.decodeToString$default(bArr, 0, r6, 5));
                if (r3 != str.length() && charAt == '%') {
                    sb.append(charAt);
                }
            } else {
                sb.append(charAt);
            }
            r3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static String urlEncodeComponent$default(String str) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        for (byte b : StringsKt__StringsJVMKt.encodeToByteArray(str)) {
            char c = (char) b;
            if (c == ' ') {
                sb.append("%20");
            } else {
                boolean z7 = true;
                if ('a' <= c && c < '{') {
                    z = true;
                } else {
                    z = false;
                }
                if (z || ('A' <= c && c < '[')) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || ('0' <= c && c < ':')) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || c == '-') {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4 || c == '_') {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5 || c == '.') {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!z6 && c != '~') {
                    z7 = false;
                }
                if (z7) {
                    sb.append(c);
                } else {
                    percentEncodeTo(b, sb);
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
