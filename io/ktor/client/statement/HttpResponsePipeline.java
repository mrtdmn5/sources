package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;

/* compiled from: HttpResponsePipeline.kt */
/* loaded from: classes3.dex */
public final class HttpResponsePipeline extends Pipeline<HttpResponseContainer, HttpClientCall> {
    public final boolean developmentMode;
    public static final PipelinePhase Receive = new PipelinePhase("Receive");
    public static final PipelinePhase Parse = new PipelinePhase("Parse");
    public static final PipelinePhase Transform = new PipelinePhase("Transform");
    public static final PipelinePhase State = new PipelinePhase("State");
    public static final PipelinePhase After = new PipelinePhase("After");

    public HttpResponsePipeline(boolean z) {
        super(Receive, Parse, Transform, State, After);
        this.developmentMode = z;
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }
}
