package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {760, 761}, m = "onFileChanged-b1QGwmY$watch_release")
/* loaded from: classes3.dex */
public final class DisplayWatch$onFileChanged$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$onFileChanged$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$onFileChanged$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1045onFileChangedb1QGwmY$watch_release(0, 0, 0, this);
    }
}
