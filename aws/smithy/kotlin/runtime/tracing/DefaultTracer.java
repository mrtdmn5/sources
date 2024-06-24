package aws.smithy.kotlin.runtime.tracing;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DefaultTracer.kt */
/* loaded from: classes.dex */
public final class DefaultTracer {
    public final TraceProbe probe = LoggingTraceProbe.INSTANCE;
    public final String rootPrefix;

    public DefaultTracer(String str) {
        this.rootPrefix = str;
    }

    public final DefaultTraceSpan createRootSpan(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        String str = this.rootPrefix;
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            id = str + '-' + id;
        }
        return new DefaultTraceSpan(this.probe, null, id);
    }
}
