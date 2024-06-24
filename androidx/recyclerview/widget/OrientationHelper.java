package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class OrientationHelper {
    public final RecyclerView.LayoutManager mLayoutManager;
    public int mLastTotalSpace = Integer.MIN_VALUE;
    public final Rect mTmpRect = new Rect();

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends OrientationHelper {
        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedEnd(View view) {
            return this.mLayoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedMeasurement(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedMeasurementInOther(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedStart(View view) {
            return this.mLayoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEnd() {
            return this.mLayoutManager.getWidth();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEndAfterPadding() {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            return layoutManager.getWidth() - layoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEndPadding() {
            return this.mLayoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getMode() {
            return this.mLayoutManager.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getModeInOther() {
            return this.mLayoutManager.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTotalSpace() {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            return (layoutManager.getWidth() - layoutManager.getPaddingLeft()) - layoutManager.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTransformedEndWithDecoration(View view) {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            Rect rect = this.mTmpRect;
            layoutManager.getTransformedBoundingBox(view, true, rect);
            return rect.right;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTransformedStartWithDecoration(View view) {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            Rect rect = this.mTmpRect;
            layoutManager.getTransformedBoundingBox(view, true, rect);
            return rect.left;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final void offsetChildren(int r2) {
            this.mLayoutManager.offsetChildrenHorizontal(r2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 extends OrientationHelper {
        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedEnd(View view) {
            return this.mLayoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedMeasurement(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedMeasurementInOther(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedStart(View view) {
            return this.mLayoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEnd() {
            return this.mLayoutManager.getHeight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEndAfterPadding() {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            return layoutManager.getHeight() - layoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEndPadding() {
            return this.mLayoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getMode() {
            return this.mLayoutManager.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getModeInOther() {
            return this.mLayoutManager.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getStartAfterPadding() {
            return this.mLayoutManager.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTotalSpace() {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            return (layoutManager.getHeight() - layoutManager.getPaddingTop()) - layoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTransformedEndWithDecoration(View view) {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            Rect rect = this.mTmpRect;
            layoutManager.getTransformedBoundingBox(view, true, rect);
            return rect.bottom;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTransformedStartWithDecoration(View view) {
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            Rect rect = this.mTmpRect;
            layoutManager.getTransformedBoundingBox(view, true, rect);
            return rect.top;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final void offsetChildren(int r2) {
            this.mLayoutManager.offsetChildrenVertical(r2);
        }
    }

    public OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutManager, int r2) {
        if (r2 != 0) {
            if (r2 == 1) {
                return new AnonymousClass2(layoutManager);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new AnonymousClass1(layoutManager);
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChildren(int r1);
}
