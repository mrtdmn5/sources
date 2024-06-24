package com.animaconnected.watch;

import com.animaconnected.watch.display.PascalDisplay;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {366, PascalDisplay.right, 372, 380, 387, 387, 390, 395}, m = "syncApp")
/* loaded from: classes3.dex */
public final class DisplayWatch$syncApp$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$syncApp$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$syncApp$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object syncApp;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        syncApp = this.this$0.syncApp(null, null, this);
        return syncApp;
    }
}
