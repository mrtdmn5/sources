package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager", f = "WatchManager.kt", l = {560}, m = "notifyMagicKeyIfRunning")
/* loaded from: classes3.dex */
public final class WatchManager$notifyMagicKeyIfRunning$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$notifyMagicKeyIfRunning$1(WatchManager watchManager, Continuation<? super WatchManager$notifyMagicKeyIfRunning$1> continuation) {
        super(continuation);
        this.this$0 = watchManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object notifyMagicKeyIfRunning;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        notifyMagicKeyIfRunning = this.this$0.notifyMagicKeyIfRunning(null, null, this);
        return notifyMagicKeyIfRunning;
    }
}
