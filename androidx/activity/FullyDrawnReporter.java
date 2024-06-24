package androidx.activity;

import androidx.activity.ComponentActivity;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullyDrawnReporter.kt */
/* loaded from: classes.dex */
public final class FullyDrawnReporter {
    public final Object lock;
    public final ArrayList onReportCallbacks;
    public final Function0<Unit> reportFullyDrawn;
    public boolean reportedFullyDrawn;

    public FullyDrawnReporter(ComponentActivity.ReportFullyDrawnExecutor executor, ComponentActivity$$ExternalSyntheticLambda1 componentActivity$$ExternalSyntheticLambda1) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.reportFullyDrawn = componentActivity$$ExternalSyntheticLambda1;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
    }
}
