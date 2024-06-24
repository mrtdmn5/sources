package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatchJvm", f = "DisplayWatch.kt", l = {28, 42, 43, 44, 45}, m = "sendMediaNotification")
/* loaded from: classes3.dex */
public final class DisplayWatchJvm$sendMediaNotification$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    public DisplayWatchJvm$sendMediaNotification$1(Continuation<? super DisplayWatchJvm$sendMediaNotification$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DisplayWatchJvm.sendMediaNotification(null, null, null, this);
    }
}
