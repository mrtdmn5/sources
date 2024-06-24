package androidx.compose.foundation;

import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;

/* compiled from: ProgressSemantics.kt */
/* loaded from: classes.dex */
public final class ProgressSemanticsKt$progressSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public final /* synthetic */ int $steps;
    public final /* synthetic */ float $value;
    public final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressSemanticsKt$progressSemantics$1(float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, int r3) {
        super(1);
        this.$value = f;
        this.$valueRange = closedFloatingPointRange;
        this.$steps = r3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertyReceiver semantics = semanticsPropertyReceiver;
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        Float valueOf = Float.valueOf(this.$value);
        ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
        ProgressBarRangeInfo progressBarRangeInfo = new ProgressBarRangeInfo(((Number) RangesKt___RangesKt.coerceIn(valueOf, closedFloatingPointRange)).floatValue(), closedFloatingPointRange, this.$steps);
        KProperty<Object>[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        SemanticsProperties.ProgressBarRangeInfo.setValue(semantics, SemanticsPropertiesKt.$$delegatedProperties[1], progressBarRangeInfo);
        return Unit.INSTANCE;
    }
}
