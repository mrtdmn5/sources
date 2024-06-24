package kotlinx.coroutines.flow;

import com.google.android.gms.measurement.internal.zzgp;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public final class StateFlowKt {
    public static final Symbol NONE = new Symbol("NONE");
    public static final Symbol PENDING = new Symbol("PENDING");

    public static final StateFlowImpl MutableStateFlow(Object obj) {
        if (obj == null) {
            obj = zzgp.NULL;
        }
        return new StateFlowImpl(obj);
    }
}
