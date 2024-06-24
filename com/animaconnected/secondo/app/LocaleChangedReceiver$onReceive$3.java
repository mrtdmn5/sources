package com.animaconnected.secondo.app;

import com.animaconnected.secondo.utils.AmplifyApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LocaleChangedReceiver.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.LocaleChangedReceiver$onReceive$3", f = "LocaleChangedReceiver.kt", l = {30}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LocaleChangedReceiver$onReceive$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public LocaleChangedReceiver$onReceive$3(Continuation<? super LocaleChangedReceiver$onReceive$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocaleChangedReceiver$onReceive$3(continuation);
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
            AmplifyApi amplifyApi = AmplifyApi.INSTANCE;
            this.label = 1;
            if (amplifyApi.updateUserLocale(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocaleChangedReceiver$onReceive$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
