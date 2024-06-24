package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.modifier.SingleLocalMap;
import androidx.transition.PathMotion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: BringIntoViewResponder.kt */
/* loaded from: classes.dex */
public final class BringIntoViewResponderNode extends BringIntoViewChildNode implements BringIntoViewParent {
    public final SingleLocalMap providedValues;
    public BringIntoViewResponder responder;

    public BringIntoViewResponderNode(BringIntoViewResponder responder) {
        boolean z;
        Intrinsics.checkNotNullParameter(responder, "responder");
        this.responder = responder;
        ProvidableModifierLocal<BringIntoViewParent> providableModifierLocal = BringIntoViewKt.ModifierLocalBringIntoViewParent;
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

    public static final Rect access$bringChildIntoView$localRect(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0 function0) {
        Rect rect;
        LayoutCoordinates layoutCoordinates2 = bringIntoViewResponderNode.getLayoutCoordinates();
        if (layoutCoordinates2 == null) {
            return null;
        }
        if (!layoutCoordinates.isAttached()) {
            layoutCoordinates = null;
        }
        if (layoutCoordinates == null || (rect = (Rect) function0.invoke()) == null) {
            return null;
        }
        Rect localBoundingBoxOf = layoutCoordinates2.localBoundingBoxOf(layoutCoordinates, false);
        return rect.m270translatek4lQ0M(OffsetKt.Offset(localBoundingBoxOf.left, localBoundingBoxOf.top));
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewParent
    public final Object bringChildIntoView(final LayoutCoordinates layoutCoordinates, final Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new BringIntoViewResponderNode$bringChildIntoView$2(this, layoutCoordinates, function0, new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$parentRect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                BringIntoViewResponderNode bringIntoViewResponderNode = BringIntoViewResponderNode.this;
                Rect access$bringChildIntoView$localRect = BringIntoViewResponderNode.access$bringChildIntoView$localRect(bringIntoViewResponderNode, layoutCoordinates, function0);
                if (access$bringChildIntoView$localRect != null) {
                    return bringIntoViewResponderNode.responder.calculateRectForParent(access$bringChildIntoView$localRect);
                }
                return null;
            }
        }, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final PathMotion getProvidedValues() {
        return this.providedValues;
    }
}
