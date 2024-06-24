package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: SelectionController.kt */
@DebugMetadata(c = "androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$1", f = "SelectionController.kt", l = {256}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SelectionControllerKt$makeSelectionModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 $longPressDragObserver;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionControllerKt$makeSelectionModifier$1(SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 selectionControllerKt$makeSelectionModifier$longPressDragObserver$1, Continuation<? super SelectionControllerKt$makeSelectionModifier$1> continuation) {
        super(2, continuation);
        this.$longPressDragObserver = selectionControllerKt$makeSelectionModifier$longPressDragObserver$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionControllerKt$makeSelectionModifier$1 selectionControllerKt$makeSelectionModifier$1 = new SelectionControllerKt$makeSelectionModifier$1(this.$longPressDragObserver, continuation);
        selectionControllerKt$makeSelectionModifier$1.L$0 = obj;
        return selectionControllerKt$makeSelectionModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((SelectionControllerKt$makeSelectionModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            this.label = 1;
            if (LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver(pointerInputScope, this.$longPressDragObserver, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
