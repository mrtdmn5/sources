package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class ViewParentCompat$Api21Impl {
    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return viewParent.onNestedFling(view, f, f2, z);
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        return viewParent.onNestedPreFling(view, f, f2);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int r2, int r3, int[] r4) {
        viewParent.onNestedPreScroll(view, r2, r3, r4);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int r2, int r3, int r4, int r5) {
        viewParent.onNestedScroll(view, r2, r3, r4, r5);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int r3) {
        viewParent.onNestedScrollAccepted(view, view2, r3);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int r3) {
        return viewParent.onStartNestedScroll(view, view2, r3);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
