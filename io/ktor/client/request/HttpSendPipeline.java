package io.ktor.client.request;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;

/* compiled from: HttpRequestPipeline.kt */
/* loaded from: classes3.dex */
public final class HttpSendPipeline extends Pipeline<Object, HttpRequestBuilder> {
    public final boolean developmentMode;
    public static final PipelinePhase Before = new PipelinePhase("Before");
    public static final PipelinePhase State = new PipelinePhase("State");
    public static final PipelinePhase Monitoring = new PipelinePhase("Monitoring");
    public static final PipelinePhase Engine = new PipelinePhase("Engine");
    public static final PipelinePhase Receive = new PipelinePhase("Receive");

    public HttpSendPipeline(boolean z) {
        super(Before, State, Monitoring, Engine, Receive);
        this.developmentMode = z;
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }
}
