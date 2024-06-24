package io.ktor.util.pipeline;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: PhaseContent.kt */
/* loaded from: classes3.dex */
public final class PhaseContent<TSubject, Call> {
    public static final ArrayList SharedArrayList = new ArrayList();
    public List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> interceptors;
    public final PipelinePhase phase;
    public final PipelinePhaseRelation relation;
    public boolean shared;

    public PhaseContent() {
        throw null;
    }

    public PhaseContent(PipelinePhase phase, PipelinePhaseRelation relation) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        ArrayList arrayList = SharedArrayList;
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function3<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptorFunction<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent> }>");
        if ((arrayList instanceof KMappedMarker) && !(arrayList instanceof KMutableList)) {
            TypeIntrinsics.throwCce(arrayList, "kotlin.collections.MutableList");
            throw null;
        }
        this.phase = phase;
        this.relation = relation;
        this.interceptors = arrayList;
        this.shared = true;
        if (!arrayList.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified".toString());
        }
    }

    public final void addInterceptor(Function3<? super PipelineContext<TSubject, Call>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        if (this.shared) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.interceptors);
            this.interceptors = arrayList;
            this.shared = false;
        }
        this.interceptors.add(function3);
    }

    public final String toString() {
        return "Phase `" + this.phase.name + "`, " + this.interceptors.size() + " handlers";
    }
}
