package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Watch.kt */
@DebugMetadata(c = "com.animaconnected.watch.Watch", f = "Watch.kt", l = {516}, m = "syncVibratorConfig")
/* loaded from: classes3.dex */
public final class Watch$syncVibratorConfig$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Watch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Watch$syncVibratorConfig$1(Watch watch, Continuation<? super Watch$syncVibratorConfig$1> continuation) {
        super(continuation);
        this.this$0 = watch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object syncVibratorConfig;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        syncVibratorConfig = this.this$0.syncVibratorConfig(this);
        return syncVibratorConfig;
    }
}
