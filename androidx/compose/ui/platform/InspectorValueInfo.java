package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InspectableValue.kt */
/* loaded from: classes.dex */
public abstract class InspectorValueInfo {
    public final Function1<InspectorInfo, Unit> info;

    /* JADX WARN: Multi-variable type inference failed */
    public InspectorValueInfo(Function1<? super InspectorInfo, Unit> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.info = info;
    }
}
