package com.animaconnected.secondo.screens.demo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EnableDemoModeBottomDialog.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt", f = "EnableDemoModeBottomDialog.kt", l = {114, 115, 116}, m = "ensureSignedOutFromCloud")
/* loaded from: classes3.dex */
public final class EnableDemoModeBottomDialogKt$ensureSignedOutFromCloud$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public EnableDemoModeBottomDialogKt$ensureSignedOutFromCloud$1(Continuation<? super EnableDemoModeBottomDialogKt$ensureSignedOutFromCloud$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object ensureSignedOutFromCloud;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ensureSignedOutFromCloud = EnableDemoModeBottomDialogKt.ensureSignedOutFromCloud(null, this);
        return ensureSignedOutFromCloud;
    }
}
