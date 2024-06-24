package androidx.compose.ui.node;

import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ComposeUiNode.kt */
/* loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetMeasurePolicy$1 extends Lambda implements Function2<ComposeUiNode, MeasurePolicy, Unit> {
    public static final ComposeUiNode$Companion$SetMeasurePolicy$1 INSTANCE = new ComposeUiNode$Companion$SetMeasurePolicy$1();

    public ComposeUiNode$Companion$SetMeasurePolicy$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(ComposeUiNode composeUiNode, MeasurePolicy measurePolicy) {
        ComposeUiNode composeUiNode2 = composeUiNode;
        MeasurePolicy it = measurePolicy;
        Intrinsics.checkNotNullParameter(composeUiNode2, "$this$null");
        Intrinsics.checkNotNullParameter(it, "it");
        composeUiNode2.setMeasurePolicy(it);
        return Unit.INSTANCE;
    }
}
