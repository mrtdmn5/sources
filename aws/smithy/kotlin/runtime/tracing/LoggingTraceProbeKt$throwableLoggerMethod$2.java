package aws.smithy.kotlin.runtime.tracing;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;

/* compiled from: LoggingTraceProbe.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class LoggingTraceProbeKt$throwableLoggerMethod$2 extends FunctionReferenceImpl implements Function3<KLogger, Throwable, Function0<? extends Object>, Unit> {
    public static final LoggingTraceProbeKt$throwableLoggerMethod$2 INSTANCE = new LoggingTraceProbeKt$throwableLoggerMethod$2();

    public LoggingTraceProbeKt$throwableLoggerMethod$2() {
        super(3, KLogger.class, "warn", "warn(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(KLogger kLogger, Throwable th, Function0<? extends Object> function0) {
        KLogger p0 = kLogger;
        Function0<? extends Object> p2 = function0;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p2, "p2");
        p0.warn(th, p2);
        return Unit.INSTANCE;
    }
}
