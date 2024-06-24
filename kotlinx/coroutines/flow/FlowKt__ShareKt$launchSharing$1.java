package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Share.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {214, 218, 219, 225}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object $initialValue;
    public final /* synthetic */ MutableSharedFlow<Object> $shared;
    public final /* synthetic */ SharingStarted $started;
    public final /* synthetic */ Flow<Object> $upstream;
    public int label;

    /* compiled from: Share.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        public /* synthetic */ int I$0;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Integer num, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(Integer.valueOf(num.intValue()), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            ResultKt.throwOnFailure(obj);
            if (this.I$0 > 0) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: Share.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {227}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Object $initialValue;
        public final /* synthetic */ MutableSharedFlow<Object> $shared;
        public final /* synthetic */ Flow<Object> $upstream;
        public /* synthetic */ Object L$0;
        public int label;

        /* compiled from: Share.kt */
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$WhenMappings */
        /* loaded from: classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[SharingCommand.values().length];
                try {
                    r0[SharingCommand.START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[SharingCommand.STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Flow<Object> flow, MutableSharedFlow<Object> mutableSharedFlow, Object obj, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$upstream = flow;
            this.$shared = mutableSharedFlow;
            this.$initialValue = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(Unit.INSTANCE);
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
                int r4 = WhenMappings.$EnumSwitchMapping$0[((SharingCommand) this.L$0).ordinal()];
                MutableSharedFlow<Object> mutableSharedFlow = this.$shared;
                if (r4 != 1) {
                    if (r4 == 3) {
                        Symbol symbol = SharedFlowKt.NO_VALUE;
                        Object obj2 = this.$initialValue;
                        if (obj2 == symbol) {
                            mutableSharedFlow.resetReplayCache();
                        } else {
                            mutableSharedFlow.tryEmit(obj2);
                        }
                    }
                } else {
                    this.label = 1;
                    if (this.$upstream.collect(mutableSharedFlow, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharing$1(SharingStarted sharingStarted, Flow<Object> flow, MutableSharedFlow<Object> mutableSharedFlow, Object obj, Continuation<? super FlowKt__ShareKt$launchSharing$1> continuation) {
        super(2, continuation);
        this.$started = sharingStarted;
        this.$upstream = flow;
        this.$shared = mutableSharedFlow;
        this.$initialValue = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0058 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            kotlinx.coroutines.flow.Flow<java.lang.Object> r6 = r8.$upstream
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.Object> r7 = r8.$shared
            if (r1 == 0) goto L27
            if (r1 == r5) goto L23
            if (r1 == r4) goto L1f
            if (r1 == r3) goto L23
            if (r1 != r2) goto L17
            goto L23
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L50
        L23:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L75
        L27:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.flow.StartedEagerly r9 = kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
            kotlinx.coroutines.flow.SharingStarted r1 = r8.$started
            if (r1 != r9) goto L39
            r8.label = r5
            java.lang.Object r9 = r6.collect(r7, r8)
            if (r9 != r0) goto L75
            return r0
        L39:
            kotlinx.coroutines.flow.StartedLazily r9 = kotlinx.coroutines.flow.SharingStarted.Companion.Lazily
            r5 = 0
            if (r1 != r9) goto L59
            kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow r9 = r7.getSubscriptionCount()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.first(r9, r1, r8)
            if (r9 != r0) goto L50
            return r0
        L50:
            r8.label = r3
            java.lang.Object r9 = r6.collect(r7, r8)
            if (r9 != r0) goto L75
            return r0
        L59:
            kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow r9 = r7.getSubscriptionCount()
            kotlinx.coroutines.flow.Flow r9 = r1.command(r9)
            kotlinx.coroutines.flow.Flow r9 = kotlinx.coroutines.flow.FlowKt.distinctUntilChanged(r9)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            java.lang.Object r3 = r8.$initialValue
            r1.<init>(r6, r7, r3, r5)
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.collectLatest(r9, r1, r8)
            if (r9 != r0) goto L75
            return r0
        L75:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
