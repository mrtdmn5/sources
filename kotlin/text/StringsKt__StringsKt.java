package kotlin.text;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;
import kotlin.sequences.TransformingSequence;

/* compiled from: Strings.kt */
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final boolean contains(CharSequence charSequence, CharSequence other, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            if (indexOf$default(charSequence, (String) other, 0, z, 2) < 0) {
                return false;
            }
        } else if (indexOf$StringsKt__StringsKt(charSequence, other, 0, charSequence.length(), z, false) < 0) {
            return false;
        }
        return true;
    }

    public static boolean contains$default(CharSequence charSequence, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (indexOf$default(charSequence, c, 0, false, 2) < 0) {
            return false;
        }
        return true;
    }

    public static boolean endsWith$default(CharSequence charSequence, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(getLastIndex(charSequence)), c, false);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int indexOf(int r6, CharSequence charSequence, String string, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, r6);
        }
        return indexOf$StringsKt__StringsKt(charSequence, string, r6, charSequence.length(), z, false);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int r10, int r11, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            if (r10 < 0) {
                r10 = 0;
            }
            int length = charSequence.length();
            if (r11 > length) {
                r11 = length;
            }
            intProgression = new IntRange(r10, r11);
        } else {
            int lastIndex = getLastIndex(charSequence);
            if (r10 > lastIndex) {
                r10 = lastIndex;
            }
            if (r11 < 0) {
                r11 = 0;
            }
            intProgression = new IntProgression(r10, r11, -1);
        }
        boolean z3 = charSequence instanceof String;
        int r112 = intProgression.first;
        int r1 = intProgression.step;
        int r13 = intProgression.last;
        if (z3 && (charSequence2 instanceof String)) {
            if ((r1 > 0 && r112 <= r13) || (r1 < 0 && r13 <= r112)) {
                while (!StringsKt__StringsJVMKt.regionMatches(0, r112, charSequence2.length(), (String) charSequence2, (String) charSequence, z)) {
                    if (r112 != r13) {
                        r112 += r1;
                    }
                }
                return r112;
            }
        } else if ((r1 > 0 && r112 <= r13) || (r1 < 0 && r13 <= r112)) {
            while (!regionMatchesImpl(charSequence2, 0, charSequence, r112, charSequence2.length(), z)) {
                if (r112 != r13) {
                    r112 += r1;
                }
            }
            return r112;
        }
        return -1;
    }

    public static int indexOf$default(CharSequence charSequence, char c, int r4, boolean z, int r6) {
        if ((r6 & 2) != 0) {
            r4 = 0;
        }
        if ((r6 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, r4);
        }
        return indexOfAny(r4, charSequence, z, new char[]{c});
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [kotlin.ranges.IntProgressionIterator] */
    public static final int indexOfAny(int r7, CharSequence charSequence, boolean z, char[] chars) {
        boolean z2;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt___ArraysKt.single(chars), r7);
        }
        if (r7 < 0) {
            r7 = 0;
        }
        ?? it = new IntRange(r7, getLastIndex(charSequence)).iterator();
        while (it.hasNext) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int r5 = 0;
            while (true) {
                if (r5 < length) {
                    if (CharsKt__CharKt.equals(chars[r5], charAt, z)) {
                        z2 = true;
                        break;
                    }
                    r5++;
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                return nextInt;
            }
        }
        return -1;
    }

    public static int lastIndexOf$default(CharSequence charSequence, char c, int r4, int r5) {
        if ((r5 & 2) != 0) {
            r4 = getLastIndex(charSequence);
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!(charSequence instanceof String)) {
            char[] cArr = {c};
            if (charSequence instanceof String) {
                return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.single(cArr), r4);
            }
            int lastIndex = getLastIndex(charSequence);
            if (r4 > lastIndex) {
                r4 = lastIndex;
            }
            while (-1 < r4) {
                if (CharsKt__CharKt.equals(cArr[0], charSequence.charAt(r4), false)) {
                    return r4;
                }
                r4--;
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(c, r4);
    }

    public static final List<String> lines(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return SequencesKt___SequencesKt.toList(new TransformingSequence(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(IntRange intRange) {
                IntRange it = intRange;
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt__StringsKt.substring(charSequence, it);
            }
        }));
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [kotlin.ranges.IntProgressionIterator] */
    public static final String padStart(String str, int r4, char c) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (r4 >= 0) {
            if (r4 <= str.length()) {
                charSequence = str.subSequence(0, str.length());
            } else {
                StringBuilder sb = new StringBuilder(r4);
                ?? it = new IntRange(1, r4 - str.length()).iterator();
                while (it.hasNext) {
                    it.nextInt();
                    sb.append(c);
                }
                sb.append((CharSequence) str);
                charSequence = sb;
            }
            return charSequence.toString();
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Desired length ", r4, " is less than zero."));
    }

    public static DelimitedRangesSequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, final boolean z, int r5) {
        requireNonNegativeLimit(r5);
        final List asList = ArraysKt___ArraysJvmKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, 0, r5, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                Object obj;
                Pair pair;
                Object obj2;
                Object obj3;
                CharSequence $receiver = charSequence2;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                List<String> list = asList;
                boolean z2 = z;
                if (!z2 && list.size() == 1) {
                    List<String> list2 = list;
                    if (list2 instanceof List) {
                        List<String> list3 = list2;
                        int size = list3.size();
                        if (size != 0) {
                            if (size == 1) {
                                obj3 = list3.get(0);
                            } else {
                                throw new IllegalArgumentException("List has more than one element.");
                            }
                        } else {
                            throw new NoSuchElementException("List is empty.");
                        }
                    } else {
                        Iterator<T> it = list2.iterator();
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (!it.hasNext()) {
                                obj3 = next;
                            } else {
                                throw new IllegalArgumentException("Collection has more than one element.");
                            }
                        } else {
                            throw new NoSuchElementException("Collection is empty.");
                        }
                    }
                    String str = (String) obj3;
                    int indexOf$default = StringsKt__StringsKt.indexOf$default($receiver, str, intValue, false, 4);
                    if (indexOf$default >= 0) {
                        pair = new Pair(Integer.valueOf(indexOf$default), str);
                    }
                    pair = null;
                } else {
                    if (intValue < 0) {
                        intValue = 0;
                    }
                    IntRange intRange = new IntRange(intValue, $receiver.length());
                    boolean z3 = $receiver instanceof String;
                    int r9 = intRange.step;
                    int r10 = intRange.last;
                    if (z3) {
                        if ((r9 > 0 && intValue <= r10) || (r9 < 0 && r10 <= intValue)) {
                            while (true) {
                                Iterator<T> it2 = list.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        obj2 = it2.next();
                                        String str2 = (String) obj2;
                                        if (StringsKt__StringsJVMKt.regionMatches(0, intValue, str2.length(), str2, (String) $receiver, z2)) {
                                            break;
                                        }
                                    } else {
                                        obj2 = null;
                                        break;
                                    }
                                }
                                String str3 = (String) obj2;
                                if (str3 != null) {
                                    pair = new Pair(Integer.valueOf(intValue), str3);
                                    break;
                                }
                                if (intValue == r10) {
                                    break;
                                }
                                intValue += r9;
                            }
                        }
                        pair = null;
                    } else {
                        if ((r9 > 0 && intValue <= r10) || (r9 < 0 && r10 <= intValue)) {
                            while (true) {
                                Iterator<T> it3 = list.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        obj = it3.next();
                                        String str4 = (String) obj;
                                        if (StringsKt__StringsKt.regionMatchesImpl(str4, 0, $receiver, intValue, str4.length(), z2)) {
                                            break;
                                        }
                                    } else {
                                        obj = null;
                                        break;
                                    }
                                }
                                String str5 = (String) obj;
                                if (str5 != null) {
                                    pair = new Pair(Integer.valueOf(intValue), str5);
                                    break;
                                }
                                if (intValue == r10) {
                                    break;
                                }
                                intValue += r9;
                            }
                        }
                        pair = null;
                    }
                }
                if (pair == null) {
                    return null;
                }
                return new Pair<>(pair.first, Integer.valueOf(((String) pair.second).length()));
            }
        });
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int r5, CharSequence other, int r7, int r8, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (r7 < 0 || r5 < 0 || r5 > charSequence.length() - r8 || r7 > other.length() - r8) {
            return false;
        }
        for (int r1 = 0; r1 < r8; r1++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(r5 + r1), other.charAt(r7 + r1), z)) {
                return false;
            }
        }
        return true;
    }

    public static final String removePrefix(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "<this>");
        if (StringsKt__StringsJVMKt.startsWith(str2, str, false)) {
            String substring = str2.substring(str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str2;
    }

    public static final String removeSuffix(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "<this>");
        if (endsWith$default(str2, str)) {
            String substring = str2.substring(0, str2.length() - str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str2;
    }

    public static final void requireNonNegativeLimit(int r1) {
        boolean z;
        if (r1 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Limit must be non-negative, but was ", r1).toString());
        }
    }

    public static final List split$StringsKt__StringsKt(int r7, CharSequence charSequence, String str, boolean z) {
        boolean z2;
        requireNonNegativeLimit(r7);
        int r0 = 0;
        int indexOf = indexOf(0, charSequence, str, z);
        if (indexOf != -1 && r7 != 1) {
            if (r7 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            int r6 = 10;
            if (z2 && r7 <= 10) {
                r6 = r7;
            }
            ArrayList arrayList = new ArrayList(r6);
            do {
                arrayList.add(charSequence.subSequence(r0, indexOf).toString());
                r0 = str.length() + indexOf;
                if (z2 && arrayList.size() == r7 - 1) {
                    break;
                }
                indexOf = indexOf(r0, charSequence, str, z);
            } while (indexOf != -1);
            arrayList.add(charSequence.subSequence(r0, charSequence.length()).toString());
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.listOf(charSequence.toString());
    }

    public static List split$default(int r2, int r3, CharSequence charSequence, final char[] cArr) {
        final boolean z = false;
        if ((r3 & 4) != 0) {
            r2 = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(r2, charSequence, String.valueOf(cArr[0]), false);
        }
        requireNonNegativeLimit(r2);
        SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(new DelimitedRangesSequence(charSequence, 0, r2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                CharSequence $receiver = charSequence2;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                int indexOfAny = StringsKt__StringsKt.indexOfAny(intValue, $receiver, z, cArr);
                if (indexOfAny < 0) {
                    return null;
                }
                return new Pair<>(Integer.valueOf(indexOfAny), 1);
            }
        }));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1, 10));
        Iterator<Object> it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static boolean startsWith$default(CharSequence charSequence, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() <= 0 || !CharsKt__CharKt.equals(charSequence.charAt(0), c, false)) {
            return false;
        }
        return true;
    }

    public static final String substring(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String substring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String substringAfter$default(String str, String delimiter) {
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        int indexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6);
        if (indexOf$default != -1) {
            String substring = str.substring(delimiter.length() + indexOf$default, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return str;
    }

    public static String substringAfterLast$default(String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default(missingDelimiterValue, '.', 0, 6);
        if (lastIndexOf$default != -1) {
            String substring = missingDelimiterValue.substring(lastIndexOf$default + 1, missingDelimiterValue.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static String substringBefore$default(String str, char c) {
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6);
        if (indexOf$default == -1) {
            return str;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final String trim(String str, char... cArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length() - 1;
        int r2 = 0;
        boolean z = false;
        while (r2 <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, str.charAt(!z ? r2 : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                r2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(r2, length + 1).toString();
    }

    public static final String trimStart(String str, char... cArr) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int r1 = 0;
        while (true) {
            if (r1 < length) {
                if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(r1))) {
                    charSequence = str.subSequence(r1, str.length());
                    break;
                }
                r1++;
            } else {
                charSequence = "";
                break;
            }
        }
        return charSequence.toString();
    }

    public static final String substring(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static boolean endsWith$default(CharSequence charSequence, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence instanceof String) {
            return StringsKt__StringsJVMKt.endsWith((String) charSequence, str, false);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - str.length(), str, 0, str.length(), false);
    }

    public static String substringBefore$default(String str, String str2) {
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6);
        if (indexOf$default == -1) {
            return str;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int r4, boolean z, int r6) {
        if ((r6 & 2) != 0) {
            r4 = 0;
        }
        if ((r6 & 4) != 0) {
            z = false;
        }
        return indexOf(r4, charSequence, str, z);
    }

    public static final CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int r2 = 0;
        boolean z = false;
        while (r2 <= length) {
            boolean isWhitespace = CharsKt__CharKt.isWhitespace(charSequence.charAt(!z ? r2 : length));
            if (z) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                r2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(r2, length + 1);
    }

    public static int lastIndexOf$default(CharSequence charSequence, String string, int r8) {
        int lastIndex = (r8 & 2) != 0 ? getLastIndex(charSequence) : 0;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, string, lastIndex, 0, false, true);
        }
        return ((String) charSequence).lastIndexOf(string, lastIndex);
    }

    public static List split$default(CharSequence charSequence, String[] strArr, int r5, int r6) {
        if ((r6 & 4) != 0) {
            r5 = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(r5, charSequence, str, false);
            }
        }
        SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, false, r5));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1, 10));
        Iterator<Object> it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }
}
