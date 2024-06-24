package com.animaconnected.secondo.behaviour.music;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* compiled from: MusicWatchAppAndroid.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$adjustVolume$1", f = "MusicWatchAppAndroid.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MusicWatchAppAndroid$adjustVolume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $adjustVolumeFunction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicWatchAppAndroid$adjustVolume$1(Function0<Unit> function0, Continuation<? super MusicWatchAppAndroid$adjustVolume$1> continuation) {
        super(2, continuation);
        this.$adjustVolumeFunction = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MusicWatchAppAndroid$adjustVolume$1 musicWatchAppAndroid$adjustVolume$1 = new MusicWatchAppAndroid$adjustVolume$1(this.$adjustVolumeFunction, continuation);
        musicWatchAppAndroid$adjustVolume$1.L$0 = obj;
        return musicWatchAppAndroid$adjustVolume$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        }
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            this.$adjustVolumeFunction.invoke();
            int r3 = Duration.$r8$clinit;
            long duration = DurationKt.toDuration(1, DurationUnit.SECONDS);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.m1695delayVtjQ1oo(duration, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MusicWatchAppAndroid$adjustVolume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
