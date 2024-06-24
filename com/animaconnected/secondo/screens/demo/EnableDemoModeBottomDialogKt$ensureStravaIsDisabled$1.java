package com.animaconnected.secondo.screens.demo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EnableDemoModeBottomDialog.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt", f = "EnableDemoModeBottomDialog.kt", l = {98}, m = "ensureStravaIsDisabled")
/* loaded from: classes3.dex */
public final class EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1(Continuation<? super EnableDemoModeBottomDialogKt$ensureStravaIsDisabled$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object ensureStravaIsDisabled;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ensureStravaIsDisabled = EnableDemoModeBottomDialogKt.ensureStravaIsDisabled(this);
        return ensureStravaIsDisabled;
    }
}
