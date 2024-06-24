package com.amplifyframework.kotlin.api;

import com.amplifyframework.kotlin.api.KotlinApiFacade;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KotlinApiFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$5", f = "KotlinApiFacade.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class KotlinApiFacade$Subscription$awaitStart$5<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KotlinApiFacade.Subscription<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinApiFacade$Subscription$awaitStart$5(KotlinApiFacade.Subscription<T> subscription, Continuation<? super KotlinApiFacade$Subscription$awaitStart$5> continuation) {
        super(3, continuation);
        this.this$0 = subscription;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getCancelable$core_kotlin_release().cancel();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return new KotlinApiFacade$Subscription$awaitStart$5(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
