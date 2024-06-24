package androidx.compose.ui.text;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraph.kt */
/* loaded from: classes.dex */
public final class MultiParagraphKt {
    public static final int findParagraphByIndex(int r7, ArrayList paragraphInfoList) {
        char c;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int r3 = 0;
        while (r3 <= size) {
            int r4 = (r3 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) paragraphInfoList.get(r4);
            if (paragraphInfo.startIndex > r7) {
                c = 1;
            } else if (paragraphInfo.endIndex <= r7) {
                c = 65535;
            } else {
                c = 0;
            }
            if (c < 0) {
                r3 = r4 + 1;
            } else if (c > 0) {
                size = r4 - 1;
            } else {
                return r4;
            }
        }
        return -(r3 + 1);
    }

    public static final int findParagraphByLineIndex(int r7, ArrayList paragraphInfoList) {
        char c;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int r3 = 0;
        while (r3 <= size) {
            int r4 = (r3 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) paragraphInfoList.get(r4);
            if (paragraphInfo.startLineIndex > r7) {
                c = 1;
            } else if (paragraphInfo.endLineIndex <= r7) {
                c = 65535;
            } else {
                c = 0;
            }
            if (c < 0) {
                r3 = r4 + 1;
            } else if (c > 0) {
                size = r4 - 1;
            } else {
                return r4;
            }
        }
        return -(r3 + 1);
    }

    public static final int findParagraphByY(ArrayList paragraphInfoList, float f) {
        char c;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int r3 = 0;
        while (r3 <= size) {
            int r4 = (r3 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) paragraphInfoList.get(r4);
            if (paragraphInfo.top > f) {
                c = 1;
            } else if (paragraphInfo.bottom <= f) {
                c = 65535;
            } else {
                c = 0;
            }
            if (c < 0) {
                r3 = r4 + 1;
            } else if (c > 0) {
                size = r4 - 1;
            } else {
                return r4;
            }
        }
        return -(r3 + 1);
    }
}
