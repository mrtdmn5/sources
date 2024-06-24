package com.animaconnected.watch.fitness;

import com.animaconnected.watch.workout.HeartrateMetricItem;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$getHeartrateLiveData$liveFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super HeartrateMetricItem>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* compiled from: WatchFitnessProvider.kt */
    @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3", f = "WatchFitnessProvider.kt", l = {489, 491}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WatchFitnessProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WatchFitnessProvider watchFitnessProvider, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = watchFitnessProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006f -> B:7:0x002e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L25
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r1 = r11.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                goto L2d
            L14:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1c:
                java.lang.Object r1 = r11.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                r12 = r11
                goto L4d
            L25:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
                r1 = r12
            L2d:
                r12 = r11
            L2e:
                boolean r4 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r4 == 0) goto L72
                com.animaconnected.watch.fitness.WatchFitnessProvider r4 = r12.this$0
                com.animaconnected.watch.Watch r4 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$getWatch$p(r4)
                if (r4 == 0) goto L4d
                com.animaconnected.watch.fitness.sync.FitnessSyncWatch r4 = r4.getFitnessSync$watch_release()
                if (r4 == 0) goto L4d
                r12.L$0 = r1
                r12.label = r3
                java.lang.Object r4 = r4.writeHeartRateLive(r3, r12)
                if (r4 != r0) goto L4d
                return r0
            L4d:
                com.animaconnected.watch.fitness.WatchFitnessProvider r4 = r12.this$0
                java.lang.String r5 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$getTag$p(r4)
                r6 = 0
                r7 = 0
                com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3$1 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider.getHeartrateLiveData.liveFlow.1.3.1
                    static {
                        /*
                            com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3$1) com.animaconnected.watch.fitness.WatchFitnessProvider.getHeartrateLiveData.liveFlow.1.3.1.INSTANCE com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass3.AnonymousClass1.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 0
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass3.AnonymousClass1.<init>():void");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final java.lang.String invoke() {
                        /*
                            r1 = this;
                            java.lang.String r0 = "Update live heart-rate data request, keep alive"
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass3.AnonymousClass1.invoke():java.lang.String");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ java.lang.String invoke() {
                        /*
                            r1 = this;
                            java.lang.String r0 = r1.invoke()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass3.AnonymousClass1.invoke():java.lang.Object");
                    }
                }
                r9 = 6
                r10 = 0
                r4 = r1
                com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)
                int r4 = kotlin.time.Duration.$r8$clinit
                r4 = 90
                kotlin.time.DurationUnit r5 = kotlin.time.DurationUnit.SECONDS
                long r4 = kotlin.time.DurationKt.toDuration(r4, r5)
                r12.L$0 = r1
                r12.label = r2
                java.lang.Object r4 = kotlinx.coroutines.DelayKt.m1695delayVtjQ1oo(r4, r12)
                if (r4 != r0) goto L2e
                return r0
            L72:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$getHeartrateLiveData$liveFlow$1(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$getHeartrateLiveData$liveFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFitnessProvider$getHeartrateLiveData$liveFlow$1 watchFitnessProvider$getHeartrateLiveData$liveFlow$1 = new WatchFitnessProvider$getHeartrateLiveData$liveFlow$1(this.this$0, continuation);
        watchFitnessProvider$getHeartrateLiveData$liveFlow$1.L$0 = obj;
        return watchFitnessProvider$getHeartrateLiveData$liveFlow$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if (r8.isActive() == true) goto L10;     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r7.label
            if (r0 != 0) goto L5b
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r0 = r8
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            com.animaconnected.watch.fitness.WatchFitnessProvider r8 = r7.this$0
            kotlinx.coroutines.Job r8 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$getHeartrateLiveJob$p(r8)
            if (r8 == 0) goto L1e
            boolean r8 = r8.isActive()
            r1 = 1
            if (r8 != r1) goto L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 == 0) goto L33
            com.animaconnected.watch.fitness.WatchFitnessProvider r8 = r7.this$0
            java.lang.String r1 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$getTag$p(r8)
            r2 = 0
            r3 = 0
            com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$1 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.1
                static {
                    /*
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$1) com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.1.INSTANCE com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "HeartrateLive job already active, join in"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass1.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass1.invoke():java.lang.Object");
                }
            }
            r5 = 6
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L33:
            com.animaconnected.watch.fitness.WatchFitnessProvider r8 = r7.this$0
            java.lang.String r1 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$getTag$p(r8)
            r3 = 0
            com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$2 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.2
                static {
                    /*
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$2 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$2) com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.2.INSTANCE com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Start requesting live heart-rate data"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.AnonymousClass2.invoke():java.lang.Object");
                }
            }
            r5 = 6
            r6 = 0
            r2 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.fitness.WatchFitnessProvider r8 = r7.this$0
            kotlinx.coroutines.CoroutineScope r0 = r8.getScope()
            com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3 r1 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1$3
            com.animaconnected.watch.fitness.WatchFitnessProvider r2 = r7.this$0
            r3 = 0
            r1.<init>(r2, r3)
            r2 = 3
            kotlinx.coroutines.StandaloneCoroutine r0 = kotlinx.coroutines.BuildersKt.launch$default(r0, r3, r3, r1, r2)
            com.animaconnected.watch.fitness.WatchFitnessProvider.access$setHeartrateLiveJob$p(r8, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L5b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$liveFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super HeartrateMetricItem> flowCollector, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$getHeartrateLiveData$liveFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
