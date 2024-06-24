package com.animaconnected.watch.provider.demo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DemoModeProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoModeProvider$startJob$1", f = "DemoModeProvider.kt", l = {112}, m = "invokeSuspend$initializeDemoMode")
/* loaded from: classes3.dex */
public final class DemoModeProvider$startJob$1$initializeDemoMode$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public DemoModeProvider$startJob$1$initializeDemoMode$1(Continuation<? super DemoModeProvider$startJob$1$initializeDemoMode$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeSuspend$initializeDemoMode;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeSuspend$initializeDemoMode = DemoModeProvider$startJob$1.invokeSuspend$initializeDemoMode(null, null, this);
        return invokeSuspend$initializeDemoMode;
    }
}
