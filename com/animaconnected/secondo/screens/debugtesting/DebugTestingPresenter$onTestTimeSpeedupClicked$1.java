package com.animaconnected.secondo.screens.debugtesting;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugTestingPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugtesting.DebugTestingPresenter", f = "DebugTestingPresenter.kt", l = {99}, m = "onTestTimeSpeedupClicked")
/* loaded from: classes3.dex */
public final class DebugTestingPresenter$onTestTimeSpeedupClicked$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugTestingPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugTestingPresenter$onTestTimeSpeedupClicked$1(DebugTestingPresenter debugTestingPresenter, Continuation<? super DebugTestingPresenter$onTestTimeSpeedupClicked$1> continuation) {
        super(continuation);
        this.this$0 = debugTestingPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onTestTimeSpeedupClicked(this);
    }
}
