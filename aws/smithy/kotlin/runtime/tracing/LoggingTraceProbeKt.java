package aws.smithy.kotlin.runtime.tracing;

/* compiled from: LoggingTraceProbe.kt */
/* loaded from: classes.dex */
public final class LoggingTraceProbeKt {

    /* compiled from: LoggingTraceProbe.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[EventLevel.values().length];
            try {
                r0[EventLevel.Fatal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[EventLevel.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[EventLevel.Warning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[EventLevel.Info.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[EventLevel.Debug.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[EventLevel.Trace.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:            if (r1 == null) goto L6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String getHierarchicalId(aws.smithy.kotlin.runtime.tracing.TraceSpan r3) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            aws.smithy.kotlin.runtime.tracing.TraceSpan r1 = r3.getParent()
            if (r1 == 0) goto L22
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = getHierarchicalId(r1)
            r2.append(r1)
            r1 = 47
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L24
        L22:
            java.lang.String r1 = ""
        L24:
            r0.append(r1)
            java.lang.String r3 = r3.getId()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.tracing.LoggingTraceProbeKt.getHierarchicalId(aws.smithy.kotlin.runtime.tracing.TraceSpan):java.lang.String");
    }
}
