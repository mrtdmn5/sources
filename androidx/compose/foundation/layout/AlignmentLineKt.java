package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public final class AlignmentLineKt {
    /* renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static Modifier m59paddingFrom4j6BHR0$default(HorizontalAlignmentLine alignmentLine, float f, float f2, int r5) {
        if ((r5 & 2) != 0) {
            f = Float.NaN;
        }
        if ((r5 & 4) != 0) {
            f2 = Float.NaN;
        }
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return new AlignmentLineOffsetDpElement(alignmentLine, f, f2);
    }
}
