package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.modifier.SingleLocalMap;
import androidx.transition.PathMotion;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusedBounds.kt */
/* loaded from: classes.dex */
public final class FocusedBoundsObserverNode extends Modifier.Node implements ModifierLocalModifierNode, Function1<LayoutCoordinates, Unit> {
    public Function1<? super LayoutCoordinates, Unit> onPositioned;
    public final SingleLocalMap providedValues;

    public FocusedBoundsObserverNode(Function1<? super LayoutCoordinates, Unit> onPositioned) {
        boolean z;
        Intrinsics.checkNotNullParameter(onPositioned, "onPositioned");
        this.onPositioned = onPositioned;
        ProvidableModifierLocal<Function1<LayoutCoordinates, Unit>> providableModifierLocal = FocusedBoundsKt.ModifierLocalFocusedBoundsObserver;
        SingleLocalMap singleLocalMap = new SingleLocalMap(providableModifierLocal);
        if (providableModifierLocal == singleLocalMap.key) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            singleLocalMap.value$delegate.setValue(this);
            this.providedValues = singleLocalMap;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final PathMotion getProvidedValues() {
        return this.providedValues;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(LayoutCoordinates layoutCoordinates) {
        Function1 function1;
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        if (this.isAttached) {
            this.onPositioned.invoke(layoutCoordinates2);
            if (this.isAttached) {
                function1 = (Function1) getCurrent(FocusedBoundsKt.ModifierLocalFocusedBoundsObserver);
            } else {
                function1 = null;
            }
            if (function1 != null) {
                function1.invoke(layoutCoordinates2);
            }
        }
        return Unit.INSTANCE;
    }
}
