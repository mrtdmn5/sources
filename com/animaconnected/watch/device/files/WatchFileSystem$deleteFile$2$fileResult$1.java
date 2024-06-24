package com.animaconnected.watch.device.files;

import com.animaconnected.secondo.R;
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
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2$fileResult$1", f = "WatchFileSystem.kt", l = {R.styleable.AppTheme_stepsHistoryHintBackgroundColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFileSystem$deleteFile$2$fileResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileResult>, Object> {
    final /* synthetic */ CompletableDeferred<FileResult> $deferred;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFileSystem$deleteFile$2$fileResult$1(CompletableDeferred<FileResult> completableDeferred, Continuation<? super WatchFileSystem$deleteFile$2$fileResult$1> continuation) {
        super(2, continuation);
        this.$deferred = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFileSystem$deleteFile$2$fileResult$1(this.$deferred, continuation);
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
        return ((WatchFileSystem$deleteFile$2$fileResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
