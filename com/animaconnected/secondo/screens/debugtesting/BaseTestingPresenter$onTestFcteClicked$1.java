package com.animaconnected.secondo.screens.debugtesting;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BaseTestingPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugtesting.BaseTestingPresenter", f = "BaseTestingPresenter.kt", l = {115}, m = "onTestFcteClicked")
/* loaded from: classes3.dex */
public final class BaseTestingPresenter$onTestFcteClicked$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseTestingPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTestingPresenter$onTestFcteClicked$1(BaseTestingPresenter baseTestingPresenter, Continuation<? super BaseTestingPresenter$onTestFcteClicked$1> continuation) {
        super(continuation);
        this.this$0 = baseTestingPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onTestFcteClicked(this);
    }
}
