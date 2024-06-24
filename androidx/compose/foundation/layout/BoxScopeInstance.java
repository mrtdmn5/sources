package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Box.kt */
/* loaded from: classes.dex */
public final class BoxScopeInstance implements BoxScope {
    public static final BoxScopeInstance INSTANCE = new BoxScopeInstance();

    @Override // androidx.compose.foundation.layout.BoxScope
    public final Modifier align(Modifier modifier, BiasAlignment biasAlignment) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return modifier.then(new BoxChildDataElement(biasAlignment, false));
    }

    public final Modifier matchParentSize() {
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return new BoxChildDataElement(biasAlignment, true);
    }
}
