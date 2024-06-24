package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugSettingsPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter", f = "DebugSettingsPresenter.kt", l = {218}, m = "refreshAmplifySession")
/* loaded from: classes3.dex */
public final class DebugSettingsPresenter$refreshAmplifySession$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugSettingsPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsPresenter$refreshAmplifySession$1(DebugSettingsPresenter debugSettingsPresenter, Continuation<? super DebugSettingsPresenter$refreshAmplifySession$1> continuation) {
        super(continuation);
        this.this$0 = debugSettingsPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshAmplifySession(this);
    }
}
