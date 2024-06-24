package com.animaconnected.watch.device;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GzipBackendImpl.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.GzipBackendImpl", f = "GzipBackendImpl.kt", l = {14}, m = "compress")
/* loaded from: classes3.dex */
public final class GzipBackendImpl$compress$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GzipBackendImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GzipBackendImpl$compress$1(GzipBackendImpl gzipBackendImpl, Continuation<? super GzipBackendImpl$compress$1> continuation) {
        super(continuation);
        this.this$0 = gzipBackendImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.compress(null, this);
    }
}
