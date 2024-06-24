package androidx.compose.ui.layout;

import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnRemeasuredModifier.kt */
/* loaded from: classes.dex */
public final class OnSizeChangedModifier extends InspectorValueInfo implements OnRemeasuredModifier {
    public final Function1<IntSize, Unit> onSizeChanged;
    public long previousSize;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OnSizeChangedModifier(kotlin.jvm.functions.Function1 r3) {
        /*
            r2 = this;
            androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1 r0 = androidx.compose.ui.platform.InspectableValueKt.NoInspectorInfo
            java.lang.String r1 = "inspectorInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r2.<init>(r0)
            r2.onSizeChanged = r3
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            long r0 = androidx.compose.ui.unit.IntSizeKt.IntSize(r3, r3)
            r2.previousSize = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.OnSizeChangedModifier.<init>(kotlin.jvm.functions.Function1):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnSizeChangedModifier)) {
            return false;
        }
        return Intrinsics.areEqual(this.onSizeChanged, ((OnSizeChangedModifier) obj).onSizeChanged);
    }

    public final int hashCode() {
        return this.onSizeChanged.hashCode();
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* renamed from: onRemeasured-ozmzZPI */
    public final void mo33onRemeasuredozmzZPI(long j) {
        if (!IntSize.m592equalsimpl0(this.previousSize, j)) {
            this.onSizeChanged.invoke(new IntSize(j));
            this.previousSize = j;
        }
    }
}
