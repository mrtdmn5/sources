package com.animaconnected.watch.device;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MsgPackWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.MsgPackWatch", f = "MsgPackWatch.kt", l = {1222}, m = "writeMediaNotification-eH_QyT8")
/* loaded from: classes3.dex */
public final class MsgPackWatch$writeMediaNotification$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MsgPackWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgPackWatch$writeMediaNotification$1(MsgPackWatch msgPackWatch, Continuation<? super MsgPackWatch$writeMediaNotification$1> continuation) {
        super(continuation);
        this.this$0 = msgPackWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1080writeMediaNotificationeH_QyT8 = this.this$0.mo1080writeMediaNotificationeH_QyT8(null, null, null, 0, 0, 0, 0, this);
        if (mo1080writeMediaNotificationeH_QyT8 == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return mo1080writeMediaNotificationeH_QyT8;
        }
        return new Result(mo1080writeMediaNotificationeH_QyT8);
    }
}
