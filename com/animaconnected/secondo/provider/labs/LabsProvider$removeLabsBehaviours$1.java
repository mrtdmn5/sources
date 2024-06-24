package com.animaconnected.secondo.provider.labs;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LabsProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.labs.LabsProvider", f = "LabsProvider.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail, R.styleable.AppTheme_stepsHistoryFontActivity, R.styleable.AppTheme_stepsHistoryFontDetail, R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity, R.styleable.AppTheme_stepsHistoryGoalLegendColorDetail, R.styleable.AppTheme_stepsHistoryGoalLineColorActivity}, m = "removeLabsBehaviours")
/* loaded from: classes3.dex */
public final class LabsProvider$removeLabsBehaviours$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LabsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabsProvider$removeLabsBehaviours$1(LabsProvider labsProvider, Continuation<? super LabsProvider$removeLabsBehaviours$1> continuation) {
        super(continuation);
        this.this$0 = labsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object removeLabsBehaviours;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        removeLabsBehaviours = this.this$0.removeLabsBehaviours(this);
        return removeLabsBehaviours;
    }
}
