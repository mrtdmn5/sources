package io.ktor.client.statement;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Unit;

/* compiled from: HttpResponsePipeline.kt */
/* loaded from: classes3.dex */
public final class HttpReceivePipeline extends Pipeline<HttpResponse, Unit> {
    public final boolean developmentMode;
    public static final PipelinePhase Before = new PipelinePhase("Before");
    public static final PipelinePhase State = new PipelinePhase("State");
    public static final PipelinePhase After = new PipelinePhase("After");

    public HttpReceivePipeline(boolean z) {
        super(Before, State, After);
        this.developmentMode = z;
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }
}
