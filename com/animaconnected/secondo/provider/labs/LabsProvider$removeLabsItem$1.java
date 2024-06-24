package com.animaconnected.secondo.provider.labs;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LabsProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.labs.LabsProvider", f = "LabsProvider.kt", l = {R.styleable.AppTheme_stepsHistoryLegendColorDetail, R.styleable.AppTheme_stepsHistoryLineColorDetail}, m = "removeLabsItem")
/* loaded from: classes3.dex */
public final class LabsProvider$removeLabsItem$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LabsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabsProvider$removeLabsItem$1(LabsProvider labsProvider, Continuation<? super LabsProvider$removeLabsItem$1> continuation) {
        super(continuation);
        this.this$0 = labsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object removeLabsItem;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        removeLabsItem = this.this$0.removeLabsItem(null, this);
        return removeLabsItem;
    }
}
