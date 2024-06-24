package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DisplayWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.DisplayWatch", f = "DisplayWatch.kt", l = {706, 709, 736, 737}, m = "initEditableFiles")
/* loaded from: classes3.dex */
public final class DisplayWatch$initEditableFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DisplayWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayWatch$initEditableFiles$1(DisplayWatch displayWatch, Continuation<? super DisplayWatch$initEditableFiles$1> continuation) {
        super(continuation);
        this.this$0 = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object initEditableFiles;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        initEditableFiles = this.this$0.initEditableFiles(null, this);
        return initEditableFiles;
    }
}
