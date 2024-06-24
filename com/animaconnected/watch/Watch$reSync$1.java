package com.animaconnected.watch;

import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Watch.kt */
@DebugMetadata(c = "com.animaconnected.watch.Watch$reSync$1", f = "Watch.kt", l = {497}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Watch$reSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Watch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Watch$reSync$1(Watch watch, Continuation<? super Watch$reSync$1> continuation) {
        super(2, continuation);
        this.this$0 = watch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Watch$reSync$1 watch$reSync$1 = new Watch$reSync$1(this.this$0, continuation);
        watch$reSync$1.L$0 = obj;
        return watch$reSync$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception exc;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    exc = e;
                    coroutineScope = coroutineScope2;
                    LogKt.err$default((Object) coroutineScope, this.this$0.getTag$watch_release(), (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.Watch$reSync$1.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "reSync() failed";
                        }
                    }, 4, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                LogKt.debug$default((Object) coroutineScope3, this.this$0.getTag$watch_release(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.Watch$reSync$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "reSync";
                    }
                }, 6, (Object) null);
                Function1<Continuation<? super Unit>, Object> syncSuspend = this.this$0.getSyncSuspend();
                this.L$0 = coroutineScope3;
                this.label = 1;
                if (syncSuspend.invoke(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } catch (Exception e2) {
                coroutineScope = coroutineScope3;
                exc = e2;
                LogKt.err$default((Object) coroutineScope, this.this$0.getTag$watch_release(), (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.Watch$reSync$1.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "reSync() failed";
                    }
                }, 4, (Object) null);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Watch$reSync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
