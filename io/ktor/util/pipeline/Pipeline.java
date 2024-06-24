package io.ktor.util.pipeline;

import io.ktor.util.ConcurrentSafeAttributes;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pipeline.kt */
/* loaded from: classes3.dex */
public class Pipeline<TSubject, TContext> {
    private volatile /* synthetic */ Object _interceptors;
    public boolean interceptorsListShared;
    public PipelinePhase interceptorsListSharedPhase;
    public int interceptorsQuantity;
    public final ArrayList phasesRaw;

    public Pipeline(PipelinePhase... pipelinePhaseArr) {
        new ConcurrentSafeAttributes();
        this.phasesRaw = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(pipelinePhaseArr, pipelinePhaseArr.length));
        this._interceptors = null;
    }

    public final Object execute(TContext context, TSubject subject, Continuation<? super TSubject> continuation) {
        PipelineContext debugPipelineContext;
        PhaseContent phaseContent;
        int lastIndex;
        PhaseContent phaseContent2;
        CoroutineContext coroutineContext = continuation.getContext();
        if (((List) this._interceptors) == null) {
            int r1 = this.interceptorsQuantity;
            if (r1 == 0) {
                this._interceptors = EmptyList.INSTANCE;
                this.interceptorsListShared = false;
                this.interceptorsListSharedPhase = null;
            } else {
                ArrayList arrayList = this.phasesRaw;
                if (r1 == 1 && (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList)) >= 0) {
                    int r6 = 0;
                    while (true) {
                        Object obj = arrayList.get(r6);
                        if (obj instanceof PhaseContent) {
                            phaseContent2 = (PhaseContent) obj;
                        } else {
                            phaseContent2 = null;
                        }
                        if (phaseContent2 != null && !phaseContent2.interceptors.isEmpty()) {
                            Collection collection = phaseContent2.interceptors;
                            phaseContent2.shared = true;
                            this._interceptors = collection;
                            this.interceptorsListShared = false;
                            this.interceptorsListSharedPhase = phaseContent2.phase;
                            break;
                        }
                        if (r6 == lastIndex) {
                            break;
                        }
                        r6++;
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                if (lastIndex2 >= 0) {
                    int r7 = 0;
                    while (true) {
                        Object obj2 = arrayList.get(r7);
                        if (obj2 instanceof PhaseContent) {
                            phaseContent = (PhaseContent) obj2;
                        } else {
                            phaseContent = null;
                        }
                        if (phaseContent != null) {
                            List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> list = phaseContent.interceptors;
                            arrayList2.ensureCapacity(list.size() + arrayList2.size());
                            int size = list.size();
                            for (int r10 = 0; r10 < size; r10++) {
                                arrayList2.add(list.get(r10));
                            }
                        }
                        if (r7 == lastIndex2) {
                            break;
                        }
                        r7++;
                    }
                }
                this._interceptors = arrayList2;
                this.interceptorsListShared = false;
                this.interceptorsListSharedPhase = null;
            }
        }
        this.interceptorsListShared = true;
        List list2 = (List) this._interceptors;
        Intrinsics.checkNotNull(list2);
        boolean developmentMode = getDevelopmentMode();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        if (!PipelineContext_jvmKt.DISABLE_SFG && !developmentMode) {
            debugPipelineContext = new SuspendFunctionGun(subject, context, list2);
        } else {
            debugPipelineContext = new DebugPipelineContext(context, list2, subject, coroutineContext);
        }
        return debugPipelineContext.execute$ktor_utils(subject, continuation);
    }

    public final PhaseContent<TSubject, TContext> findPhase(PipelinePhase pipelinePhase) {
        ArrayList arrayList = this.phasesRaw;
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            Object obj = arrayList.get(r2);
            if (obj == pipelinePhase) {
                PhaseContent<TSubject, TContext> phaseContent = new PhaseContent<>(pipelinePhase, PipelinePhaseRelation.Last.INSTANCE);
                arrayList.set(r2, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent<TSubject, TContext> phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.phase == pipelinePhase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    public final int findPhaseIndex(PipelinePhase pipelinePhase) {
        ArrayList arrayList = this.phasesRaw;
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            Object obj = arrayList.get(r2);
            if (obj == pipelinePhase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).phase == pipelinePhase)) {
                return r2;
            }
        }
        return -1;
    }

    public boolean getDevelopmentMode() {
        return false;
    }

    public final boolean hasPhase(PipelinePhase pipelinePhase) {
        ArrayList arrayList = this.phasesRaw;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            Object obj = arrayList.get(r3);
            if (obj != pipelinePhase) {
                if ((obj instanceof PhaseContent) && ((PhaseContent) obj).phase == pipelinePhase) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void intercept(io.ktor.util.pipeline.PipelinePhase r7, kotlin.jvm.functions.Function3<? super io.ktor.util.pipeline.PipelineContext<TSubject, TContext>, ? super TSubject, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "phase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            io.ktor.util.pipeline.PhaseContent r0 = r6.findPhase(r7)
            if (r0 == 0) goto L82
            r1 = 3
            kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, r8)
            java.lang.Object r1 = r6._interceptors
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r2 = r6.phasesRaw
            boolean r2 = r2.isEmpty()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L69
            if (r1 != 0) goto L20
            goto L69
        L20:
            boolean r2 = r6.interceptorsListShared
            if (r2 != 0) goto L69
            boolean r2 = r1 instanceof java.util.List
            if (r2 == 0) goto L32
            boolean r2 = r1 instanceof kotlin.jvm.internal.markers.KMappedMarker
            if (r2 == 0) goto L30
            boolean r2 = r1 instanceof kotlin.jvm.internal.markers.KMutableList
            if (r2 == 0) goto L32
        L30:
            r2 = r4
            goto L33
        L32:
            r2 = r3
        L33:
            if (r2 != 0) goto L36
            goto L69
        L36:
            io.ktor.util.pipeline.PipelinePhase r2 = r6.interceptorsListSharedPhase
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)
            if (r2 == 0) goto L42
            r1.add(r8)
            goto L67
        L42:
            java.util.ArrayList r2 = r6.phasesRaw
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)
            if (r2 != 0) goto L5a
            int r2 = r6.findPhaseIndex(r7)
            java.util.ArrayList r5 = r6.phasesRaw
            int r5 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r5)
            if (r2 != r5) goto L69
        L5a:
            io.ktor.util.pipeline.PhaseContent r7 = r6.findPhase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r7.addInterceptor(r8)
            r1.add(r8)
        L67:
            r7 = r4
            goto L6a
        L69:
            r7 = r3
        L6a:
            if (r7 == 0) goto L72
            int r7 = r6.interceptorsQuantity
            int r7 = r7 + r4
            r6.interceptorsQuantity = r7
            return
        L72:
            r0.addInterceptor(r8)
            int r7 = r6.interceptorsQuantity
            int r7 = r7 + r4
            r6.interceptorsQuantity = r7
            r7 = 0
            r6._interceptors = r7
            r6.interceptorsListShared = r3
            r6.interceptorsListSharedPhase = r7
            return
        L82:
            io.ktor.util.pipeline.InvalidPhaseException r8 = new io.ktor.util.pipeline.InvalidPhaseException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Phase "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = " was not registered for this pipeline"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.Pipeline.intercept(io.ktor.util.pipeline.PipelinePhase, kotlin.jvm.functions.Function3):void");
    }
}
