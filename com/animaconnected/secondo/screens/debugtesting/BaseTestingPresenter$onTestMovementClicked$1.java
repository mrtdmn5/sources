package com.animaconnected.secondo.screens.debugtesting;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BaseTestingPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter", f = "BaseTestingPresenter.kt", l = {76, 77, 78}, m = "onTestMovementClicked")
/* loaded from: classes3.dex */
public final class BaseTestingPresenter$onTestMovementClicked$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseTestingPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTestingPresenter$onTestMovementClicked$1(BaseTestingPresenter baseTestingPresenter, Continuation<? super BaseTestingPresenter$onTestMovementClicked$1> continuation) {
        super(continuation);
        this.this$0 = baseTestingPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onTestMovementClicked(this);
    }
}
