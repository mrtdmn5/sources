package com.animaconnected.secondo.screens.settings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SettingsDebuggingFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment", f = "SettingsDebuggingFragment.kt", l = {101}, m = "startUartDump")
/* loaded from: classes3.dex */
public final class SettingsDebuggingFragment$startUartDump$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsDebuggingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsDebuggingFragment$startUartDump$1(SettingsDebuggingFragment settingsDebuggingFragment, Continuation<? super SettingsDebuggingFragment$startUartDump$1> continuation) {
        super(continuation);
        this.this$0 = settingsDebuggingFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object startUartDump;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        startUartDump = this.this$0.startUartDump(this);
        return startUartDump;
    }
}
