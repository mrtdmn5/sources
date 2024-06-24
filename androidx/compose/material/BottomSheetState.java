package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetScaffold.kt */
/* loaded from: classes.dex */
public final class BottomSheetState {
    public final AnchoredDraggableState<BottomSheetValue> anchoredDraggableState;
    public Density density;

    public BottomSheetState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmValueChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue, new Function1<Float, Float>() { // from class: androidx.compose.material.BottomSheetState$anchoredDraggableState$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(Float f) {
                f.floatValue();
                return Float.valueOf(BottomSheetState.access$requireDensity(BottomSheetState.this).mo49toPx0680j_4(BottomSheetScaffoldKt.BottomSheetScaffoldPositionalThreshold));
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.BottomSheetState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(BottomSheetState.access$requireDensity(BottomSheetState.this).mo49toPx0680j_4(BottomSheetScaffoldKt.BottomSheetScaffoldVelocityThreshold));
            }
        }, animationSpec, confirmValueChange);
    }

    public static final Density access$requireDensity(BottomSheetState bottomSheetState) {
        Density density = bottomSheetState.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on BottomSheetState (" + bottomSheetState + ") was not set. Did you use BottomSheetState with the BottomSheetScaffold composable?").toString());
    }

    public final Object collapse(Continuation<? super Unit> continuation) {
        Object animateTo;
        animateTo = AnchoredDraggableKt.animateTo(r0.lastVelocity$delegate.getFloatValue(), this.anchoredDraggableState, BottomSheetValue.Collapsed, continuation);
        if (animateTo == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateTo;
        }
        return Unit.INSTANCE;
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        Object animateTo;
        BottomSheetValue bottomSheetValue = BottomSheetValue.Expanded;
        AnchoredDraggableState<BottomSheetValue> anchoredDraggableState = this.anchoredDraggableState;
        if (!anchoredDraggableState.getAnchors$material_release().containsKey(bottomSheetValue)) {
            bottomSheetValue = BottomSheetValue.Collapsed;
        }
        animateTo = AnchoredDraggableKt.animateTo(anchoredDraggableState.lastVelocity$delegate.getFloatValue(), anchoredDraggableState, bottomSheetValue, continuation);
        if (animateTo == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateTo;
        }
        return Unit.INSTANCE;
    }
}
