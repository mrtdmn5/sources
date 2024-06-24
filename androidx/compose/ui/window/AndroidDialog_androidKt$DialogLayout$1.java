package androidx.compose.ui.window;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidDialog.android.kt */
/* loaded from: classes.dex */
public final class AndroidDialog_androidKt$DialogLayout$1 implements MeasurePolicy {
    public static final AndroidDialog_androidKt$DialogLayout$1 INSTANCE = new AndroidDialog_androidKt$DialogLayout$1();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        Object obj;
        int m567getMinWidthimpl;
        int m566getMinHeightimpl;
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        final ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int r3 = 0; r3 < size; r3++) {
            arrayList.add(measurables.get(r3).mo421measureBRTryo0(j));
        }
        int r1 = 1;
        Placeable placeable = null;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int r4 = ((Placeable) obj).width;
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int r6 = 1;
                while (true) {
                    Object obj2 = arrayList.get(r6);
                    int r8 = ((Placeable) obj2).width;
                    if (r4 < r8) {
                        obj = obj2;
                        r4 = r8;
                    }
                    if (r6 == lastIndex) {
                        break;
                    }
                    r6++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj;
        if (placeable2 != null) {
            m567getMinWidthimpl = placeable2.width;
        } else {
            m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
        }
        if (!arrayList.isEmpty()) {
            ?? r2 = arrayList.get(0);
            int r32 = ((Placeable) r2).height;
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            boolean z = r2;
            if (1 <= lastIndex2) {
                while (true) {
                    Object obj3 = arrayList.get(r1);
                    int r62 = ((Placeable) obj3).height;
                    r2 = z;
                    if (r32 < r62) {
                        r2 = obj3;
                        r32 = r62;
                    }
                    if (r1 == lastIndex2) {
                        break;
                    }
                    r1++;
                    z = r2;
                }
            }
            placeable = r2;
        }
        Placeable placeable3 = placeable;
        if (placeable3 != null) {
            m566getMinHeightimpl = placeable3.height;
        } else {
            m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
        }
        return Layout.layout(m567getMinWidthimpl, m566getMinHeightimpl, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$measure$1
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
                for (int r33 = 0; r33 < size2; r33++) {
                    Placeable.PlacementScope.placeRelative$default(layout, list.get(r33), 0, 0);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
