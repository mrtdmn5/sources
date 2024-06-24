package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {210, 223}, m = "removeUnusedFiles")
/* loaded from: classes3.dex */
public final class DisplayWatch$removeUnusedFiles$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$removeUnusedFiles$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$removeUnusedFiles$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object removeUnusedFiles;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        removeUnusedFiles = this.this$0.removeUnusedFiles(null, null, false, this);
        return removeUnusedFiles;
    }
}
