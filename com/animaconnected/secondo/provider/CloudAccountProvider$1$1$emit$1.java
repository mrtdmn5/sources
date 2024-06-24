package com.animaconnected.secondo.provider;

import com.animaconnected.secondo.provider.CloudAccountProvider;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CloudAccountProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.CloudAccountProvider$1$1", f = "CloudAccountProvider.kt", l = {13, 14, 17}, m = "emit")
/* loaded from: classes3.dex */
public final class CloudAccountProvider$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudAccountProvider.AnonymousClass1.C00411<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CloudAccountProvider$1$1$emit$1(CloudAccountProvider.AnonymousClass1.C00411<? super T> c00411, Continuation<? super CloudAccountProvider$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c00411;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(false, (Continuation<? super Unit>) this);
    }
}
