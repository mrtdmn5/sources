package androidx.compose.ui.text.android;

import android.text.Layout;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: LayoutHelper.kt */
/* loaded from: classes.dex */
public final class LayoutHelper {
    public final boolean[] bidiProcessedParagraphs;
    public final Layout layout;
    public final ArrayList paragraphBidi;
    public final ArrayList paragraphEnds;
    public char[] tmpBuffer;

    /* compiled from: LayoutHelper.kt */
    /* loaded from: classes.dex */
    public static final class BidiRun {
        public final int end;
        public final boolean isRtl;
        public final int start;

        public BidiRun(int r1, int r2, boolean z) {
            this.start = r1;
            this.end = r2;
            this.isRtl = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) obj;
            if (this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.end, Integer.hashCode(this.start) * 31, 31);
            boolean z = this.isRtl;
            int r1 = z;
            if (z != 0) {
                r1 = 1;
            }
            return m + r1;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("BidiRun(start=");
            sb.append(this.start);
            sb.append(", end=");
            sb.append(this.end);
            sb.append(", isRtl=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isRtl, ')');
        }
    }

    public LayoutHelper(Layout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
        ArrayList arrayList = new ArrayList();
        int r1 = 0;
        do {
            CharSequence text = this.layout.getText();
            Intrinsics.checkNotNullExpressionValue(text, "layout.text");
            int indexOf$default = StringsKt__StringsKt.indexOf$default(text, '\n', r1, false, 4);
            if (indexOf$default < 0) {
                r1 = this.layout.getText().length();
            } else {
                r1 = indexOf$default + 1;
            }
            arrayList.add(Integer.valueOf(r1));
        } while (r1 < this.layout.getText().length());
        this.paragraphEnds = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int r0 = 0; r0 < size; r0++) {
            arrayList2.add(null);
        }
        this.paragraphBidi = arrayList2;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphEnds.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01df, code lost:            if (r10 == r1.isRtl) goto L123;     */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float getHorizontalPosition(int r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutHelper.getHorizontalPosition(int, boolean, boolean):float");
    }

    public final int lineEndToVisibleEnd(int r5) {
        boolean z;
        while (r5 > 0) {
            char charAt = this.layout.getText().charAt(r5 - 1);
            boolean z2 = true;
            if (charAt != ' ' && charAt != '\n' && charAt != 5760) {
                if (8192 <= charAt && charAt < 8203) {
                    z = true;
                } else {
                    z = false;
                }
                if ((!z || charAt == 8199) && charAt != 8287 && charAt != 12288) {
                    z2 = false;
                }
            }
            if (!z2) {
                break;
            }
            r5--;
        }
        return r5;
    }
}
