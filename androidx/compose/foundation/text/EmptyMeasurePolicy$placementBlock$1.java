package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BasicText.kt */
/* loaded from: classes.dex */
public final class EmptyMeasurePolicy$placementBlock$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final EmptyMeasurePolicy$placementBlock$1 INSTANCE = new EmptyMeasurePolicy$placementBlock$1();

    public EmptyMeasurePolicy$placementBlock$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$null");
        return Unit.INSTANCE;
    }
}
