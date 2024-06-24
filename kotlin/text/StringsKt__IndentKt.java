package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Indent.kt */
/* loaded from: classes.dex */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static final String trimIndent(String str) {
        int r5;
        int r2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        List<String> lines = StringsKt__StringsKt.lines(str);
        List<String> list = lines;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt__StringsJVMKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            r5 = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length = str2.length();
            while (true) {
                if (r5 < length) {
                    if (!CharsKt__CharKt.isWhitespace(str2.charAt(r5))) {
                        break;
                    }
                    r5++;
                } else {
                    r5 = -1;
                    break;
                }
            }
            if (r5 == -1) {
                r5 = str2.length();
            }
            arrayList2.add(Integer.valueOf(r5));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) arrayList2);
        if (num != null) {
            r2 = num.intValue();
        } else {
            r2 = 0;
        }
        int size = (lines.size() * 0) + str.length();
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (true) {
            String str3 = null;
            if (it2.hasNext()) {
                Object next = it2.next();
                int r7 = r5 + 1;
                if (r5 >= 0) {
                    String str4 = (String) next;
                    if ((r5 != 0 && r5 != lastIndex) || !StringsKt__StringsJVMKt.isBlank(str4)) {
                        str3 = StringsKt__IndentKt$getIndentFunction$1.INSTANCE.invoke(StringsKt___StringsKt.drop(r2, str4));
                        if (str3 == null) {
                            str3 = str4;
                        }
                    }
                    if (str3 != null) {
                        arrayList3.add(str3);
                    }
                    r5 = r7;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            } else {
                StringBuilder sb = new StringBuilder(size);
                CollectionsKt___CollectionsKt.joinTo$default(arrayList3, sb, "\n", null, 124);
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return sb2;
            }
        }
    }

    public static final String trimMargin(String str, String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (!StringsKt__StringsJVMKt.isBlank(marginPrefix)) {
            List<String> lines = StringsKt__StringsKt.lines(str);
            int size = (lines.size() * 0) + str.length();
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = lines.iterator();
            int r4 = 0;
            while (true) {
                String str2 = null;
                if (it.hasNext()) {
                    Object next = it.next();
                    int r7 = r4 + 1;
                    if (r4 >= 0) {
                        String str3 = (String) next;
                        if ((r4 != 0 && r4 != lastIndex) || !StringsKt__StringsJVMKt.isBlank(str3)) {
                            int length = str3.length();
                            int r8 = 0;
                            while (true) {
                                if (r8 < length) {
                                    if (!CharsKt__CharKt.isWhitespace(str3.charAt(r8))) {
                                        break;
                                    }
                                    r8++;
                                } else {
                                    r8 = -1;
                                    break;
                                }
                            }
                            if (r8 != -1 && StringsKt__StringsJVMKt.startsWith(str3, r8, marginPrefix, false)) {
                                str2 = str3.substring(marginPrefix.length() + r8);
                                Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                            }
                            if (str2 == null || (str2 = StringsKt__IndentKt$getIndentFunction$1.INSTANCE.invoke(str2)) == null) {
                                str2 = str3;
                            }
                        }
                        if (str2 != null) {
                            arrayList.add(str2);
                        }
                        r4 = r7;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                } else {
                    StringBuilder sb = new StringBuilder(size);
                    CollectionsKt___CollectionsKt.joinTo$default(arrayList, sb, "\n", null, 124);
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                    return sb2;
                }
            }
        } else {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
    }

    public static /* synthetic */ String trimMargin$default(String str) {
        return trimMargin(str, "|");
    }
}
