package com.animaconnected.secondo.screens.watchupdate;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchDfuUpdatePresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter", f = "WatchDfuUpdatePresenter.kt", l = {71, 76, 77}, m = "updateButtonClicked")
/* loaded from: classes3.dex */
public final class WatchDfuUpdatePresenter$updateButtonClicked$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchDfuUpdatePresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchDfuUpdatePresenter$updateButtonClicked$1(WatchDfuUpdatePresenter watchDfuUpdatePresenter, Continuation<? super WatchDfuUpdatePresenter$updateButtonClicked$1> continuation) {
        super(continuation);
        this.this$0 = watchDfuUpdatePresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateButtonClicked(this);
    }
}
