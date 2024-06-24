package com.animaconnected.watch;

import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager", f = "WatchManager.kt", l = {TipsAndTricksConstants.FIND_PHONE_PRIORITY, 702}, m = "setCurrentWatch")
/* loaded from: classes3.dex */
public final class WatchManager$setCurrentWatch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$setCurrentWatch$1(WatchManager watchManager, Continuation<? super WatchManager$setCurrentWatch$1> continuation) {
        super(continuation);
        this.this$0 = watchManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setCurrentWatch(null, this);
    }
}
