package aws.smithy.kotlin.runtime.tracing;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;

/* compiled from: LoggingTraceProbe.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class LoggingTraceProbeKt$loggerMethod$4 extends FunctionReferenceImpl implements Function2<KLogger, Function0<? extends Object>, Unit> {
    public static final LoggingTraceProbeKt$loggerMethod$4 INSTANCE = new LoggingTraceProbeKt$loggerMethod$4();

    public LoggingTraceProbeKt$loggerMethod$4() {
        super(2, KLogger.class, "debug", "debug(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(KLogger kLogger, Function0<? extends Object> function0) {
        KLogger p0 = kLogger;
        Function0<? extends Object> p1 = function0;
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        p0.debug(p1);
        return Unit.INSTANCE;
    }
}
