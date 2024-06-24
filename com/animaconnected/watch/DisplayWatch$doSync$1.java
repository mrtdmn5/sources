package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {133, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryFontActivity, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryFontDetail, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryGoalLegendColorDetail, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryGoalLineColorActivity, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryGoalLineColorDetail, com.animaconnected.secondo.R.styleable.AppTheme_tabTextFont, com.animaconnected.secondo.R.styleable.AppTheme_tabTextSelectedColor, com.animaconnected.secondo.R.styleable.AppTheme_tabTextStyle, com.animaconnected.secondo.R.styleable.AppTheme_workoutDetailColorBackground}, m = "doSync")
/* loaded from: classes3.dex */
public final class DisplayWatch$doSync$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$doSync$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$doSync$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doSync(false, this);
    }
}
