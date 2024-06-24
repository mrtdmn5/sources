package androidx.compose.ui.window;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public final class AndroidPopup_androidKt$SimpleStack$1 implements MeasurePolicy {
    public static final AndroidPopup_androidKt$SimpleStack$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        int r10;
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        int size = measurables.size();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        int r2 = 0;
        if (size != 0) {
            if (size != 1) {
                final ArrayList arrayList = new ArrayList(measurables.size());
                int size2 = measurables.size();
                for (int r4 = 0; r4 < size2; r4++) {
                    arrayList.add(measurables.get(r4).mo421measureBRTryo0(j));
                }
                int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (lastIndex >= 0) {
                    int r9 = 0;
                    r10 = 0;
                    while (true) {
                        Placeable placeable = (Placeable) arrayList.get(r2);
                        r9 = Math.max(r9, placeable.width);
                        r10 = Math.max(r10, placeable.height);
                        if (r2 == lastIndex) {
                            break;
                        }
                        r2++;
                    }
                    r2 = r9;
                } else {
                    r10 = 0;
                }
                return Layout.layout(r2, r10, emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$measure$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope layout = placementScope;
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        List<Placeable> list = arrayList;
                        int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
                        if (lastIndex2 >= 0) {
                            int r3 = 0;
                            while (true) {
                                Placeable.PlacementScope.placeRelative$default(layout, list.get(r3), 0, 0);
                                if (r3 == lastIndex2) {
                                    break;
                                }
                                r3++;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            final Placeable mo421measureBRTryo0 = measurables.get(0).mo421measureBRTryo0(j);
            return Layout.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$measure$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope layout = placementScope;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0);
                    return Unit.INSTANCE;
                }
            });
        }
        return Layout.layout(0, 0, emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$measure$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                return Unit.INSTANCE;
            }
        });
    }
}
