package com.animaconnected.watch.device.files;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchFileSystem.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem", f = "WatchFileSystem.kt", l = {272}, m = "readFolder")
/* loaded from: classes3.dex */
public final class WatchFileSystem$readFolder$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchFileSystem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFileSystem$readFolder$1(WatchFileSystem watchFileSystem, Continuation<? super WatchFileSystem$readFolder$1> continuation) {
        super(continuation);
        this.this$0 = watchFileSystem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readFolder(null, this);
    }
}
