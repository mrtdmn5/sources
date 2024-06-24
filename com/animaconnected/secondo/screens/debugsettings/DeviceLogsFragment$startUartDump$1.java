package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DeviceLogsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment", f = "DeviceLogsFragment.kt", l = {66}, m = "startUartDump")
/* loaded from: classes3.dex */
public final class DeviceLogsFragment$startUartDump$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceLogsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceLogsFragment$startUartDump$1(DeviceLogsFragment deviceLogsFragment, Continuation<? super DeviceLogsFragment$startUartDump$1> continuation) {
        super(continuation);
        this.this$0 = deviceLogsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startUartDump(this);
    }
}
