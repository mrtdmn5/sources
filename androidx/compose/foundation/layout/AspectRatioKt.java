package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AspectRatio.kt */
/* loaded from: classes.dex */
public final class AspectRatioKt {
    public static Modifier aspectRatio$default(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return modifier.then(new AspectRatioElement(f, false));
    }
}
