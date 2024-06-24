package com.animaconnected.watch.device;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {1212}, m = "writeNotification-hUnOzRk")
/* loaded from: classes3.dex */
public final class MsgPackWatch$writeNotification$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$writeNotification$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$writeNotification$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1081writeNotificationhUnOzRk = this.this$0.mo1081writeNotificationhUnOzRk(0, null, null, null, null, this);
        if (mo1081writeNotificationhUnOzRk == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return mo1081writeNotificationhUnOzRk;
        }
        return new Result(mo1081writeNotificationhUnOzRk);
    }
}
