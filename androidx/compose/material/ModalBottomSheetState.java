package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalBottomSheet.kt */
/* loaded from: classes.dex */
public final class ModalBottomSheetState {
    public final AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState;
    public final AnimationSpec<Float> animationSpec;
    public Density density;
    public final boolean isSkipHalfExpanded;

    public ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, boolean z, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
        boolean z2;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.isSkipHalfExpanded = z;
        this.anchoredDraggableState = new AnchoredDraggableState<>(initialValue, new Function1<Float, Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(Float f) {
                f.floatValue();
                return Float.valueOf(ModalBottomSheetState.access$requireDensity(ModalBottomSheetState.this).mo49toPx0680j_4(ModalBottomSheetKt.ModalBottomSheetPositionalThreshold));
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.ModalBottomSheetState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(ModalBottomSheetState.access$requireDensity(ModalBottomSheetState.this).mo49toPx0680j_4(ModalBottomSheetKt.ModalBottomSheetVelocityThreshold));
            }
        }, animationSpec, confirmStateChange);
        if (z) {
            if (initialValue != ModalBottomSheetValue.HalfExpanded) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
            }
        }
    }

    public static final Density access$requireDensity(ModalBottomSheetState modalBottomSheetState) {
        Density density = modalBottomSheetState.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on ModalBottomSheetState (" + modalBottomSheetState + ") was not set. Did you use ModalBottomSheetState with the ModalBottomSheetLayout composable?").toString());
    }

    public static Object animateTo$material_release$default(ModalBottomSheetState modalBottomSheetState, ModalBottomSheetValue modalBottomSheetValue, Continuation continuation) {
        Object animateTo = AnchoredDraggableKt.animateTo(modalBottomSheetState.anchoredDraggableState.lastVelocity$delegate.getFloatValue(), modalBottomSheetState.anchoredDraggableState, modalBottomSheetValue, continuation);
        if (animateTo != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return Unit.INSTANCE;
        }
        return animateTo;
    }

    public final Object hide(Continuation<? super Unit> continuation) {
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.Hidden, continuation);
        if (animateTo$material_release$default == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateTo$material_release$default;
        }
        return Unit.INSTANCE;
    }

    public final Object show(Continuation<? super Unit> continuation) {
        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
        if (!this.anchoredDraggableState.getAnchors$material_release().containsKey(modalBottomSheetValue)) {
            modalBottomSheetValue = ModalBottomSheetValue.Expanded;
        }
        Object animateTo$material_release$default = animateTo$material_release$default(this, modalBottomSheetValue, continuation);
        if (animateTo$material_release$default == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateTo$material_release$default;
        }
        return Unit.INSTANCE;
    }
}
