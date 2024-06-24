package com.animaconnected.secondo.screens.settings.displaynotifications;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayNotificationViewModel.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel", f = "DisplayNotificationViewModel.kt", l = {64}, m = "setAllEnabled")
/* loaded from: classes3.dex */
public final class DisplayNotificationViewModel$setAllEnabled$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayNotificationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayNotificationViewModel$setAllEnabled$1(DisplayNotificationViewModel displayNotificationViewModel, Continuation<? super DisplayNotificationViewModel$setAllEnabled$1> continuation) {
        super(continuation);
        this.this$0 = displayNotificationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setAllEnabled(false, this);
    }
}
