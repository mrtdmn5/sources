package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int resolveMinimumHeight(View view) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int minimumHeight = ViewCompat.Api16Impl.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            r9 = this;
            int r10 = r9.getPaddingLeft()
            int r13 = r13 - r11
            int r11 = r9.getPaddingRight()
            int r11 = r13 - r11
            int r13 = r13 - r10
            int r0 = r9.getPaddingRight()
            int r13 = r13 - r0
            int r0 = r9.getMeasuredHeight()
            int r1 = r9.getChildCount()
            int r2 = r9.getGravity()
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L39
            r4 = 80
            if (r3 == r4) goto L30
            int r12 = r9.getPaddingTop()
            goto L43
        L30:
            int r3 = r9.getPaddingTop()
            int r3 = r3 + r14
            int r3 = r3 - r12
            int r12 = r3 - r0
            goto L43
        L39:
            int r3 = r9.getPaddingTop()
            int r14 = r14 - r12
            int r14 = r14 - r0
            int r14 = r14 / 2
            int r12 = r14 + r3
        L43:
            android.graphics.drawable.Drawable r14 = r9.getDividerDrawable()
            r0 = 0
            if (r14 != 0) goto L4c
            r14 = r0
            goto L50
        L4c:
            int r14 = r14.getIntrinsicHeight()
        L50:
            if (r0 >= r1) goto Lb1
            android.view.View r3 = r9.getChildAt(r0)
            if (r3 == 0) goto Lae
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 == r5) goto Lae
            int r4 = r3.getMeasuredWidth()
            int r5 = r3.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r6 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r6
            int r7 = r6.gravity
            if (r7 >= 0) goto L73
            r7 = r2
        L73:
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r8 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            int r8 = androidx.core.view.ViewCompat.Api17Impl.getLayoutDirection(r9)
            int r7 = android.view.Gravity.getAbsoluteGravity(r7, r8)
            r7 = r7 & 7
            r8 = 1
            if (r7 == r8) goto L8e
            r8 = 5
            if (r7 == r8) goto L89
            int r7 = r6.leftMargin
            int r7 = r7 + r10
            goto L99
        L89:
            int r7 = r11 - r4
            int r8 = r6.rightMargin
            goto L98
        L8e:
            int r7 = r13 - r4
            int r7 = r7 / 2
            int r7 = r7 + r10
            int r8 = r6.leftMargin
            int r7 = r7 + r8
            int r8 = r6.rightMargin
        L98:
            int r7 = r7 - r8
        L99:
            boolean r8 = r9.hasDividerBeforeChildAt(r0)
            if (r8 == 0) goto La0
            int r12 = r12 + r14
        La0:
            int r8 = r6.topMargin
            int r12 = r12 + r8
            int r4 = r4 + r7
            int r8 = r5 + r12
            r3.layout(r7, r12, r4, r8)
            int r3 = r6.bottomMargin
            int r5 = r5 + r3
            int r5 = r5 + r12
            r12 = r5
        Lae:
            int r0 = r0 + 1
            goto L50
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int r17, int r18) {
        int r0;
        int r11;
        int r13;
        int r14;
        int makeMeasureSpec;
        int childCount = getChildCount();
        View view = null;
        boolean z = false;
        View view2 = null;
        View view3 = null;
        for (int r4 = 0; r4 < childCount; r4++) {
            View childAt = getChildAt(r4);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    break;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(r18);
        int size = View.MeasureSpec.getSize(r18);
        int mode2 = View.MeasureSpec.getMode(r17);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(r17, 0);
            paddingBottom += view.getMeasuredHeight();
            r0 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            r0 = 0;
        }
        if (view2 != null) {
            view2.measure(r17, 0);
            r11 = resolveMinimumHeight(view2);
            r13 = view2.getMeasuredHeight() - r11;
            paddingBottom += r11;
            r0 = View.combineMeasuredStates(r0, view2.getMeasuredState());
        } else {
            r11 = 0;
            r13 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                makeMeasureSpec = 0;
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode);
            }
            view3.measure(r17, makeMeasureSpec);
            r14 = view3.getMeasuredHeight();
            paddingBottom += r14;
            r0 = View.combineMeasuredStates(r0, view3.getMeasuredState());
        } else {
            r14 = 0;
        }
        int r5 = size - paddingBottom;
        if (view2 != null) {
            int r12 = paddingBottom - r11;
            int min = Math.min(r5, r13);
            if (min > 0) {
                r5 -= min;
                r11 += min;
            }
            view2.measure(r17, View.MeasureSpec.makeMeasureSpec(r11, 1073741824));
            paddingBottom = r12 + view2.getMeasuredHeight();
            r0 = View.combineMeasuredStates(r0, view2.getMeasuredState());
        }
        if (view3 != null && r5 > 0) {
            view3.measure(r17, View.MeasureSpec.makeMeasureSpec(r14 + r5, mode));
            paddingBottom = (paddingBottom - r14) + view3.getMeasuredHeight();
            r0 = View.combineMeasuredStates(r0, view3.getMeasuredState());
        }
        int r3 = 0;
        for (int r2 = 0; r2 < childCount; r2++) {
            View childAt2 = getChildAt(r2);
            if (childAt2.getVisibility() != 8) {
                r3 = Math.max(r3, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + r3, r17, r0), View.resolveSizeAndState(paddingBottom, r18, 0));
        if (mode2 != 1073741824) {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            for (int r122 = 0; r122 < childCount; r122++) {
                View childAt3 = getChildAt(r122);
                if (childAt3.getVisibility() != 8) {
                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt3.getLayoutParams();
                    if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                        int r142 = ((LinearLayout.LayoutParams) layoutParams).height;
                        ((LinearLayout.LayoutParams) layoutParams).height = childAt3.getMeasuredHeight();
                        measureChildWithMargins(childAt3, makeMeasureSpec2, 0, r18, 0);
                        ((LinearLayout.LayoutParams) layoutParams).height = r142;
                    }
                }
            }
        }
        z = true;
        if (!z) {
            super.onMeasure(r17, r18);
        }
    }
}
