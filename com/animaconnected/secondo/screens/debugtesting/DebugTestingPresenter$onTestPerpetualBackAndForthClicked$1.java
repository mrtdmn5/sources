package com.animaconnected.secondo.screens.debugtesting;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugTestingPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter", f = "DebugTestingPresenter.kt", l = {50, 51, 63, 64, 65, 69, 70, 71, 72}, m = "onTestPerpetualBackAndForthClicked")
/* loaded from: classes3.dex */
public final class DebugTestingPresenter$onTestPerpetualBackAndForthClicked$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugTestingPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugTestingPresenter$onTestPerpetualBackAndForthClicked$1(DebugTestingPresenter debugTestingPresenter, Continuation<? super DebugTestingPresenter$onTestPerpetualBackAndForthClicked$1> continuation) {
        super(continuation);
        this.this$0 = debugTestingPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onTestPerpetualBackAndForthClicked(this);
    }
}
