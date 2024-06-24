package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugNotificationsFragment", f = "DebugNotificationsFragment.kt", l = {196}, m = "removeNotification")
/* loaded from: classes3.dex */
public final class DebugNotificationsFragment$removeNotification$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugNotificationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugNotificationsFragment$removeNotification$1(DebugNotificationsFragment debugNotificationsFragment, Continuation<? super DebugNotificationsFragment$removeNotification$1> continuation) {
        super(continuation);
        this.this$0 = debugNotificationsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object removeNotification;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        removeNotification = this.this$0.removeNotification(null, this);
        return removeNotification;
    }
}
