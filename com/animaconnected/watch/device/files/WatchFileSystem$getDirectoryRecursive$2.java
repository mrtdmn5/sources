package com.animaconnected.watch.device.files;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFileSystem.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem$getDirectoryRecursive$2", f = "WatchFileSystem.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFileSystem$getDirectoryRecursive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Directory>, Object> {
    final /* synthetic */ DirectoryDescriptor $dir;
    final /* synthetic */ List<FileEntry> $entries;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WatchFileSystem$getDirectoryRecursive$2(DirectoryDescriptor directoryDescriptor, List<? extends FileEntry> list, Continuation<? super WatchFileSystem$getDirectoryRecursive$2> continuation) {
        super(2, continuation);
        this.$dir = directoryDescriptor;
        this.$entries = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFileSystem$getDirectoryRecursive$2(this.$dir, this.$entries, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new Directory(this.$dir.getPath(), this.$dir.getName(), this.$entries);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Directory> continuation) {
        return ((WatchFileSystem$getDirectoryRecursive$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
