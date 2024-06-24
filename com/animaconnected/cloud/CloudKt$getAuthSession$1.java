package com.animaconnected.cloud;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Cloud.kt */
@DebugMetadata(c = "com.animaconnected.cloud.CloudKt", f = "Cloud.kt", l = {245, 257}, m = "getAuthSession")
/* loaded from: classes.dex */
public final class CloudKt$getAuthSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public CloudKt$getAuthSession$1(Continuation<? super CloudKt$getAuthSession$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CloudKt.getAuthSession(null, this);
    }
}
