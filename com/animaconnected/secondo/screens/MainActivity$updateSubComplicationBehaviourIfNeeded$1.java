package com.animaconnected.secondo.screens;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MainActivity.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity", f = "MainActivity.kt", l = {783, 785}, m = "updateSubComplicationBehaviourIfNeeded")
/* loaded from: classes3.dex */
public final class MainActivity$updateSubComplicationBehaviourIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$updateSubComplicationBehaviourIfNeeded$1(MainActivity mainActivity, Continuation<? super MainActivity$updateSubComplicationBehaviourIfNeeded$1> continuation) {
        super(continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateSubComplicationBehaviourIfNeeded;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateSubComplicationBehaviourIfNeeded = this.this$0.updateSubComplicationBehaviourIfNeeded(null, this);
        return updateSubComplicationBehaviourIfNeeded;
    }
}
