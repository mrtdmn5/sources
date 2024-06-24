package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InspectableValue.kt */
/* loaded from: classes.dex */
public final class InspectableValueKt {
    public static final InspectableValueKt$NoInspectorInfo$1 NoInspectorInfo = InspectableValueKt$NoInspectorInfo$1.INSTANCE;
    public static final boolean isDebugInspectorInfoEnabled = false;

    public static final Modifier inspectableWrapper(Modifier modifier, Function1<? super InspectorInfo, Unit> inspectorInfo, Modifier wrapped) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        InspectableModifier inspectableModifier = new InspectableModifier(inspectorInfo);
        return modifier.then(inspectableModifier).then(wrapped).then(inspectableModifier.end);
    }
}
