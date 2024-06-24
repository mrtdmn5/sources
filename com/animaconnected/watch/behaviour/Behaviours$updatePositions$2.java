package com.animaconnected.watch.behaviour;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.files.WatchFileSystem;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Behaviours.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.Behaviours$updatePositions$2", f = "Behaviours.kt", l = {317}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Behaviours$updatePositions$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchFileSystem $fs;
    final /* synthetic */ Watch $watch;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Behaviours$updatePositions$2(Watch watch, WatchFileSystem watchFileSystem, Continuation<? super Behaviours$updatePositions$2> continuation) {
        super(2, continuation);
        this.$watch = watch;
        this.$fs = watchFileSystem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Behaviours$updatePositions$2(this.$watch, this.$fs, continuation);
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
            DisplayWatch displayWatch = (DisplayWatch) this.$watch;
            WatchFileSystem watchFileSystem = this.$fs;
            this.label = 1;
            if (displayWatch.syncPositions$watch_release(watchFileSystem, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Behaviours$updatePositions$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
