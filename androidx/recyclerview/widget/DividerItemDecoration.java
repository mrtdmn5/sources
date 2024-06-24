package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int[] ATTRS = {R.attr.listDivider};
    public final Rect mBounds = new Rect();
    public final Drawable mDivider;
    public int mOrientation;

    public DividerItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.mDivider = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        this.mOrientation = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view) {
        Drawable drawable = this.mDivider;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView) {
        Drawable drawable;
        int height;
        int r1;
        int width;
        int r12;
        if (recyclerView.getLayoutManager() != null && (drawable = this.mDivider) != null) {
            int r13 = this.mOrientation;
            Rect rect = this.mBounds;
            int r4 = 0;
            if (r13 == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    r12 = recyclerView.getPaddingLeft();
                    width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(r12, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    width = recyclerView.getWidth();
                    r12 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (r4 < childCount) {
                    View childAt = recyclerView.getChildAt(r4);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                    int round = Math.round(childAt.getTranslationY()) + rect.bottom;
                    drawable.setBounds(r12, round - drawable.getIntrinsicHeight(), width, round);
                    drawable.draw(canvas);
                    r4++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                r1 = recyclerView.getPaddingTop();
                height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), r1, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
            } else {
                height = recyclerView.getHeight();
                r1 = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (r4 < childCount2) {
                View childAt2 = recyclerView.getChildAt(r4);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, rect);
                int round2 = Math.round(childAt2.getTranslationX()) + rect.right;
                drawable.setBounds(round2 - drawable.getIntrinsicWidth(), r1, round2, height);
                drawable.draw(canvas);
                r4++;
            }
            canvas.restore();
        }
    }
}
