package androidx.transition;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ViewUtils {
    public static final ViewUtilsApi23 IMPL;
    public static final AnonymousClass1 TRANSITION_ALPHA;

    /* renamed from: androidx.transition.ViewUtils$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 extends Property<View, Float> {
        @Override // android.util.Property
        public final Float get(View view) {
            return Float.valueOf(ViewUtils.IMPL.getTransitionAlpha(view));
        }

        @Override // android.util.Property
        public final void set(View view, Float f) {
            float floatValue = f.floatValue();
            ViewUtils.IMPL.setTransitionAlpha(view, floatValue);
        }
    }

    /* renamed from: androidx.transition.ViewUtils$2 */
    /* loaded from: classes.dex */
    public static class AnonymousClass2 extends Property<View, Rect> {
        @Override // android.util.Property
        public final Rect get(View view) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return ViewCompat.Api18Impl.getClipBounds(view);
        }

        @Override // android.util.Property
        public final void set(View view, Rect rect) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api18Impl.setClipBounds(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            IMPL = new ViewUtilsApi23();
        }
        TRANSITION_ALPHA = new Property<View, Float>() { // from class: androidx.transition.ViewUtils.1
            @Override // android.util.Property
            public final Float get(View view) {
                return Float.valueOf(ViewUtils.IMPL.getTransitionAlpha(view));
            }

            @Override // android.util.Property
            public final void set(View view, Float f) {
                float floatValue = f.floatValue();
                ViewUtils.IMPL.setTransitionAlpha(view, floatValue);
            }
        };
        new Property<View, Rect>() { // from class: androidx.transition.ViewUtils.2
            @Override // android.util.Property
            public final Rect get(View view) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                return ViewCompat.Api18Impl.getClipBounds(view);
            }

            @Override // android.util.Property
            public final void set(View view, Rect rect) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api18Impl.setClipBounds(view, rect);
            }
        };
    }

    public static void setLeftTopRightBottom(View view, int r7, int r8, int r9, int r10) {
        IMPL.setLeftTopRightBottom(view, r7, r8, r9, r10);
    }
}
