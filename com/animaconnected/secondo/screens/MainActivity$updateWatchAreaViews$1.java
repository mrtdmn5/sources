package com.animaconnected.secondo.screens;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MainActivity.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity", f = "MainActivity.kt", l = {841, 842}, m = "updateWatchAreaViews")
/* loaded from: classes3.dex */
public final class MainActivity$updateWatchAreaViews$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$updateWatchAreaViews$1(MainActivity mainActivity, Continuation<? super MainActivity$updateWatchAreaViews$1> continuation) {
        super(continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateWatchAreaViews;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateWatchAreaViews = this.this$0.updateWatchAreaViews(null, false, this);
        return updateWatchAreaViews;
    }
}
