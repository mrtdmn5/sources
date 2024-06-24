package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Draggable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$1", f = "Draggable.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DraggableKt$draggable$1 extends SuspendLambda implements Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> {
    public DraggableKt$draggable$1(Continuation<? super DraggableKt$draggable$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Offset offset, Continuation<? super Unit> continuation) {
        long j = offset.packedValue;
        return new DraggableKt$draggable$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
