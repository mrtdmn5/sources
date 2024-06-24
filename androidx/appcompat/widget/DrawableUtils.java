package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class DrawableUtils {
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();

    /* loaded from: classes.dex */
    public static class Api18Impl {
        public static final Field sBottom;
        public static final Method sGetOpticalInsets;
        public static final Field sLeft;
        public static final boolean sReflectionSuccessful;
        public static final Field sRight;
        public static final Field sTop;

        /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L40 java.lang.NoSuchMethodException -> L44
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L40 java.lang.NoSuchMethodException -> L44
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.NoSuchFieldException -> L3c java.lang.ClassNotFoundException -> L40 java.lang.NoSuchMethodException -> L44
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch: java.lang.NoSuchFieldException -> L36 java.lang.ClassNotFoundException -> L38 java.lang.NoSuchMethodException -> L3a
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch: java.lang.NoSuchFieldException -> L30 java.lang.ClassNotFoundException -> L32 java.lang.NoSuchMethodException -> L34
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch: java.lang.Throwable -> L2e
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch: java.lang.Throwable -> L48
                r8 = r0
                goto L4a
            L2e:
                r7 = r1
                goto L48
            L30:
                r6 = r1
                goto L47
            L32:
                r6 = r1
                goto L47
            L34:
                r6 = r1
                goto L47
            L36:
                r5 = r1
                goto L3e
            L38:
                r5 = r1
                goto L42
            L3a:
                r5 = r1
                goto L46
            L3c:
                r4 = r1
                r5 = r4
            L3e:
                r6 = r5
                goto L47
            L40:
                r4 = r1
                r5 = r4
            L42:
                r6 = r5
                goto L47
            L44:
                r4 = r1
                r5 = r4
            L46:
                r6 = r5
            L47:
                r7 = r6
            L48:
                r3 = r1
                r8 = r2
            L4a:
                if (r8 == 0) goto L59
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sGetOpticalInsets = r4
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sLeft = r5
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sTop = r6
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sRight = r7
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sBottom = r3
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sReflectionSuccessful = r0
                goto L65
            L59:
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sGetOpticalInsets = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sLeft = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sTop = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sRight = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sBottom = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.sReflectionSuccessful = r2
            L65:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.Api18Impl.<clinit>():void");
        }
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static Insets getOpticalInsets(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!canSafelyMutateDrawable(drawable2)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        if (drawable instanceof WrappedDrawable) {
            return canSafelyMutateDrawable(((WrappedDrawable) drawable).getWrappedDrawable());
        }
        if (drawable instanceof DrawableWrapper) {
            return canSafelyMutateDrawable(((DrawableWrapper) drawable).mDrawable);
        }
        if (drawable instanceof ScaleDrawable) {
            return canSafelyMutateDrawable(((ScaleDrawable) drawable).getDrawable());
        }
        return true;
    }

    public static void fixDrawable(Drawable drawable) {
        String name = drawable.getClass().getName();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 29 && r1 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state != null && state.length != 0) {
                drawable.setState(EMPTY_STATE_SET);
            } else {
                drawable.setState(CHECKED_STATE_SET);
            }
            drawable.setState(state);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect getOpticalBounds(Drawable drawable) {
        int r1;
        int r2;
        int r3;
        int r5;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 29) {
            Insets opticalInsets = Api29Impl.getOpticalInsets(drawable);
            r1 = opticalInsets.left;
            r2 = opticalInsets.top;
            r3 = opticalInsets.right;
            r5 = opticalInsets.bottom;
            return new Rect(r1, r2, r3, r5);
        }
        boolean z = drawable instanceof WrappedDrawable;
        Drawable drawable2 = drawable;
        if (z) {
            drawable2 = ((WrappedDrawable) drawable).getWrappedDrawable();
        }
        if (r0 < 29) {
            if (Api18Impl.sReflectionSuccessful) {
                try {
                    Object invoke = Api18Impl.sGetOpticalInsets.invoke(drawable2, new Object[0]);
                    if (invoke != null) {
                        return new Rect(Api18Impl.sLeft.getInt(invoke), Api18Impl.sTop.getInt(invoke), Api18Impl.sRight.getInt(invoke), Api18Impl.sBottom.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
        } else {
            boolean z2 = Api18Impl.sReflectionSuccessful;
        }
        return INSETS_NONE;
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
}
