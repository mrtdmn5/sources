package io.ktor.utils.io.jvm.javaio;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: Blocking.kt */
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.BlockingAdapter$block$1", f = "Blocking.kt", l = {186}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BlockingAdapter$block$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ BlockingAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingAdapter$block$1(BlockingAdapter blockingAdapter, Continuation<? super BlockingAdapter$block$1> continuation) {
        super(1, continuation);
        this.this$0 = blockingAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BlockingAdapter$block$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BlockingAdapter$block$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            this.label = 1;
            if (this.this$0.loop(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
