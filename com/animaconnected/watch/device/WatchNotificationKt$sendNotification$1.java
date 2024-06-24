package com.animaconnected.watch.device;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchNotification.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.WatchNotificationKt", f = "WatchNotification.kt", l = {100, 32, 38, 43, 45, 47}, m = "sendNotification")
/* loaded from: classes3.dex */
public final class WatchNotificationKt$sendNotification$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    public WatchNotificationKt$sendNotification$1(Continuation<? super WatchNotificationKt$sendNotification$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WatchNotificationKt.sendNotification(null, null, this);
    }
}
