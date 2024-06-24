package com.animaconnected.secondo.behaviour.distress.service;

import com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1;
import com.animaconnected.watch.location.LocationResult;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DistressService.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1", f = "DistressService.kt", l = {62}, m = "emit")
/* loaded from: classes3.dex */
public final class DistressService$startLocationUpdates$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DistressService$startLocationUpdates$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DistressService$startLocationUpdates$1$1$emit$1(DistressService$startLocationUpdates$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super DistressService$startLocationUpdates$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((LocationResult) null, (Continuation<? super Unit>) this);
    }
}
