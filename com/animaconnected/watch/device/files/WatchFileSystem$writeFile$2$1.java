package com.animaconnected.watch.device.files;

import com.animaconnected.watch.device.FileResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFileSystem.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem$writeFile$2$1", f = "WatchFileSystem.kt", l = {114, 119, 122}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFileSystem$writeFile$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileResult>, Object> {
    final /* synthetic */ WatchFile $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ WatchFileSystem this$0;

    /* compiled from: WatchFileSystem.kt */
    @DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem$writeFile$2$1$3", f = "WatchFileSystem.kt", l = {122}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.device.files.WatchFileSystem$writeFile$2$1$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileResult>, Object> {
        final /* synthetic */ CompletableDeferred<FileResult> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(CompletableDeferred<FileResult> completableDeferred, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$deferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$deferred, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CompletableDeferred<FileResult> completableDeferred = this.$deferred;
                this.label = 1;
                obj = completableDeferred.await(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FileResult> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFileSystem$writeFile$2$1(WatchFileSystem watchFileSystem, WatchFile watchFile, Continuation<? super WatchFileSystem$writeFile$2$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFileSystem;
        this.$file = watchFile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFileSystem$writeFile$2$1 watchFileSystem$writeFile$2$1 = new WatchFileSystem$writeFile$2$1(this.this$0, this.$file, continuation);
        watchFileSystem$writeFile$2$1.L$0 = obj;
        return watchFileSystem$writeFile$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x013a, code lost:            r15 = r15;     */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x01e6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:487), block:B:95:0x01e6 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1 A[Catch: Exception -> 0x0140, TimeoutCancellationException -> 0x0149, TryCatch #9 {TimeoutCancellationException -> 0x0149, Exception -> 0x0140, blocks: (B:53:0x00cb, B:55:0x00d1, B:57:0x00de, B:61:0x00e5), top: B:52:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x011e -> B:46:0x0122). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.files.WatchFileSystem$writeFile$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FileResult> continuation) {
        return ((WatchFileSystem$writeFile$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
