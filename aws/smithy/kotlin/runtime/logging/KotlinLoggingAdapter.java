package aws.smithy.kotlin.runtime.logging;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.internal.LocationAwareKLogger;
import mu.internal.LocationIgnorantKLogger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/* compiled from: KotlinLoggingAdapter.kt */
/* loaded from: classes.dex */
public final class KotlinLoggingAdapter implements Logger {
    public final KLogger log;

    public KotlinLoggingAdapter(String str) {
        KLogger locationIgnorantKLogger;
        org.slf4j.Logger logger = LoggerFactory.getLogger(str);
        Intrinsics.checkNotNullExpressionValue(logger, "LoggerFactory.getLogger(name)");
        if (logger instanceof LocationAwareLogger) {
            locationIgnorantKLogger = new LocationAwareKLogger((LocationAwareLogger) logger);
        } else {
            locationIgnorantKLogger = new LocationIgnorantKLogger(logger);
        }
        this.log = locationIgnorantKLogger;
    }

    @Override // aws.smithy.kotlin.runtime.logging.Logger
    public final void debug(Function0<? extends Object> function0) {
        this.log.debug(function0);
    }

    public final void warn(LoggerKt$warn$1 loggerKt$warn$1) {
        this.log.warn(loggerKt$warn$1);
    }
}
