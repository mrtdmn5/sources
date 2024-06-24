package com.animaconnected.watch.behaviour.distress;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.display.RemoteAppImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Distress.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.distress.Distress$onStateChanged$2", f = "Distress.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Distress$onStateChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Distress this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Distress$onStateChanged$2(Distress distress, Continuation<? super Distress$onStateChanged$2> continuation) {
        super(2, continuation);
        this.this$0 = distress;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Distress$onStateChanged$2(this.this$0, continuation);
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
            Distress distress = this.this$0;
            this.label = 1;
            if (RemoteAppImpl.changeView$default(distress, 1, null, this, 2, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Distress$onStateChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
