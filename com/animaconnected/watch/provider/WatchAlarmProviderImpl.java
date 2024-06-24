package com.animaconnected.watch.provider;

import app.cash.sqldelight.coroutines.FlowQuery;
import app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.AlarmDatabase;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.model.alarms.Alarms;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: WatchAlarmProviderImpl.kt */
/* loaded from: classes3.dex */
public final class WatchAlarmProviderImpl implements WatchAlarmProvider {
    private final CommonFlow<List<WatchAlarm>> alarms;
    private final AlarmDatabase database;
    private final Set<WatchAlarmProviderListener> listeners;
    private final int maxNumberOfAlarms;
    private final String tag;

    /* compiled from: WatchAlarmProviderImpl.kt */
    @DebugMetadata(c = "com.animaconnected.watch.provider.WatchAlarmProviderImpl$2", f = "WatchAlarmProviderImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.provider.WatchAlarmProviderImpl$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends WatchAlarm>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends WatchAlarm> list, Continuation<? super Unit> continuation) {
            return invoke2((List<WatchAlarm>) list, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final List list = (List) this.L$0;
                WatchAlarmProviderImpl watchAlarmProviderImpl = WatchAlarmProviderImpl.this;
                LogKt.verbose$default((Object) watchAlarmProviderImpl, watchAlarmProviderImpl.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.WatchAlarmProviderImpl.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Alarm change from database: ".concat(CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, new Function1<WatchAlarm, CharSequence>() { // from class: com.animaconnected.watch.provider.WatchAlarmProviderImpl.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final CharSequence invoke(WatchAlarm it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return "\n" + it;
                            }
                        }, 31));
                    }
                }, 6, (Object) null);
                Iterator it = CollectionsKt___CollectionsKt.toList(WatchAlarmProviderImpl.this.listeners).iterator();
                while (it.hasNext()) {
                    ((WatchAlarmProviderListener) it.next()).onAlarmsChanged();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<WatchAlarm> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: WatchAlarmProviderImpl.kt */
    @DebugMetadata(c = "com.animaconnected.watch.provider.WatchAlarmProviderImpl$3", f = "WatchAlarmProviderImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.provider.WatchAlarmProviderImpl$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends WatchAlarm>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends WatchAlarm>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<WatchAlarm>>) flowCollector, th, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (th instanceof CancellationException) {
                    LogKt.debug$default((Object) flowCollector, WatchAlarmProviderImpl.this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.WatchAlarmProviderImpl.3.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Alarm listener exited, scope closed";
                        }
                    }, 6, (Object) null);
                } else {
                    LogKt.warn((Object) flowCollector, WatchAlarmProviderImpl.this.tag, th, true, (Function0<String>) new Function0<String>() { // from class: com.animaconnected.watch.provider.WatchAlarmProviderImpl.3.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Exception from Alarm handling";
                        }
                    });
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<WatchAlarm>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = flowCollector;
            anonymousClass3.L$1 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }
    }

    public WatchAlarmProviderImpl(CoroutineScope scope, AlarmDatabase database) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(database, "database");
        this.database = database;
        this.listeners = new HashSet();
        this.maxNumberOfAlarms = 8;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(database.getAlarmsQueries().getAll()), DispatchersKt.ioDispatcher());
        this.alarms = FlowExtensionsKt.asCommonFlow(new Flow<List<? extends WatchAlarm>>() { // from class: com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1$2", f = "WatchAlarmProviderImpl.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L64
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        java.util.List r6 = (java.util.List) r6
                        java.lang.Iterable r6 = (java.lang.Iterable) r6
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r6, r4)
                        r2.<init>(r4)
                        java.util.Iterator r6 = r6.iterator()
                    L47:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L5b
                        java.lang.Object r4 = r6.next()
                        com.animaconnected.watch.model.alarms.Alarms r4 = (com.animaconnected.watch.model.alarms.Alarms) r4
                        com.animaconnected.watch.provider.WatchAlarm r4 = com.animaconnected.watch.provider.WatchAlarmProviderKt.toWatchAlarm(r4)
                        r2.add(r4)
                        goto L47
                    L5b:
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L64
                        return r1
                    L64:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.WatchAlarmProviderImpl$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends WatchAlarm>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        this.tag = "WatchAlarmProviderImpl";
        LogKt.debug$default((Object) this, "WatchAlarmProviderImpl", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.WatchAlarmProviderImpl.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Listening for alarms from database";
            }
        }, 6, (Object) null);
        final CommonFlow<List<WatchAlarm>> alarms = getAlarms();
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass2(null), FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1
            public final /* synthetic */ int $count$inlined = 1;

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
                Object collect = alarms.collect(new FlowKt__LimitKt$drop$2$1(new Ref$IntRef(), this.$count$inlined, flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        })), new AnonymousClass3(null)), scope);
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    public void delete(WatchAlarm alarm) {
        Intrinsics.checkNotNullParameter(alarm, "alarm");
        this.database.getAlarmsQueries().deleteAlarm(alarm.getId());
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    public CommonFlow<List<WatchAlarm>> getAlarms() {
        return this.alarms;
    }

    public final AlarmDatabase getDatabase() {
        return this.database;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[LOOP:1: B:22:0x0072->B:24:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getHybridAlarms(boolean r5, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.device.HybridAlarm>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.provider.WatchAlarmProviderImpl$getHybridAlarms$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.provider.WatchAlarmProviderImpl$getHybridAlarms$1 r0 = (com.animaconnected.watch.provider.WatchAlarmProviderImpl$getHybridAlarms$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.provider.WatchAlarmProviderImpl$getHybridAlarms$1 r0 = new com.animaconnected.watch.provider.WatchAlarmProviderImpl$getHybridAlarms$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L41
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 == 0) goto L9c
            com.animaconnected.watch.CommonFlow r5 = r4.getAlarms()
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.first(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r6 = r6.iterator()
        L4c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L63
            java.lang.Object r0 = r6.next()
            r1 = r0
            com.animaconnected.watch.provider.WatchAlarm r1 = (com.animaconnected.watch.provider.WatchAlarm) r1
            boolean r1 = r1.getEnabled()
            if (r1 == 0) goto L4c
            r5.add(r0)
            goto L4c
        L63:
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r5, r0)
            r6.<init>(r0)
            java.util.Iterator r5 = r5.iterator()
        L72:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L9e
            java.lang.Object r0 = r5.next()
            com.animaconnected.watch.provider.WatchAlarm r0 = (com.animaconnected.watch.provider.WatchAlarm) r0
            com.animaconnected.watch.device.HybridAlarm r1 = new com.animaconnected.watch.device.HybridAlarm
            int r2 = r0.getHour()
            int r3 = r0.getMinute()
            java.util.Set r0 = r0.getDaysEnabled()
            com.animaconnected.watch.model.alarms.DaysOfWeek r0 = com.animaconnected.watch.provider.WatchAlarmProviderKt.toDaysOfWeek(r0)
            int r0 = r0.toBitSet()
            byte r0 = (byte) r0
            r1.<init>(r2, r3, r0)
            r6.add(r1)
            goto L72
        L9c:
            kotlin.collections.EmptyList r6 = kotlin.collections.EmptyList.INSTANCE
        L9e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.WatchAlarmProviderImpl.getHybridAlarms(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    public int getMaxNumberOfAlarms() {
        return this.maxNumberOfAlarms;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[LOOP:0: B:11:0x0054->B:13:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object migrate(com.animaconnected.watch.provider.WatchAlarm r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.provider.WatchAlarmProviderImpl$migrate$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.provider.WatchAlarmProviderImpl$migrate$1 r0 = (com.animaconnected.watch.provider.WatchAlarmProviderImpl$migrate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.provider.WatchAlarmProviderImpl$migrate$1 r0 = new com.animaconnected.watch.provider.WatchAlarmProviderImpl$migrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            com.animaconnected.watch.provider.WatchAlarm r5 = (com.animaconnected.watch.provider.WatchAlarm) r5
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.provider.WatchAlarmProviderImpl r0 = (com.animaconnected.watch.provider.WatchAlarmProviderImpl) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.CommonFlow r6 = r4.getAlarms()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.first(r6, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L54:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r6.next()
            com.animaconnected.watch.provider.WatchAlarm r1 = (com.animaconnected.watch.provider.WatchAlarm) r1
            r0.delete(r1)
            goto L54
        L64:
            r0.update(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.WatchAlarmProviderImpl.migrate(com.animaconnected.watch.provider.WatchAlarm, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    public WatchAlarm newAlarm() {
        Long l;
        long j;
        Iterator<T> it = this.database.getAlarmsQueries().getAll().executeAsList().iterator();
        if (!it.hasNext()) {
            l = null;
        } else {
            Long valueOf = Long.valueOf(((Alarms) it.next()).get_id());
            while (it.hasNext()) {
                Long valueOf2 = Long.valueOf(((Alarms) it.next()).get_id());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            l = valueOf;
        }
        Long l2 = l;
        if (l2 != null) {
            j = l2.longValue();
        } else {
            j = 0;
        }
        return new WatchAlarm(j + 1);
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    public void registerListener(WatchAlarmProviderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    public void unregisterListener(WatchAlarmProviderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.animaconnected.watch.provider.WatchAlarmProvider
    public void update(WatchAlarm alarm) {
        Intrinsics.checkNotNullParameter(alarm, "alarm");
        this.database.getAlarmsQueries().insertAlarm(WatchAlarmProviderKt.toDbAlarms(alarm));
    }
}
