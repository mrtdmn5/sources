package io.ktor.client.request;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;

/* compiled from: HttpRequestPipeline.kt */
/* loaded from: classes3.dex */
public final class HttpRequestPipeline extends Pipeline<Object, HttpRequestBuilder> {
    public final boolean developmentMode;
    public static final PipelinePhase Before = new PipelinePhase("Before");
    public static final PipelinePhase State = new PipelinePhase("State");
    public static final PipelinePhase Transform = new PipelinePhase("Transform");
    public static final PipelinePhase Render = new PipelinePhase("Render");
    public static final PipelinePhase Send = new PipelinePhase("Send");

    public HttpRequestPipeline(boolean z) {
        super(Before, State, Transform, Render, Send);
        this.developmentMode = z;
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }
}
