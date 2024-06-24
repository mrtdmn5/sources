package aws.smithy.kotlin.runtime.tracing;

import aws.smithy.kotlin.runtime.tracing.LoggingTraceProbeKt;
import aws.smithy.kotlin.runtime.tracing.TraceEventData;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mu.internal.LocationAwareKLogger;
import mu.internal.LocationIgnorantKLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/* compiled from: LoggingTraceProbe.kt */
/* loaded from: classes.dex */
public final class LoggingTraceProbe implements TraceProbe {
    public static final LoggingTraceProbe INSTANCE = new LoggingTraceProbe();

    @Override // aws.smithy.kotlin.runtime.tracing.TraceProbe
    public final void postEvent(TraceSpan span, TraceEvent traceEvent) {
        Logger locationIgnorantKLogger;
        Function3 function3;
        Function2 function2;
        Intrinsics.checkNotNullParameter(span, "span");
        TraceEventData traceEventData = traceEvent.data;
        if (traceEventData instanceof TraceEventData.Message) {
            final String hierarchicalId = LoggingTraceProbeKt.getHierarchicalId(span);
            final TraceEventData.Message message = (TraceEventData.Message) traceEventData;
            String name = traceEvent.sourceComponent;
            Intrinsics.checkNotNullParameter(name, "name");
            Logger logger = LoggerFactory.getLogger(name);
            Intrinsics.checkNotNullExpressionValue(logger, "LoggerFactory.getLogger(name)");
            if (logger instanceof LocationAwareLogger) {
                locationIgnorantKLogger = new LocationAwareKLogger((LocationAwareLogger) logger);
            } else {
                locationIgnorantKLogger = new LocationIgnorantKLogger(logger);
            }
            Throwable th = message.exception;
            EventLevel eventLevel = traceEvent.level;
            if (th == null) {
                switch (LoggingTraceProbeKt.WhenMappings.$EnumSwitchMapping$0[eventLevel.ordinal()]) {
                    case 1:
                    case 2:
                        function2 = LoggingTraceProbeKt$loggerMethod$1.INSTANCE;
                        break;
                    case 3:
                        function2 = LoggingTraceProbeKt$loggerMethod$2.INSTANCE;
                        break;
                    case 4:
                        function2 = LoggingTraceProbeKt$loggerMethod$3.INSTANCE;
                        break;
                    case 5:
                        function2 = LoggingTraceProbeKt$loggerMethod$4.INSTANCE;
                        break;
                    case 6:
                        function2 = LoggingTraceProbeKt$loggerMethod$5.INSTANCE;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                function2.invoke(locationIgnorantKLogger, new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.tracing.LoggingTraceProbe$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return hierarchicalId + ": " + message.content.invoke();
                    }
                });
                return;
            }
            switch (LoggingTraceProbeKt.WhenMappings.$EnumSwitchMapping$0[eventLevel.ordinal()]) {
                case 1:
                case 2:
                    function3 = LoggingTraceProbeKt$throwableLoggerMethod$1.INSTANCE;
                    break;
                case 3:
                    function3 = LoggingTraceProbeKt$throwableLoggerMethod$2.INSTANCE;
                    break;
                case 4:
                    function3 = LoggingTraceProbeKt$throwableLoggerMethod$3.INSTANCE;
                    break;
                case 5:
                    function3 = LoggingTraceProbeKt$throwableLoggerMethod$4.INSTANCE;
                    break;
                case 6:
                    function3 = LoggingTraceProbeKt$throwableLoggerMethod$5.INSTANCE;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            function3.invoke(locationIgnorantKLogger, message.exception, new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.tracing.LoggingTraceProbe$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return hierarchicalId + ": " + message.content.invoke();
                }
            });
        }
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceProbe
    public final void spanClosed(TraceSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
    }
}
