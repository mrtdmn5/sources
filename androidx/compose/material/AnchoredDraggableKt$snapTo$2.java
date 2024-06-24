package androidx.compose.material;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: AnchoredDraggable.kt */
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AnchoredDraggableKt$snapTo$2 extends SuspendLambda implements Function3<AnchoredDragScope, Map<Object, ? extends Float>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object $targetValue;
    public /* synthetic */ AnchoredDragScope L$0;
    public /* synthetic */ Map L$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableKt$snapTo$2(Object obj, Continuation<? super AnchoredDraggableKt$snapTo$2> continuation) {
        super(3, continuation);
        this.$targetValue = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(AnchoredDragScope anchoredDragScope, Map<Object, ? extends Float> map, Continuation<? super Unit> continuation) {
        AnchoredDraggableKt$snapTo$2 anchoredDraggableKt$snapTo$2 = new AnchoredDraggableKt$snapTo$2(this.$targetValue, continuation);
        anchoredDraggableKt$snapTo$2.L$0 = anchoredDragScope;
        anchoredDraggableKt$snapTo$2.L$1 = map;
        return anchoredDraggableKt$snapTo$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        AnchoredDragScope anchoredDragScope = this.L$0;
        Float f = (Float) this.L$1.get(this.$targetValue);
        if (f != null) {
            anchoredDragScope.dragTo(f.floatValue(), 0.0f);
        }
        return Unit.INSTANCE;
    }
}
