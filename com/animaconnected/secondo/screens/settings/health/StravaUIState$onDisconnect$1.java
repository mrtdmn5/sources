package com.animaconnected.secondo.screens.settings.health;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StravaUIState.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.StravaUIState", f = "StravaUIState.kt", l = {58}, m = "onDisconnect")
/* loaded from: classes3.dex */
public final class StravaUIState$onDisconnect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StravaUIState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StravaUIState$onDisconnect$1(StravaUIState stravaUIState, Continuation<? super StravaUIState$onDisconnect$1> continuation) {
        super(continuation);
        this.this$0 = stravaUIState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onDisconnect(this);
    }
}
