package com.amplifyframework.kotlin.notifications.pushnotifications;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinPushFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade", f = "KotlinPushFacade.kt", l = {70}, m = "handleNotificationReceived")
/* loaded from: classes.dex */
public final class KotlinPushFacade$handleNotificationReceived$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KotlinPushFacade this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinPushFacade$handleNotificationReceived$1(KotlinPushFacade kotlinPushFacade, Continuation<? super KotlinPushFacade$handleNotificationReceived$1> continuation) {
        super(continuation);
        this.this$0 = kotlinPushFacade;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleNotificationReceived(null, this);
    }
}
