package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SessionStatus;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

/* compiled from: WorkoutViewModel.kt */
/* loaded from: classes3.dex */
public final class WorkoutViewModel {
    private final FitnessProvider fitnessProvider;
    private final FitnessProvider.Profile.Measurement measurement;

    public WorkoutViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
        this.measurement = fitnessProvider.getProfile().getMeasurement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<List<Session>> filterOutDeletedSessions(List<? extends List<Session>> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                if (((Session) obj).getStatus() != SessionStatus.Deleted) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getWorkoutDetailed(long r5, kotlin.coroutines.Continuation<? super com.animaconnected.watch.workout.SessionListItem> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.workout.WorkoutViewModel$getWorkoutDetailed$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.workout.WorkoutViewModel$getWorkoutDetailed$1 r0 = (com.animaconnected.watch.workout.WorkoutViewModel$getWorkoutDetailed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.workout.WorkoutViewModel$getWorkoutDetailed$1 r0 = new com.animaconnected.watch.workout.WorkoutViewModel$getWorkoutDetailed$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.workout.WorkoutViewModel r5 = (com.animaconnected.watch.workout.WorkoutViewModel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.fitness.FitnessProvider r7 = r4.fitnessProvider
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.getSessionsDetailed(r5, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            com.animaconnected.watch.fitness.Session r7 = (com.animaconnected.watch.fitness.Session) r7
            if (r7 != 0) goto L4a
            r5 = 0
            return r5
        L4a:
            com.animaconnected.watch.workout.SessionListItem$Companion r6 = com.animaconnected.watch.workout.SessionListItem.Companion
            com.animaconnected.watch.fitness.FitnessProvider$Profile$Measurement r5 = r5.measurement
            com.animaconnected.watch.workout.SessionListItem r5 = r6.fromSession(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.WorkoutViewModel.getWorkoutDetailed(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CommonFlow<List<WorkoutSectionItem>> observeWorkoutHistoryGrouped(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        List monthlyPeriods$default = TimePeriodKt.monthlyPeriods$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(monthlyPeriods$default, 10));
        Iterator it = monthlyPeriods$default.iterator();
        while (it.hasNext()) {
            arrayList.add(this.fitnessProvider.getSessionsOverview((TimePeriod) it.next()));
        }
        final Flow[] flowArr = (Flow[]) CollectionsKt___CollectionsKt.toList(arrayList).toArray(new Flow[0]);
        return FlowExtensionsKt.asCommonFlow(FlowKt.distinctUntilChanged(new Flow<List<? extends WorkoutSectionItem>>() { // from class: com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$$inlined$combine$1

            /* compiled from: Zip.kt */
            @DebugMetadata(c = "com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$$inlined$combine$1$3", f = "WorkoutViewModel.kt", l = {292}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$$inlined$combine$1$3, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends WorkoutSectionItem>>, List<? extends Session>[], Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;
                final /* synthetic */ WorkoutViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(Continuation continuation, WorkoutViewModel workoutViewModel) {
                    super(3, continuation);
                    this.this$0 = workoutViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    List filterOutDeletedSessions;
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String num;
                    String num2;
                    String num3;
                    String num4;
                    FitnessProvider.Profile.Measurement measurement;
                    int r13;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r2 = this.label;
                    if (r2 != 0) {
                        if (r2 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        List[] listArr = (List[]) ((Object[]) this.L$1);
                        WorkoutViewModel workoutViewModel = this.this$0;
                        ArrayList arrayList = new ArrayList();
                        for (List list : listArr) {
                            if (!list.isEmpty()) {
                                arrayList.add(list);
                            }
                        }
                        filterOutDeletedSessions = workoutViewModel.filterOutDeletedSessions(CollectionsKt___CollectionsKt.reversed(arrayList));
                        List<List> list2 = filterOutDeletedSessions;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
                        for (List list3 : list2) {
                            EnumEntries<SessionType> entries = SessionType.getEntries();
                            int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries, 10));
                            if (mapCapacity < 16) {
                                mapCapacity = 16;
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                            for (Object obj2 : entries) {
                                linkedHashMap.put(obj2, new Integer(0));
                            }
                            LinkedHashMap mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
                            List<Session> sortedWith = CollectionsKt___CollectionsKt.sortedWith(list3, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a8: INVOKE (r10v4 'sortedWith' java.util.List<com.animaconnected.watch.fitness.Session>) = 
                                  (r7v4 'list3' java.util.List)
                                  (wrap:java.util.Comparator:0x00a1: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:162) call: com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$lambda$6$lambda$5$$inlined$sortedByDescending$1.<init>():void type: CONSTRUCTOR)
                                 STATIC call: kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(java.lang.Iterable, java.util.Comparator):java.util.List A[DECLARE_VAR, MD:<T>:(java.lang.Iterable<? extends T>, java.util.Comparator<? super T>):java.util.List<T> (m)] (LINE:165) in method: com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$$inlined$combine$1.3.invokeSuspend(java.lang.Object):java.lang.Object, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:207)
                                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$lambda$6$lambda$5$$inlined$sortedByDescending$1, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 27 more
                                */
                            /*
                                Method dump skipped, instructions count: 423
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$$inlined$combine$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(FlowCollector<? super List<? extends WorkoutSectionItem>> flowCollector, List<? extends Session>[] listArr, Continuation<? super Unit> continuation) {
                            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.this$0);
                            anonymousClass3.L$0 = flowCollector;
                            anonymousClass3.L$1 = listArr;
                            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super List<? extends WorkoutSectionItem>> flowCollector, Continuation continuation) {
                        final Flow[] flowArr2 = flowArr;
                        Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends Session>[]>() { // from class: com.animaconnected.watch.workout.WorkoutViewModel$observeWorkoutHistoryGrouped$$inlined$combine$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final List<? extends Session>[] invoke() {
                                return new List[flowArr2.length];
                            }
                        }, new AnonymousClass3(null, this), flowCollector, flowArr2);
                        if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                            return combineInternal;
                        }
                        return Unit.INSTANCE;
                    }
                }));
            }
        }
