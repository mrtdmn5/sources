package com.animaconnected.secondo.behaviour.distress.detail;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DistressPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter", f = "DistressPresenter.kt", l = {R.styleable.AppTheme_stepsHistoryLineLegendColorActivity}, m = "cancelInvitation")
/* loaded from: classes3.dex */
public final class DistressPresenter$cancelInvitation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DistressPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressPresenter$cancelInvitation$1(DistressPresenter distressPresenter, Continuation<? super DistressPresenter$cancelInvitation$1> continuation) {
        super(continuation);
        this.this$0 = distressPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cancelInvitation(this);
    }
}
