package androidx.compose.ui.platform;

import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Wrapper.android.kt */
/* loaded from: classes.dex */
public final class WrapperVerificationHelperMethods {
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    public final Map<Integer, Integer> attributeSourceResourceMap(View view) {
        Map<Integer, Integer> attributeSourceResourceMap;
        Intrinsics.checkNotNullParameter(view, "view");
        attributeSourceResourceMap = view.getAttributeSourceResourceMap();
        Intrinsics.checkNotNullExpressionValue(attributeSourceResourceMap, "view.attributeSourceResourceMap");
        return attributeSourceResourceMap;
    }
}
