package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugDisplayFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment", f = "DebugDisplayFragment.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity, R.styleable.AppTheme_stepsHistoryFontDetail}, m = "sendAllData")
/* loaded from: classes3.dex */
public final class DebugDisplayFragment$sendAllData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugDisplayFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayFragment$sendAllData$1(DebugDisplayFragment debugDisplayFragment, Continuation<? super DebugDisplayFragment$sendAllData$1> continuation) {
        super(continuation);
        this.this$0 = debugDisplayFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendAllData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sendAllData = this.this$0.sendAllData(this);
        return sendAllData;
    }
}
