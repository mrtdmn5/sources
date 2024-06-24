package com.animaconnected.secondo.screens.demo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EnableDemoModeBottomDialog.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt", f = "EnableDemoModeBottomDialog.kt", l = {76, 77, 78}, m = "signOutAllReturnFailedServiceName")
/* loaded from: classes3.dex */
public final class EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1(Continuation<? super EnableDemoModeBottomDialogKt$signOutAllReturnFailedServiceName$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object signOutAllReturnFailedServiceName;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        signOutAllReturnFailedServiceName = EnableDemoModeBottomDialogKt.signOutAllReturnFailedServiceName(null, this);
        return signOutAllReturnFailedServiceName;
    }
}
