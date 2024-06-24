package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnRemeasuredModifier.kt */
/* loaded from: classes.dex */
public final class OnRemeasuredModifierKt {
    public static final Modifier onSizeChanged(Modifier modifier, Function1<? super IntSize, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return modifier.then(new OnSizeChangedModifier(function1));
    }
}
