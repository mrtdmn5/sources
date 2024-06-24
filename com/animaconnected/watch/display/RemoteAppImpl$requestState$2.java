package com.animaconnected.watch.display;

import com.animaconnected.watch.DisplayWatch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RemoteAppImpl.kt */
@DebugMetadata(c = "com.animaconnected.watch.display.RemoteAppImpl$requestState$2", f = "RemoteAppImpl.kt", l = {61}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RemoteAppImpl$requestState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VisibilityState $state;
    final /* synthetic */ DisplayWatch $watch;
    int label;
    final /* synthetic */ RemoteAppImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteAppImpl$requestState$2(DisplayWatch displayWatch, RemoteAppImpl remoteAppImpl, VisibilityState visibilityState, Continuation<? super RemoteAppImpl$requestState$2> continuation) {
        super(2, continuation);
        this.$watch = displayWatch;
        this.this$0 = remoteAppImpl;
        this.$state = visibilityState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteAppImpl$requestState$2(this.$watch, this.this$0, this.$state, continuation);
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
            DisplayWatch displayWatch = this.$watch;
            AppId id = this.this$0.getId();
            VisibilityState visibilityState = this.$state;
            this.label = 1;
            if (displayWatch.requestAppState(id, visibilityState, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RemoteAppImpl$requestState$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
