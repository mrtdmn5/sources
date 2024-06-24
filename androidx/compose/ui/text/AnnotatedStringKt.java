package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AnnotatedString.kt */
/* loaded from: classes.dex */
public final class AnnotatedStringKt {
    public static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, 6);

    public static final ArrayList access$filterRanges(int r8, List list, int r10) {
        boolean z;
        if (r8 <= r10) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int r3 = 0; r3 < size; r3++) {
                    Object obj = list.get(r3);
                    AnnotatedString.Range range = (AnnotatedString.Range) obj;
                    if (intersect(r8, r10, range.start, range.end)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size2 = arrayList.size();
                for (int r0 = 0; r0 < size2; r0++) {
                    AnnotatedString.Range range2 = (AnnotatedString.Range) arrayList.get(r0);
                    arrayList2.add(new AnnotatedString.Range(range2.item, Math.max(r8, range2.start) - r8, Math.min(r10, range2.end) - r8, range2.tag));
                }
                if (!arrayList2.isEmpty()) {
                    return arrayList2;
                }
            }
            return null;
        }
        throw new IllegalArgumentException(("start (" + r8 + ") should be less than or equal to end (" + r10 + ')').toString());
    }

    public static final List<AnnotatedString.Range<SpanStyle>> getLocalSpanStyles(AnnotatedString annotatedString, int r8, int r9) {
        List<AnnotatedString.Range<SpanStyle>> list;
        if (r8 == r9 || (list = annotatedString.spanStylesOrNull) == null) {
            return null;
        }
        if (r8 == 0 && r9 >= annotatedString.text.length()) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int r3 = 0; r3 < size; r3++) {
            AnnotatedString.Range<SpanStyle> range = list.get(r3);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (intersect(r8, r9, range2.start, range2.end)) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int r2 = 0; r2 < size2; r2++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(r2);
            arrayList2.add(new AnnotatedString.Range(RangesKt___RangesKt.coerceIn(range3.start, r8, r9) - r8, RangesKt___RangesKt.coerceIn(range3.end, r8, r9) - r8, range3.item));
        }
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:            if (r1 == r3) goto L52;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0033, code lost:            if (r4 == r5) goto L65;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean intersect(int r4, int r5, int r6, int r7) {
        /*
            int r0 = java.lang.Math.max(r4, r6)
            int r1 = java.lang.Math.min(r5, r7)
            r2 = 1
            if (r0 < r1) goto L3c
            r0 = 0
            if (r4 > r6) goto L20
            if (r7 > r5) goto L20
            if (r5 != r7) goto L1e
            if (r6 != r7) goto L16
            r1 = r2
            goto L17
        L16:
            r1 = r0
        L17:
            if (r4 != r5) goto L1b
            r3 = r2
            goto L1c
        L1b:
            r3 = r0
        L1c:
            if (r1 != r3) goto L20
        L1e:
            r1 = r2
            goto L21
        L20:
            r1 = r0
        L21:
            if (r1 != 0) goto L3c
            if (r6 > r4) goto L37
            if (r5 > r7) goto L37
            if (r7 != r5) goto L35
            if (r4 != r5) goto L2d
            r4 = r2
            goto L2e
        L2d:
            r4 = r0
        L2e:
            if (r6 != r7) goto L32
            r5 = r2
            goto L33
        L32:
            r5 = r0
        L33:
            if (r4 != r5) goto L37
        L35:
            r4 = r2
            goto L38
        L37:
            r4 = r0
        L38:
            if (r4 == 0) goto L3b
            goto L3c
        L3b:
            r2 = r0
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AnnotatedStringKt.intersect(int, int, int, int):boolean");
    }
}
