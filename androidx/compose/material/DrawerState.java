package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Drawer.kt */
/* loaded from: classes.dex */
public final class DrawerState {
    public final AnchoredDraggableState<DrawerValue> anchoredDraggableState;
    public Density density;

    public DrawerState(DrawerValue initialValue, Function1<? super DrawerValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue, new Function1<Float, Float>() { // from class: androidx.compose.material.DrawerState$anchoredDraggableState$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(Float f) {
                f.floatValue();
                return Float.valueOf(DrawerState.access$requireDensity(DrawerState.this).mo49toPx0680j_4(DrawerKt.DrawerPositionalThreshold));
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.DrawerState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(DrawerState.access$requireDensity(DrawerState.this).mo49toPx0680j_4(DrawerKt.DrawerVelocityThreshold));
            }
        }, DrawerKt.AnimationSpec, confirmStateChange);
    }

    public static final Density access$requireDensity(DrawerState drawerState) {
        Density density = drawerState.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + drawerState + ") was not set. Did you use DrawerState with the Drawer composable?").toString());
    }
}
