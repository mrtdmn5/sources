package com.animaconnected.watch.device.files;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WatchFileSystem.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem", f = "WatchFileSystem.kt", l = {288, 290, 295}, m = "getDirectoryRecursive")
/* loaded from: classes3.dex */
public final class WatchFileSystem$getDirectoryRecursive$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchFileSystem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFileSystem$getDirectoryRecursive$1(WatchFileSystem watchFileSystem, Continuation<? super WatchFileSystem$getDirectoryRecursive$1> continuation) {
        super(continuation);
        this.this$0 = watchFileSystem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDirectoryRecursive(null, null, this);
    }
}
