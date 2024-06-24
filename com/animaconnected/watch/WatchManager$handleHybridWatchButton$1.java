package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager", f = "WatchManager.kt", l = {531, 532, 537, 546}, m = "handleHybridWatchButton")
/* loaded from: classes3.dex */
public final class WatchManager$handleHybridWatchButton$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$handleHybridWatchButton$1(WatchManager watchManager, Continuation<? super WatchManager$handleHybridWatchButton$1> continuation) {
        super(continuation);
        this.this$0 = watchManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleHybridWatchButton;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleHybridWatchButton = this.this$0.handleHybridWatchButton(null, null, this);
        return handleHybridWatchButton;
    }
}
