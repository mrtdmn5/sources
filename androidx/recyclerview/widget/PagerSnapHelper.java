package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class PagerSnapHelper extends SnapHelper {
    public OrientationHelper.AnonymousClass1 mHorizontalHelper;
    public OrientationHelper.AnonymousClass2 mVerticalHelper;

    public static int distanceToCenter(View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view)) - ((orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding());
    }

    public static View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int totalSpace = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        int r2 = Integer.MAX_VALUE;
        for (int r4 = 0; r4 < childCount; r4++) {
            View childAt = layoutManager.getChildAt(r4);
            int abs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - totalSpace);
            if (abs < r2) {
                view = childAt;
                r2 = abs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] r0 = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            r0[0] = distanceToCenter(view, getHorizontalHelper(layoutManager));
        } else {
            r0[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            r0[1] = distanceToCenter(view, getVerticalHelper(layoutManager));
        } else {
            r0[1] = 0;
        }
        return r0;
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper.AnonymousClass1 anonymousClass1 = this.mHorizontalHelper;
        if (anonymousClass1 == null || anonymousClass1.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = new OrientationHelper.AnonymousClass1(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper.AnonymousClass2 anonymousClass2 = this.mVerticalHelper;
        if (anonymousClass2 == null || anonymousClass2.mLayoutManager != layoutManager) {
            this.mVerticalHelper = new OrientationHelper.AnonymousClass2(layoutManager);
        }
        return this.mVerticalHelper;
    }
}
