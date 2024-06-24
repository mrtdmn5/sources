package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.files.WatchFile;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AlarmsApp.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.alarms.AlarmsApp", f = "AlarmsApp.kt", l = {39}, m = "onWatchFileChange$suspendImpl")
/* loaded from: classes3.dex */
public final class AlarmsApp$onWatchFileChange$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlarmsApp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlarmsApp$onWatchFileChange$1(AlarmsApp alarmsApp, Continuation<? super AlarmsApp$onWatchFileChange$1> continuation) {
        super(continuation);
        this.this$0 = alarmsApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AlarmsApp.onWatchFileChange$suspendImpl(this.this$0, (WatchFile) null, (DisplayWatch) null, (Continuation<? super Unit>) this);
    }
}
