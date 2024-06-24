package com.animaconnected.watch.fitness;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.CommandCenter;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$heartrateLiveSharedStateFlow$1", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$heartrateLiveSharedStateFlow$1 extends SuspendLambda implements Function3<FlowCollector<? super HeartrateMetricItem>, Throwable, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* compiled from: WatchFitnessProvider.kt */
    @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$heartrateLiveSharedStateFlow$1$1", f = "WatchFitnessProvider.kt", l = {80}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$heartrateLiveSharedStateFlow$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WatchFitnessProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WatchFitnessProvider watchFitnessProvider, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = watchFitnessProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Watch watch;
            boolean z;
            Watch watch2;
            CoroutineScope coroutineScope;
            FitnessSyncWatch fitnessSync$watch_release;
            CoroutineScope coroutineScope2;
            CommandCenter commandCenter;
            String str;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                watch = this.this$0.watch;
                if (watch != null && (commandCenter = watch.getCommandCenter()) != null && commandCenter.hasCommand$watch_release(Command.FITNESS_HEARTRATE_LIVE)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    watch2 = this.this$0.watch;
                    if (watch2 != null && (fitnessSync$watch_release = watch2.getFitnessSync$watch_release()) != null) {
                        this.L$0 = coroutineScope3;
                        this.label = 1;
                        if (fitnessSync$watch_release.writeHeartRateLive(false, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        coroutineScope2 = coroutineScope3;
                    } else {
                        coroutineScope = coroutineScope3;
                        str = this.this$0.tag;
                        LogKt.debug$default((Object) coroutineScope, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider.heartrateLiveSharedStateFlow.1.1.1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Heartrate live mode stopped";
                            }
                        }, 6, (Object) null);
                    }
                }
                return Unit.INSTANCE;
            }
            coroutineScope = coroutineScope2;
            str = this.this$0.tag;
            LogKt.debug$default((Object) coroutineScope, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider.heartrateLiveSharedStateFlow.1.1.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Heartrate live mode stopped";
                }
            }, 6, (Object) null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$heartrateLiveSharedStateFlow$1(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$heartrateLiveSharedStateFlow$1> continuation) {
        super(3, continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job job;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            job = this.this$0.heartrateLiveJob;
            if (job != null) {
                job.cancel(null);
            }
            BuildersKt.launch$default(this.this$0.getScope(), null, null, new AnonymousClass1(this.this$0, null), 3);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super HeartrateMetricItem> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return new WatchFitnessProvider$heartrateLiveSharedStateFlow$1(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
