package com.animaconnected.secondo.provider.location;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidLocationBackend.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.location.AndroidLocationBackend", f = "AndroidLocationBackend.kt", l = {251, 277, 277, 277}, m = "getBestLocation")
/* loaded from: classes3.dex */
public final class AndroidLocationBackend$getBestLocation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidLocationBackend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidLocationBackend$getBestLocation$1(AndroidLocationBackend androidLocationBackend, Continuation<? super AndroidLocationBackend$getBestLocation$1> continuation) {
        super(continuation);
        this.this$0 = androidLocationBackend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object bestLocation;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        bestLocation = this.this$0.getBestLocation(null, null, null, null, this);
        return bestLocation;
    }
}
