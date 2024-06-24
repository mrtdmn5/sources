package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class ViewUtils {

    /* renamed from: com.google.android.material.internal.ViewUtils$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ View val$view;

        public AnonymousClass1(EditText editText) {
            r1 = editText;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = r1;
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    /* renamed from: com.google.android.material.internal.ViewUtils$3 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass3 implements androidx.core.view.OnApplyWindowInsetsListener {
        public final /* synthetic */ RelativePadding val$initialPadding;
        public final /* synthetic */ OnApplyWindowInsetsListener val$listener;

        public AnonymousClass3(BottomSheetBehavior.AnonymousClass3 anonymousClass3, RelativePadding relativePadding) {
            r1 = anonymousClass3;
            r2 = relativePadding;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
        @Override // androidx.core.view.OnApplyWindowInsetsListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r17, androidx.core.view.WindowInsetsCompat r18) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                r2 = r18
                com.google.android.material.internal.ViewUtils$RelativePadding r3 = r2
                int r4 = r3.start
                com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener r5 = r1
                com.google.android.material.bottomsheet.BottomSheetBehavior$3 r5 = (com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass3) r5
                r5.getClass()
                r6 = 7
                androidx.core.graphics.Insets r6 = r2.getInsets(r6)
                r7 = 32
                androidx.core.graphics.Insets r7 = r2.getInsets(r7)
                int r8 = r6.top
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r9.insetTop = r8
                boolean r8 = com.google.android.material.internal.ViewUtils.isLayoutRtl(r17)
                int r10 = r17.getPaddingBottom()
                int r11 = r17.getPaddingLeft()
                int r12 = r17.getPaddingRight()
                boolean r13 = r9.paddingBottomSystemWindowInsets
                if (r13 == 0) goto L3f
                int r10 = r18.getSystemWindowInsetBottom()
                r9.insetBottom = r10
                int r14 = r3.bottom
                int r10 = r10 + r14
            L3f:
                int r3 = r3.end
                boolean r14 = r9.paddingLeftSystemWindowInsets
                int r15 = r6.left
                if (r14 == 0) goto L4d
                if (r8 == 0) goto L4b
                r11 = r3
                goto L4c
            L4b:
                r11 = r4
            L4c:
                int r11 = r11 + r15
            L4d:
                boolean r14 = r9.paddingRightSystemWindowInsets
                int r0 = r6.right
                if (r14 == 0) goto L59
                if (r8 == 0) goto L56
                goto L57
            L56:
                r4 = r3
            L57:
                int r12 = r4 + r0
            L59:
                android.view.ViewGroup$LayoutParams r3 = r17.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
                boolean r4 = r9.marginLeftSystemWindowInsets
                r8 = 1
                if (r4 == 0) goto L6c
                int r4 = r3.leftMargin
                if (r4 == r15) goto L6c
                r3.leftMargin = r15
                r4 = r8
                goto L6d
            L6c:
                r4 = 0
            L6d:
                boolean r14 = r9.marginRightSystemWindowInsets
                if (r14 == 0) goto L78
                int r14 = r3.rightMargin
                if (r14 == r0) goto L78
                r3.rightMargin = r0
                r4 = r8
            L78:
                boolean r0 = r9.marginTopSystemWindowInsets
                if (r0 == 0) goto L85
                int r0 = r3.topMargin
                int r6 = r6.top
                if (r0 == r6) goto L85
                r3.topMargin = r6
                goto L86
            L85:
                r8 = r4
            L86:
                if (r8 == 0) goto L8b
                r1.setLayoutParams(r3)
            L8b:
                int r0 = r17.getPaddingTop()
                r1.setPadding(r11, r0, r12, r10)
                boolean r0 = r5.val$shouldHandleGestureInsets
                if (r0 == 0) goto L9a
                int r1 = r7.bottom
                r9.gestureInsetBottom = r1
            L9a:
                if (r13 != 0) goto L9e
                if (r0 == 0) goto La1
            L9e:
                r9.updatePeekHeight()
            La1:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ViewUtils.AnonymousClass3.onApplyWindowInsets(android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
        }
    }

    /* loaded from: classes3.dex */
    public interface OnApplyWindowInsetsListener {
    }

    /* loaded from: classes3.dex */
    public static class RelativePadding {
        public final int bottom;
        public final int end;
        public final int start;

        public RelativePadding(int r1, int r2, int r3, int r4) {
            this.start = r1;
            this.end = r3;
            this.bottom = r4;
        }
    }

    public static float dpToPx(Context context, int r2) {
        return TypedValue.applyDimension(1, r2, context.getResources().getDisplayMetrics());
    }

    public static boolean isLayoutRtl(View view) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api17Impl.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    public static PorterDuff.Mode parseTintMode(int r1, PorterDuff.Mode mode) {
        if (r1 != 3) {
            if (r1 != 5) {
                if (r1 != 9) {
                    switch (r1) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: com.google.android.material.internal.ViewUtils$4 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
