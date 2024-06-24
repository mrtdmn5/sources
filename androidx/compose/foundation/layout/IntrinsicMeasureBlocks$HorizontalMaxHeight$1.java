package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class IntrinsicMeasureBlocks$HorizontalMaxHeight$1 extends Lambda implements Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> {
    public static final IntrinsicMeasureBlocks$HorizontalMaxHeight$1 INSTANCE = new IntrinsicMeasureBlocks$HorizontalMaxHeight$1();

    public IntrinsicMeasureBlocks$HorizontalMaxHeight$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Integer invoke(List<? extends IntrinsicMeasurable> list, Integer num, Integer num2) {
        List<? extends IntrinsicMeasurable> measurables = list;
        int intValue = num.intValue();
        int intValue2 = num2.intValue();
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return Integer.valueOf(RowColumnImplKt.access$intrinsicSize(measurables, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1.1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num3) {
                IntrinsicMeasurable intrinsicSize = intrinsicMeasurable;
                int intValue3 = num3.intValue();
                Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                return Integer.valueOf(intrinsicSize.maxIntrinsicHeight(intValue3));
            }
        }, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMaxHeight$1.2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num3) {
                IntrinsicMeasurable intrinsicSize = intrinsicMeasurable;
                int intValue3 = num3.intValue();
                Intrinsics.checkNotNullParameter(intrinsicSize, "$this$intrinsicSize");
                return Integer.valueOf(intrinsicSize.maxIntrinsicWidth(intValue3));
            }
        }, intValue, intValue2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical));
    }
}
