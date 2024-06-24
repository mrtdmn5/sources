package com.animaconnected.secondo.screens;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MainActivity.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity", f = "MainActivity.kt", l = {868, 869}, m = "updateWatchAreaViews")
/* loaded from: classes3.dex */
public final class MainActivity$updateWatchAreaViews$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$updateWatchAreaViews$2(MainActivity mainActivity, Continuation<? super MainActivity$updateWatchAreaViews$2> continuation) {
        super(continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateWatchAreaViews(0, this);
    }
}
