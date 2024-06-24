package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.tracing.TraceSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OkHttpUtils.kt */
/* loaded from: classes.dex */
public final class SdkRequestTag {
    public final ExecutionContext execContext;
    public final TraceSpan traceSpan;

    public SdkRequestTag(ExecutionContext executionContext, TraceSpan traceSpan) {
        Intrinsics.checkNotNullParameter(traceSpan, "traceSpan");
        this.execContext = executionContext;
        this.traceSpan = traceSpan;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SdkRequestTag)) {
            return false;
        }
        SdkRequestTag sdkRequestTag = (SdkRequestTag) obj;
        if (Intrinsics.areEqual(this.execContext, sdkRequestTag.execContext) && Intrinsics.areEqual(this.traceSpan, sdkRequestTag.traceSpan)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.traceSpan.hashCode() + (this.execContext.hashCode() * 31);
    }

    public final String toString() {
        return "SdkRequestTag(execContext=" + this.execContext + ", traceSpan=" + this.traceSpan + ')';
    }
}
