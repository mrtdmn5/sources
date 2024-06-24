package com.amplifyframework.kotlin.datastore;

import com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinDataStoreFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation", f = "KotlinDataStoreFacade.kt", l = {219}, m = "waitForStart$core_kotlin_release")
/* loaded from: classes.dex */
public final class KotlinDataStoreFacade$Observation$waitForStart$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KotlinDataStoreFacade.Observation<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinDataStoreFacade$Observation$waitForStart$1(KotlinDataStoreFacade.Observation<T> observation, Continuation<? super KotlinDataStoreFacade$Observation$waitForStart$1> continuation) {
        super(continuation);
        this.this$0 = observation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitForStart$core_kotlin_release(this);
    }
}
