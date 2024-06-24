package com.animaconnected.watch.device.files;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFileSystem.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem$readFile$2", f = "WatchFileSystem.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFileSystem$readFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WatchFile>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ boolean $editable;
    final /* synthetic */ FileDescriptor $fd;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFileSystem$readFile$2(FileDescriptor fileDescriptor, byte[] bArr, boolean z, Continuation<? super WatchFileSystem$readFile$2> continuation) {
        super(2, continuation);
        this.$fd = fileDescriptor;
        this.$bytes = bArr;
        this.$editable = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFileSystem$readFile$2(this.$fd, this.$bytes, this.$editable, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new WatchFile(this.$fd.getDirectory(), this.$fd.getName(), this.$bytes, this.$editable);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WatchFile> continuation) {
        return ((WatchFileSystem$readFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
