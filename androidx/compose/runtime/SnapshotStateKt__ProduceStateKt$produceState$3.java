package androidx.compose.runtime;

import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProduceState.kt */
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3", f = "ProduceState.kt", l = {R.styleable.AppTheme_stepsHistoryHintRoundnessDetail}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SnapshotStateKt__ProduceStateKt$produceState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<ProduceStateScope<Object>, Continuation<? super Unit>, Object> $producer;
    public final /* synthetic */ MutableState<Object> $result;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateKt__ProduceStateKt$produceState$3(Function2<? super ProduceStateScope<Object>, ? super Continuation<? super Unit>, ? extends Object> function2, MutableState<Object> mutableState, Continuation<? super SnapshotStateKt__ProduceStateKt$produceState$3> continuation) {
        super(2, continuation);
        this.$producer = function2;
        this.$result = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__ProduceStateKt$produceState$3 snapshotStateKt__ProduceStateKt$produceState$3 = new SnapshotStateKt__ProduceStateKt$produceState$3(this.$producer, this.$result, continuation);
        snapshotStateKt__ProduceStateKt$produceState$3.L$0 = obj;
        return snapshotStateKt__ProduceStateKt$produceState$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__ProduceStateKt$produceState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, ((CoroutineScope) this.L$0).getCoroutineContext());
            this.label = 1;
            if (this.$producer.invoke(produceStateScopeImpl, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
