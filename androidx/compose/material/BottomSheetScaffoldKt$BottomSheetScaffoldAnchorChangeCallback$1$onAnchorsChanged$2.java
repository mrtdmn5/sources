package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: BottomSheetScaffold.kt */
@DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2", f = "BottomSheetScaffold.kt", l = {741}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ BottomSheetValue $newTarget;
    public final /* synthetic */ BottomSheetState $state;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2(BottomSheetState bottomSheetState, BottomSheetValue bottomSheetValue, Continuation<? super BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2> continuation) {
        super(2, continuation);
        this.$state = bottomSheetState;
        this.$newTarget = bottomSheetValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2(this.$state, this.$newTarget, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeCallback$1$onAnchorsChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState = this.$state.anchoredDraggableState;
            BottomSheetValue bottomSheetValue = this.$newTarget;
            AnchoredDraggableKt$snapTo$2 anchoredDraggableKt$snapTo$2 = new AnchoredDraggableKt$snapTo$2(bottomSheetValue, null);
            MutatePriority mutatePriority = MutatePriority.Default;
            anchoredDraggableState.getClass();
            Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnchoredDraggableState$doAnchoredDrag$2(bottomSheetValue, anchoredDraggableState, mutatePriority, anchoredDraggableKt$snapTo$2, null), this);
            if (coroutineScope != obj2) {
                coroutineScope = Unit.INSTANCE;
            }
            if (coroutineScope != obj2) {
                coroutineScope = Unit.INSTANCE;
            }
            if (coroutineScope != obj2) {
                coroutineScope = Unit.INSTANCE;
            }
            if (coroutineScope != obj2) {
                coroutineScope = Unit.INSTANCE;
            }
            if (coroutineScope == obj2) {
                return obj2;
            }
        }
        return Unit.INSTANCE;
    }
}
