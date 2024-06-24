package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutId.kt */
/* loaded from: classes.dex */
public final class LayoutIdKt {
    public static final Object getLayoutId(Measurable measurable) {
        LayoutIdParentData layoutIdParentData;
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Object parentData = measurable.getParentData();
        if (parentData instanceof LayoutIdParentData) {
            layoutIdParentData = (LayoutIdParentData) parentData;
        } else {
            layoutIdParentData = null;
        }
        if (layoutIdParentData == null) {
            return null;
        }
        return layoutIdParentData.getLayoutId();
    }

    public static final Modifier layoutId(String str) {
        return new LayoutIdElement(str);
    }
}
