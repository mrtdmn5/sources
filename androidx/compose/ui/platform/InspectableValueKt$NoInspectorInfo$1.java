package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: InspectableValue.kt */
/* loaded from: classes.dex */
public final class InspectableValueKt$NoInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    public static final InspectableValueKt$NoInspectorInfo$1 INSTANCE = new InspectableValueKt$NoInspectorInfo$1();

    public InspectableValueKt$NoInspectorInfo$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        return Unit.INSTANCE;
    }
}
