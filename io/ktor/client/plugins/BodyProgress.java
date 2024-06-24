package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.PhaseContent;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyProgress.kt */
/* loaded from: classes3.dex */
public final class BodyProgress {
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<BodyProgress> key = new AttributeKey<>("BodyProgress");

    /* compiled from: BodyProgress.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Unit, BodyProgress> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<BodyProgress> getKey() {
            return BodyProgress.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            PhaseContent phaseContent;
            PipelinePhaseRelation pipelinePhaseRelation;
            PipelinePhaseRelation.After after;
            PipelinePhase pipelinePhase;
            BodyProgress plugin = (BodyProgress) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            PipelinePhase pipelinePhase2 = new PipelinePhase("ObservableContent");
            HttpRequestPipeline httpRequestPipeline = scope.requestPipeline;
            httpRequestPipeline.getClass();
            PipelinePhase reference = HttpRequestPipeline.Render;
            Intrinsics.checkNotNullParameter(reference, "reference");
            if (!httpRequestPipeline.hasPhase(pipelinePhase2)) {
                int findPhaseIndex = httpRequestPipeline.findPhaseIndex(reference);
                if (findPhaseIndex != -1) {
                    int r4 = findPhaseIndex + 1;
                    ArrayList arrayList = httpRequestPipeline.phasesRaw;
                    int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                    if (r4 <= lastIndex) {
                        while (true) {
                            Object obj2 = arrayList.get(r4);
                            if (obj2 instanceof PhaseContent) {
                                phaseContent = (PhaseContent) obj2;
                            } else {
                                phaseContent = null;
                            }
                            if (phaseContent != null && (pipelinePhaseRelation = phaseContent.relation) != null) {
                                if (pipelinePhaseRelation instanceof PipelinePhaseRelation.After) {
                                    after = (PipelinePhaseRelation.After) pipelinePhaseRelation;
                                } else {
                                    after = null;
                                }
                                if (after != null && (pipelinePhase = after.relativeTo) != null && Intrinsics.areEqual(pipelinePhase, reference)) {
                                    findPhaseIndex = r4;
                                }
                                if (r4 == lastIndex) {
                                    break;
                                } else {
                                    r4++;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    arrayList.add(findPhaseIndex + 1, new PhaseContent(pipelinePhase2, new PipelinePhaseRelation.After(reference)));
                } else {
                    throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
                }
            }
            httpRequestPipeline.intercept(pipelinePhase2, new BodyProgress$handle$1(null));
            scope.receivePipeline.intercept(HttpReceivePipeline.After, new BodyProgress$handle$2(null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final BodyProgress prepare(Function1<? super Unit, Unit> function1) {
            return new BodyProgress();
        }
    }
}
