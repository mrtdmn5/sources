package com.animaconnected.secondo.screens.debugsettings;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment", f = "DebugSettingsFragment.kt", l = {R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity}, m = "fetchAndSharePostMortem")
/* loaded from: classes3.dex */
public final class DebugSettingsFragment$fetchAndSharePostMortem$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsFragment$fetchAndSharePostMortem$1(DebugSettingsFragment debugSettingsFragment, Continuation<? super DebugSettingsFragment$fetchAndSharePostMortem$1> continuation) {
        super(continuation);
        this.this$0 = debugSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchAndSharePostMortem;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchAndSharePostMortem = this.this$0.fetchAndSharePostMortem(this);
        return fetchAndSharePostMortem;
    }
}
