package com.google.android.gms.internal.fitness;

import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphKt;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public /* synthetic */ class zzba {
    public static final float getHorizontalPosition(TextLayoutResult textLayoutResult, int r2, boolean z, boolean z2) {
        int max;
        int findParagraphByIndex;
        Intrinsics.checkNotNullParameter(textLayoutResult, "<this>");
        boolean z3 = false;
        if ((z && !z2) || (!z && z2)) {
            max = r2;
        } else {
            max = Math.max(r2 - 1, 0);
        }
        if (textLayoutResult.getBidiRunDirection(max) == textLayoutResult.getParagraphDirection(r2)) {
            z3 = true;
        }
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(r2);
        int length = multiParagraph.intrinsics.annotatedString.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (r2 == length) {
            findParagraphByIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(r2, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByIndex);
        return paragraphInfo.paragraph.getHorizontalPosition(paragraphInfo.toLocalIndex(r2), z3);
    }
}
