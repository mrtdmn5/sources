package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$NoPressGesture$1;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
public final class ClickablePointerInputNode extends AbstractClickablePointerInputNode {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickablePointerInputNode(boolean z, MutableInteractionSource interactionSource, Function0<Unit> onClick, AbstractClickableNode.InteractionData interactionData) {
        super(z, interactionSource, onClick, interactionData);
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(interactionData, "interactionData");
    }

    @Override // androidx.compose.foundation.AbstractClickablePointerInputNode
    public final Object pointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        long mo416getSizeYbymL2g = pointerInputScope.mo416getSizeYbymL2g();
        long IntOffset = IntOffsetKt.IntOffset(((int) (mo416getSizeYbymL2g >> 32)) / 2, IntSize.m593getHeightimpl(mo416getSizeYbymL2g) / 2);
        this.interactionData.centreOffset = OffsetKt.Offset((int) (IntOffset >> 32), IntOffset.m590getYimpl(IntOffset));
        ClickablePointerInputNode$pointerInput$2 clickablePointerInputNode$pointerInput$2 = new ClickablePointerInputNode$pointerInput$2(this, null);
        Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.ClickablePointerInputNode$pointerInput$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Offset offset) {
                long j = offset.packedValue;
                ClickablePointerInputNode clickablePointerInputNode = ClickablePointerInputNode.this;
                if (clickablePointerInputNode.enabled) {
                    clickablePointerInputNode.onClick.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        TapGestureDetectorKt$NoPressGesture$1 tapGestureDetectorKt$NoPressGesture$1 = TapGestureDetectorKt.NoPressGesture;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapAndPress$2(pointerInputScope, clickablePointerInputNode$pointerInput$2, function1, new PressGestureScopeImpl(pointerInputScope), null), continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (coroutineScope != coroutineSingletons) {
            coroutineScope = Unit.INSTANCE;
        }
        if (coroutineScope == coroutineSingletons) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
