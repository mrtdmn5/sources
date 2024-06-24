package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.Alert;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ifttt.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.Ifttt$sendTrigger$1$1$viewIndex$1", f = "Ifttt.kt", l = {58}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Ifttt$sendTrigger$1$1$viewIndex$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Ifttt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ifttt$sendTrigger$1$1$viewIndex$1(Ifttt ifttt, Continuation<? super Ifttt$sendTrigger$1$1$viewIndex$1> continuation) {
        super(2, continuation);
        this.this$0 = ifttt;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Ifttt$sendTrigger$1$1$viewIndex$1(this.this$0, continuation);
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
            DisplayWatch displayWatch$watch_release = this.this$0.getDisplayWatch$watch_release();
            if (displayWatch$watch_release != null) {
                int id = Alert.Confirm.getId();
                this.label = 1;
                if (displayWatch$watch_release.alert(id, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Ifttt$sendTrigger$1$1$viewIndex$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
