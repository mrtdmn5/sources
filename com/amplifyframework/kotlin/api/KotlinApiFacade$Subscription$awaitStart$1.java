package com.amplifyframework.kotlin.api;

import com.amplifyframework.kotlin.api.KotlinApiFacade;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinApiFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription", f = "KotlinApiFacade.kt", l = {264}, m = "awaitStart$core_kotlin_release")
/* loaded from: classes.dex */
public final class KotlinApiFacade$Subscription$awaitStart$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KotlinApiFacade.Subscription<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinApiFacade$Subscription$awaitStart$1(KotlinApiFacade.Subscription<T> subscription, Continuation<? super KotlinApiFacade$Subscription$awaitStart$1> continuation) {
        super(continuation);
        this.this$0 = subscription;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.awaitStart$core_kotlin_release(this);
    }
}
