package com.animaconnected.watch.workout.utils;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;

/* compiled from: VmChartUtils.kt */
/* loaded from: classes3.dex */
public final class VmChartUtilsKt {
    public static final <T> Flow<List<T>> daysFlow(TimePeriod timePeriod, Function1<? super TimePeriod, CommonFlow<List<T>>> retrieveData) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(retrieveData, "retrieveData");
        List dayIntervals$default = TimePeriodKt.dayIntervals$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(dayIntervals$default, 10));
        Iterator<T> it = dayIntervals$default.iterator();
        while (it.hasNext()) {
            arrayList.add(retrieveData.invoke((TimePeriod) it.next()));
        }
        final Flow[] flowArr = (Flow[]) CollectionsKt___CollectionsKt.toList(arrayList).toArray(new Flow[0]);
        return new Flow<List<? extends T>>() { // from class: com.animaconnected.watch.workout.utils.VmChartUtilsKt$daysFlow$$inlined$combine$1

            /* compiled from: Zip.kt */
            @DebugMetadata(c = "com.animaconnected.watch.workout.utils.VmChartUtilsKt$daysFlow$$inlined$combine$1$3", f = "VmChartUtils.kt", l = {292}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.workout.utils.VmChartUtilsKt$daysFlow$$inlined$combine$1$3, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends T>>, List<? extends T>[], Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
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
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        List[] listArr = (List[]) ((Object[]) this.L$1);
                        ArrayList arrayList = new ArrayList();
                        for (List list : listArr) {
                            CollectionsKt__ReversedViewsKt.addAll(list, arrayList);
                        }
                        this.label = 1;
                        if (flowCollector.emit(arrayList, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super List<? extends T>> flowCollector, List<? extends T>[] listArr, Continuation<? super Unit> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.L$0 = flowCollector;
                    anonymousClass3.L$1 = listArr;
                    return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends T>[]>() { // from class: com.animaconnected.watch.workout.utils.VmChartUtilsKt$daysFlow$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final List<? extends T>[] invoke() {
                        return new List[flowArr2.length];
                    }
                }, new AnonymousClass3(null), flowCollector, flowArr2);
                if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final <T> Flow<List<T>> equalsFlow(TimePeriod timePeriod, Function1<? super TimePeriod, CommonFlow<List<T>>> retrieveData) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(retrieveData, "retrieveData");
        final Flow[] flowArr = (Flow[]) CollectionsKt___CollectionsKt.toList(CollectionsKt__CollectionsKt.listOf(retrieveData.invoke(timePeriod))).toArray(new Flow[0]);
        return new Flow<List<? extends T>>() { // from class: com.animaconnected.watch.workout.utils.VmChartUtilsKt$equalsFlow$$inlined$combine$1

            /* compiled from: Zip.kt */
            @DebugMetadata(c = "com.animaconnected.watch.workout.utils.VmChartUtilsKt$equalsFlow$$inlined$combine$1$3", f = "VmChartUtils.kt", l = {292}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.workout.utils.VmChartUtilsKt$equalsFlow$$inlined$combine$1$3, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends T>>, List<? extends T>[], Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
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
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        List[] listArr = (List[]) ((Object[]) this.L$1);
                        ArrayList arrayList = new ArrayList();
                        for (List list : listArr) {
                            CollectionsKt__ReversedViewsKt.addAll(list, arrayList);
                        }
                        this.label = 1;
                        if (flowCollector.emit(arrayList, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super List<? extends T>> flowCollector, List<? extends T>[] listArr, Continuation<? super Unit> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.L$0 = flowCollector;
                    anonymousClass3.L$1 = listArr;
                    return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends T>[]>() { // from class: com.animaconnected.watch.workout.utils.VmChartUtilsKt$equalsFlow$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final List<? extends T>[] invoke() {
                        return new List[flowArr2.length];
                    }
                }, new AnonymousClass3(null), flowCollector, flowArr2);
                if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static final boolean isSelected(long j, TimePeriod selectedTimePeriod) {
        Intrinsics.checkNotNullParameter(selectedTimePeriod, "selectedTimePeriod");
        if (j >= selectedTimePeriod.getStartTs() && j < selectedTimePeriod.getEndTs()) {
            return true;
        }
        return false;
    }

    public static final <T> Flow<List<T>> monthsFlow(TimePeriod timePeriod, Function1<? super TimePeriod, CommonFlow<List<T>>> retrieveData) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(retrieveData, "retrieveData");
        List monthlyPeriods$default = TimePeriodKt.monthlyPeriods$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(monthlyPeriods$default, 10));
        Iterator<T> it = monthlyPeriods$default.iterator();
        while (it.hasNext()) {
            arrayList.add(retrieveData.invoke((TimePeriod) it.next()));
        }
        final Flow[] flowArr = (Flow[]) CollectionsKt___CollectionsKt.toList(arrayList).toArray(new Flow[0]);
        return new Flow<List<? extends T>>() { // from class: com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlow$$inlined$combine$1

            /* compiled from: Zip.kt */
            @DebugMetadata(c = "com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlow$$inlined$combine$1$3", f = "VmChartUtils.kt", l = {292}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlow$$inlined$combine$1$3, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends T>>, List<? extends T>[], Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
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
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        List[] listArr = (List[]) ((Object[]) this.L$1);
                        ArrayList arrayList = new ArrayList();
                        for (List list : listArr) {
                            CollectionsKt__ReversedViewsKt.addAll(list, arrayList);
                        }
                        this.label = 1;
                        if (flowCollector.emit(arrayList, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super List<? extends T>> flowCollector, List<? extends T>[] listArr, Continuation<? super Unit> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.L$0 = flowCollector;
                    anonymousClass3.L$1 = listArr;
                    return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends T>[]>() { // from class: com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlow$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final List<? extends T>[] invoke() {
                        return new List[flowArr2.length];
                    }
                }, new AnonymousClass3(null), flowCollector, flowArr2);
                if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:10:0x007c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object monthsFlowSuspend(com.animaconnected.watch.fitness.TimePeriod r6, kotlin.jvm.functions.Function2<? super com.animaconnected.watch.fitness.TimePeriod, ? super kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<? extends T>>>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<? extends T>>> r8) {
        /*
            boolean r0 = r8 instanceof com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlowSuspend$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlowSuspend$1 r0 = (com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlowSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlowSuspend$1 r0 = new com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlowSuspend$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.L$3
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7c
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            java.util.List r6 = com.animaconnected.watch.fitness.TimePeriodKt.monthlyPeriods$default(r6, r8, r3, r8)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r6, r2)
            r8.<init>(r2)
            java.util.Iterator r6 = r6.iterator()
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L5c:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r2 = r7.next()
            com.animaconnected.watch.fitness.TimePeriod r2 = (com.animaconnected.watch.fitness.TimePeriod) r2
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r6
            r0.label = r3
            java.lang.Object r2 = r8.invoke(r2, r0)
            if (r2 != r1) goto L79
            return r1
        L79:
            r4 = r8
            r8 = r2
            r2 = r6
        L7c:
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
            r6.add(r8)
            r6 = r2
            r8 = r4
            goto L5c
        L84:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r6)
            java.util.Collection r6 = (java.util.Collection) r6
            r7 = 0
            kotlinx.coroutines.flow.Flow[] r7 = new kotlinx.coroutines.flow.Flow[r7]
            java.lang.Object[] r6 = r6.toArray(r7)
            kotlinx.coroutines.flow.Flow[] r6 = (kotlinx.coroutines.flow.Flow[]) r6
            com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlowSuspend$$inlined$combine$1 r7 = new com.animaconnected.watch.workout.utils.VmChartUtilsKt$monthsFlowSuspend$$inlined$combine$1
            r7.<init>()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.utils.VmChartUtilsKt.monthsFlowSuspend(com.animaconnected.watch.fitness.TimePeriod, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T, R> Flow<List<R>> unwrap(final Flow<? extends List<? extends T>> flow, final Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new Flow<List<? extends R>>() { // from class: com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function1 $transform$inlined$1;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1$2", f = "VmChartUtils.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, Function1 function1) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined$1 = function1;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L64
                    L27:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        java.util.List r7 = (java.util.List) r7
                        java.lang.Iterable r7 = (java.lang.Iterable) r7
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r7, r4)
                        r2.<init>(r4)
                        java.util.Iterator r7 = r7.iterator()
                    L47:
                        boolean r4 = r7.hasNext()
                        if (r4 == 0) goto L5b
                        java.lang.Object r4 = r7.next()
                        kotlin.jvm.functions.Function1 r5 = r6.$transform$inlined$1
                        java.lang.Object r4 = r5.invoke(r4)
                        r2.add(r4)
                        goto L47
                    L5b:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L64
                        return r1
                    L64:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.utils.VmChartUtilsKt$unwrap$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, transform), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }
}
