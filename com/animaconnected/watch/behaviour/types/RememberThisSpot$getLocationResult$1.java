package com.animaconnected.watch.behaviour.types;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RememberThisSpot.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.RememberThisSpot", f = "RememberThisSpot.kt", l = {R.styleable.AppTheme_stepsHistoryColumnColorDetail}, m = "getLocationResult")
/* loaded from: classes3.dex */
public final class RememberThisSpot$getLocationResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RememberThisSpot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberThisSpot$getLocationResult$1(RememberThisSpot rememberThisSpot, Continuation<? super RememberThisSpot$getLocationResult$1> continuation) {
        super(continuation);
        this.this$0 = rememberThisSpot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object locationResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        locationResult = this.this$0.getLocationResult(this);
        return locationResult;
    }
}
