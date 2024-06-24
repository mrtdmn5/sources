package androidx.compose.ui.platform;

/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$ParagraphTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    public static AccessibilityIterators$ParagraphTextSegmentIterator instance;

    public AccessibilityIterators$ParagraphTextSegmentIterator(int r1) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:            return null;     */
    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] following(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = r4.getText()
            int r0 = r0.length()
            r1 = 0
            if (r0 > 0) goto Lc
            return r1
        Lc:
            if (r5 < r0) goto Lf
            return r1
        Lf:
            if (r5 >= 0) goto L12
            r5 = 0
        L12:
            if (r5 >= r0) goto L29
            java.lang.String r2 = r4.getText()
            char r2 = r2.charAt(r5)
            r3 = 10
            if (r2 != r3) goto L29
            boolean r2 = r4.isStartBoundary(r5)
            if (r2 != 0) goto L29
            int r5 = r5 + 1
            goto L12
        L29:
            if (r5 < r0) goto L2c
            return r1
        L2c:
            int r1 = r5 + 1
        L2e:
            if (r1 >= r0) goto L39
            boolean r2 = r4.isEndBoundary(r1)
            if (r2 != 0) goto L39
            int r1 = r1 + 1
            goto L2e
        L39:
            int[] r5 = r4.getRange(r5, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator.following(int):int[]");
    }

    public final boolean isEndBoundary(int r3) {
        if (r3 > 0 && getText().charAt(r3 - 1) != '\n' && (r3 == getText().length() || getText().charAt(r3) == '\n')) {
            return true;
        }
        return false;
    }

    public final boolean isStartBoundary(int r4) {
        if (getText().charAt(r4) != '\n' && (r4 == 0 || getText().charAt(r4 - 1) == '\n')) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] preceding(int r5) {
        int length = getText().length();
        if (length <= 0 || r5 <= 0) {
            return null;
        }
        if (r5 > length) {
            r5 = length;
        }
        while (r5 > 0) {
            int r2 = r5 - 1;
            if (getText().charAt(r2) != '\n' || isEndBoundary(r5)) {
                break;
            }
            r5 = r2;
        }
        if (r5 <= 0) {
            return null;
        }
        int r0 = r5 - 1;
        while (r0 > 0 && !isStartBoundary(r0)) {
            r0--;
        }
        return getRange(r0, r5);
    }
}
