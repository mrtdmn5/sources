package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotatedStringResolveInlineContent.kt */
/* loaded from: classes.dex */
public final class AnnotatedStringResolveInlineContentKt$InlineChildren$1$2 implements MeasurePolicy {
    public static final AnnotatedStringResolveInlineContentKt$InlineChildren$1$2 INSTANCE = new AnnotatedStringResolveInlineContentKt$InlineChildren$1$2();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> children, long j) {
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(children, "children");
        final ArrayList arrayList = new ArrayList(children.size());
        int size = children.size();
        for (int r2 = 0; r2 < size; r2++) {
            arrayList.add(children.get(r2).mo421measureBRTryo0(j));
        }
        return Layout.layout(Constraints.m565getMaxWidthimpl(j), Constraints.m564getMaxHeightimpl(j), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                List<Placeable> list = arrayList;
                int size2 = list.size();
                for (int r3 = 0; r3 < size2; r3++) {
                    Placeable.PlacementScope.placeRelative$default(layout, list.get(r3), 0, 0);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
