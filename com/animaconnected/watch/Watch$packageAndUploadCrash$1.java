package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Watch.kt */
@DebugMetadata(c = "com.animaconnected.watch.Watch", f = "Watch.kt", l = {681, 686}, m = "packageAndUploadCrash")
/* loaded from: classes3.dex */
public final class Watch$packageAndUploadCrash$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Watch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Watch$packageAndUploadCrash$1(Watch watch, Continuation<? super Watch$packageAndUploadCrash$1> continuation) {
        super(continuation);
        this.this$0 = watch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object packageAndUploadCrash;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        packageAndUploadCrash = this.this$0.packageAndUploadCrash(null, null, this);
        return packageAndUploadCrash;
    }
}
