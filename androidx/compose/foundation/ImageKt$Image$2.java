package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
/* loaded from: classes.dex */
public final class ImageKt$Image$2 implements MeasurePolicy {
    public static final ImageKt$Image$2 INSTANCE = new ImageKt$Image$2();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
        return Layout.layout(Constraints.m567getMinWidthimpl(j), Constraints.m566getMinHeightimpl(j), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$2$measure$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                return Unit.INSTANCE;
            }
        });
    }
}
