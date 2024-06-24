package androidx.compose.ui.graphics.colorspace;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda0 implements DoubleFunction, SuccessContinuation {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda0(Object obj) {
        this.f$0 = obj;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        Rgb this$0 = (Rgb) this.f$0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return RangesKt___RangesKt.coerceIn(this$0.oetfOrig.invoke(d), this$0.min, this$0.max);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) this.f$0;
        int[] r2 = ConfigFetchHandler.BACKOFF_TIME_DURATIONS_IN_MINUTES;
        return Tasks.forResult(fetchResponse);
    }
}
