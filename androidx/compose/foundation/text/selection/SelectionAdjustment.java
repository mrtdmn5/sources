package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SelectionAdjustment.kt */
/* loaded from: classes.dex */
public interface SelectionAdjustment {

    /* compiled from: SelectionAdjustment.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final SelectionAdjustment$Companion$Character$1 Character;
        public static final SelectionAdjustment$Companion$CharacterWithWordAccelerate$1 CharacterWithWordAccelerate;
        public static final SelectionAdjustment$Companion$Word$1 Word;

        static {
            new SelectionAdjustment$Companion$None$1();
            Character = new SelectionAdjustment$Companion$Character$1();
            Word = new SelectionAdjustment$Companion$Word$1();
            new SelectionAdjustment$Companion$Paragraph$1();
            CharacterWithWordAccelerate = new SelectionAdjustment$Companion$CharacterWithWordAccelerate$1();
        }

        /* renamed from: access$adjustByBoundary--Dv-ylE */
        public static final long m140access$adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j, Function1 function1) {
            boolean z;
            int r6;
            int m523getEndimpl;
            TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
            if (textLayoutInput.text.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return TextRange.Zero;
            }
            int lastIndex = StringsKt__StringsKt.getLastIndex(textLayoutInput.text);
            int r0 = TextRange.$r8$clinit;
            long j2 = ((TextRange) function1.invoke(Integer.valueOf(RangesKt___RangesKt.coerceIn((int) (j >> 32), 0, lastIndex)))).packedValue;
            long j3 = ((TextRange) function1.invoke(Integer.valueOf(RangesKt___RangesKt.coerceIn(TextRange.m523getEndimpl(j), 0, lastIndex)))).packedValue;
            if (TextRange.m526getReversedimpl(j)) {
                r6 = TextRange.m523getEndimpl(j2);
            } else {
                r6 = (int) (j2 >> 32);
            }
            if (TextRange.m526getReversedimpl(j)) {
                m523getEndimpl = (int) (j3 >> 32);
            } else {
                m523getEndimpl = TextRange.m523getEndimpl(j3);
            }
            return TextRangeKt.TextRange(r6, m523getEndimpl);
        }
    }

    /* renamed from: adjust-ZXO7KMw */
    long mo139adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int r4, boolean z, TextRange textRange);
}
