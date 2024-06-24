package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RippleContainer.android.kt */
/* loaded from: classes.dex */
public final class RippleHostMap {
    public final LinkedHashMap indicationToHostMap = new LinkedHashMap();
    public final LinkedHashMap hostToIndicationMap = new LinkedHashMap();

    public final void remove(AndroidRippleIndicationInstance indicationInstance) {
        Intrinsics.checkNotNullParameter(indicationInstance, "indicationInstance");
        LinkedHashMap linkedHashMap = this.indicationToHostMap;
        RippleHostView rippleHostView = (RippleHostView) linkedHashMap.get(indicationInstance);
        if (rippleHostView != null) {
        }
        linkedHashMap.remove(indicationInstance);
    }
}
