package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public final class HorizontalAlignmentLine extends AlignmentLine {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalAlignmentLine(Function2<? super Integer, ? super Integer, Integer> merger) {
        super(merger);
        Intrinsics.checkNotNullParameter(merger, "merger");
    }
}
