package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HeartRateRefFileSaver.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.HeartRateRefFileSaver", f = "HeartRateRefFileSaver.kt", l = {46, 49, 62}, m = "stop")
/* loaded from: classes3.dex */
public final class HeartRateRefFileSaver$stop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HeartRateRefFileSaver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeartRateRefFileSaver$stop$1(HeartRateRefFileSaver heartRateRefFileSaver, Continuation<? super HeartRateRefFileSaver$stop$1> continuation) {
        super(continuation);
        this.this$0 = heartRateRefFileSaver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.stop(this);
    }
}
