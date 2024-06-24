package io.ktor.util.pipeline;

/* compiled from: PipelinePhaseRelation.kt */
/* loaded from: classes3.dex */
public abstract class PipelinePhaseRelation {

    /* compiled from: PipelinePhaseRelation.kt */
    /* loaded from: classes3.dex */
    public static final class After extends PipelinePhaseRelation {
        public final PipelinePhase relativeTo;

        public After(PipelinePhase pipelinePhase) {
            this.relativeTo = pipelinePhase;
        }
    }

    /* compiled from: PipelinePhaseRelation.kt */
    /* loaded from: classes3.dex */
    public static final class Before extends PipelinePhaseRelation {
        public Before(PipelinePhase pipelinePhase) {
        }
    }

    /* compiled from: PipelinePhaseRelation.kt */
    /* loaded from: classes3.dex */
    public static final class Last extends PipelinePhaseRelation {
        public static final Last INSTANCE = new Last();
    }
}
