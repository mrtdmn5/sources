package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipScrollableContainer.kt */
/* loaded from: classes.dex */
public final class ClipScrollableContainerKt {
    public static final Modifier HorizontalScrollableClipModifier;
    public static final float MaxSupportedElevation = 30;
    public static final Modifier VerticalScrollableClipModifier;

    static {
        int r0 = Modifier.$r8$clinit;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        HorizontalScrollableClipModifier = ClipKt.clip(companion, new ClipScrollableContainerKt$HorizontalScrollableClipModifier$1());
        VerticalScrollableClipModifier = ClipKt.clip(companion, new ClipScrollableContainerKt$VerticalScrollableClipModifier$1());
    }

    public static final Modifier clipScrollableContainer(Modifier modifier, Orientation orientation) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Vertical) {
            modifier2 = VerticalScrollableClipModifier;
        } else {
            modifier2 = HorizontalScrollableClipModifier;
        }
        return modifier.then(modifier2);
    }
}
