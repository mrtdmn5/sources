package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Background.kt */
/* loaded from: classes.dex */
public final class BackgroundKt {
    /* renamed from: background-bw27NRU, reason: not valid java name */
    public static final Modifier m21backgroundbw27NRU(Modifier background, long j, Shape shape) {
        Intrinsics.checkNotNullParameter(background, "$this$background");
        Intrinsics.checkNotNullParameter(shape, "shape");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return background.then(new BackgroundElement(j, shape));
    }

    /* renamed from: background-bw27NRU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m22backgroundbw27NRU$default(Modifier modifier, long j) {
        return m21backgroundbw27NRU(modifier, j, RectangleShapeKt.RectangleShape);
    }
}
