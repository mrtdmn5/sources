package com.animaconnected.watch.fitness;

import com.animaconnected.watch.Watch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2", f = "WatchFitnessProvider.kt", l = {1112}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$setWatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Watch $watch;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$setWatch$2(Watch watch, WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$setWatch$2> continuation) {
        super(2, continuation);
        this.$watch = watch;
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFitnessProvider$setWatch$2 watchFitnessProvider$setWatch$2 = new WatchFitnessProvider$setWatch$2(this.$watch, this.this$0, continuation);
        watchFitnessProvider$setWatch$2.L$0 = obj;
        return watchFitnessProvider$setWatch$2;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final StateFlow<Watch.WatchState> state = this.$watch.getState();
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Watch.WatchState>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1

                /* compiled from: Emitters.kt */
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.result
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L4e
                        L27:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L2f:
                            kotlin.ResultKt.throwOnFailure(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                            r2 = r6
                            com.animaconnected.watch.Watch$WatchState r2 = (com.animaconnected.watch.Watch.WatchState) r2
                            com.animaconnected.watch.Watch$WatchState r4 = com.animaconnected.watch.Watch.WatchState.Ready
                            if (r2 == r4) goto L42
                            com.animaconnected.watch.Watch$WatchState r4 = com.animaconnected.watch.Watch.WatchState.Disconnected
                            if (r2 != r4) goto L40
                            goto L42
                        L40:
                            r2 = 0
                            goto L43
                        L42:
                            r2 = r3
                        L43:
                            if (r2 == 0) goto L4e
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r6, r0)
                            if (r6 != r1) goto L4e
                            return r1
                        L4e:
                            kotlin.Unit r6 = kotlin.Unit.INSTANCE
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Watch.WatchState> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            });
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(coroutineScope, this.this$0, this.$watch);
            this.label = 1;
            if (distinctUntilChanged.collect(anonymousClass2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$setWatch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: WatchFitnessProvider.kt */
    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ Watch $watch;
        final /* synthetic */ WatchFitnessProvider this$0;

        /* compiled from: WatchFitnessProvider.kt */
        /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2$2$WhenMappings */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[Watch.WatchState.values().length];
                try {
                    r0[Watch.WatchState.Ready.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[Watch.WatchState.Disconnected.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        public AnonymousClass2(CoroutineScope coroutineScope, WatchFitnessProvider watchFitnessProvider, Watch watch) {
            this.$$this$launch = coroutineScope;
            this.this$0 = watchFitnessProvider;
            this.$watch = watch;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|90|6|7|8|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x01d6, code lost:            if (r3 != null) goto L87;     */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0096, code lost:            r0 = move-exception;     */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0097, code lost:            r9 = r0;        r2 = r8;     */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0062, code lost:            r0 = move-exception;     */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0063, code lost:            r9 = r0;        r2 = r7;     */
        /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0024. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01d3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x01c3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01ad A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x018f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0190  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0173 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0174  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(final com.animaconnected.watch.Watch.WatchState r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
            /*
                Method dump skipped, instructions count: 562
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$2.AnonymousClass2.emit(com.animaconnected.watch.Watch$WatchState, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Watch.WatchState) obj, (Continuation<? super Unit>) continuation);
        }
    }
}
