package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LayoutNode$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        boolean z;
        LayoutNode layoutNode = (LayoutNode) obj;
        LayoutNode layoutNode2 = (LayoutNode) obj2;
        float f = layoutNode.layoutDelegate.measurePassDelegate.zIndex;
        float f2 = layoutNode2.layoutDelegate.measurePassDelegate.zIndex;
        if (f == f2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Intrinsics.compare(layoutNode.getPlaceOrder$ui_release(), layoutNode2.getPlaceOrder$ui_release());
        }
        return Float.compare(f, f2);
    }
}
