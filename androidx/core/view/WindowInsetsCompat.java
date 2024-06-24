package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.DrawableUtils$$ExternalSyntheticApiModelOutline1;
import androidx.appcompat.widget.DrawableUtils$$ExternalSyntheticApiModelOutline2;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat$Api19Impl;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED;
    public final Impl mImpl;

    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: classes.dex */
    public static class Api21ReflectionHolder {
        public static final Field sContentInsets;
        public static final boolean sReflectionSucceeded;
        public static final Field sStableInsets;
        public static final Field sViewAttachInfoField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
                sReflectionSucceeded = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BuilderImpl {
        public final WindowInsetsCompat mInsets;
        public Insets[] mInsetsTypeMask;

        public BuilderImpl() {
            this(new WindowInsetsCompat());
        }

        public final void applyInsetTypes() {
            Insets[] insetsArr = this.mInsetsTypeMask;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.indexOf(1)];
                Insets insets2 = this.mInsetsTypeMask[Type.indexOf(2)];
                WindowInsetsCompat windowInsetsCompat = this.mInsets;
                if (insets2 == null) {
                    insets2 = windowInsetsCompat.getInsets(2);
                }
                if (insets == null) {
                    insets = windowInsetsCompat.getInsets(1);
                }
                setSystemWindowInsets(Insets.max(insets, insets2));
                Insets insets3 = this.mInsetsTypeMask[Type.indexOf(16)];
                if (insets3 != null) {
                    setSystemGestureInsets(insets3);
                }
                Insets insets4 = this.mInsetsTypeMask[Type.indexOf(32)];
                if (insets4 != null) {
                    setMandatorySystemGestureInsets(insets4);
                }
                Insets insets5 = this.mInsetsTypeMask[Type.indexOf(64)];
                if (insets5 != null) {
                    setTappableElementInsets(insets5);
                }
            }
        }

        public WindowInsetsCompat build() {
            throw null;
        }

        public void setInsets(int r4, Insets insets) {
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[9];
            }
            for (int r0 = 1; r0 <= 256; r0 <<= 1) {
                if ((r4 & r0) != 0) {
                    this.mInsetsTypeMask[Type.indexOf(r0)] = insets;
                }
            }
        }

        public void setStableInsets(Insets insets) {
            throw null;
        }

        public void setSystemWindowInsets(Insets insets) {
            throw null;
        }

        public BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }

        public void setMandatorySystemGestureInsets(Insets insets) {
        }

        public void setSystemGestureInsets(Insets insets) {
        }

        public void setTappableElementInsets(Insets insets) {
        }
    }

    /* loaded from: classes.dex */
    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsets(int r2, Insets insets) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(r2), insets.toPlatformInsets());
        }

        public BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    /* loaded from: classes.dex */
    public static class Impl20 extends Impl {
        public static Class<?> sAttachInfoClass = null;
        public static Field sAttachInfoField = null;
        public static Method sGetViewRootImplMethod = null;
        public static Field sVisibleInsetsField = null;
        public static boolean sVisibleRectReflectionFetched = false;
        public Insets[] mOverriddenInsets;
        public final WindowInsets mPlatformInsets;
        public Insets mRootViewVisibleInsets;
        public WindowInsetsCompat mRootWindowInsets;
        public Insets mSystemWindowInsets;

        public Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.mImpl.getStableInsets();
            }
            return Insets.NONE;
        }

        private Insets getVisibleInsets(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!sVisibleRectReflectionFetched) {
                    loadReflectionField();
                }
                Method method = sGetViewRootImplMethod;
                if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                        if (rect == null) {
                            return null;
                        }
                        return Insets.of(rect.left, rect.top, rect.right, rect.bottom);
                    } catch (ReflectiveOperationException e) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            sVisibleRectReflectionFetched = true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyRootViewBounds(View view) {
            Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int r2) {
            return getInsets(r2, false);
        }

        public Insets getInsetsForType(int r6, boolean z) {
            int r62;
            DisplayCutoutCompat displayCutout;
            int r2;
            int r3;
            int r4;
            int r1 = 0;
            if (r6 != 1) {
                Insets insets = null;
                if (r6 != 2) {
                    Insets insets2 = Insets.NONE;
                    if (r6 != 8) {
                        if (r6 != 16) {
                            if (r6 != 32) {
                                if (r6 != 64) {
                                    if (r6 != 128) {
                                        return insets2;
                                    }
                                    WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                                    if (windowInsetsCompat != null) {
                                        displayCutout = windowInsetsCompat.mImpl.getDisplayCutout();
                                    } else {
                                        displayCutout = getDisplayCutout();
                                    }
                                    if (displayCutout != null) {
                                        int r7 = Build.VERSION.SDK_INT;
                                        DisplayCutout displayCutout2 = displayCutout.mDisplayCutout;
                                        if (r7 >= 28) {
                                            r2 = DisplayCutoutCompat.Api28Impl.getSafeInsetLeft(displayCutout2);
                                        } else {
                                            r2 = 0;
                                        }
                                        if (r7 >= 28) {
                                            r3 = DisplayCutoutCompat.Api28Impl.getSafeInsetTop(displayCutout2);
                                        } else {
                                            r3 = 0;
                                        }
                                        if (r7 >= 28) {
                                            r4 = DisplayCutoutCompat.Api28Impl.getSafeInsetRight(displayCutout2);
                                        } else {
                                            r4 = 0;
                                        }
                                        if (r7 >= 28) {
                                            r1 = DisplayCutoutCompat.Api28Impl.getSafeInsetBottom(displayCutout2);
                                        }
                                        return Insets.of(r2, r3, r4, r1);
                                    }
                                    return insets2;
                                }
                                return getTappableElementInsets();
                            }
                            return getMandatorySystemGestureInsets();
                        }
                        return getSystemGestureInsets();
                    }
                    Insets[] insetsArr = this.mOverriddenInsets;
                    if (insetsArr != null) {
                        insets = insetsArr[Type.indexOf(8)];
                    }
                    if (insets != null) {
                        return insets;
                    }
                    Insets systemWindowInsets = getSystemWindowInsets();
                    Insets rootStableInsets = getRootStableInsets();
                    int r63 = systemWindowInsets.bottom;
                    if (r63 > rootStableInsets.bottom) {
                        return Insets.of(0, 0, 0, r63);
                    }
                    Insets insets3 = this.mRootViewVisibleInsets;
                    if (insets3 != null && !insets3.equals(insets2) && (r62 = this.mRootViewVisibleInsets.bottom) > rootStableInsets.bottom) {
                        return Insets.of(0, 0, 0, r62);
                    }
                    return insets2;
                }
                if (z) {
                    Insets rootStableInsets2 = getRootStableInsets();
                    Insets stableInsets = getStableInsets();
                    return Insets.of(Math.max(rootStableInsets2.left, stableInsets.left), 0, Math.max(rootStableInsets2.right, stableInsets.right), Math.max(rootStableInsets2.bottom, stableInsets.bottom));
                }
                Insets systemWindowInsets2 = getSystemWindowInsets();
                WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                if (windowInsetsCompat2 != null) {
                    insets = windowInsetsCompat2.mImpl.getStableInsets();
                }
                int r72 = systemWindowInsets2.bottom;
                if (insets != null) {
                    r72 = Math.min(r72, insets.bottom);
                }
                return Insets.of(systemWindowInsets2.left, 0, systemWindowInsets2.right, r72);
            }
            if (z) {
                return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
            }
            return Insets.of(0, getSystemWindowInsets().top, 0, 0);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int r2) {
            return getInsets(r2, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                WindowInsets windowInsets = this.mPlatformInsets;
                this.mSystemWindowInsets = Insets.of(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat inset(int r4, int r5, int r6, int r7) {
            BuilderImpl builderImpl20;
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(null, this.mPlatformInsets);
            int r1 = Build.VERSION.SDK_INT;
            if (r1 >= 30) {
                builderImpl20 = new BuilderImpl30(windowInsetsCompat);
            } else if (r1 >= 29) {
                builderImpl20 = new BuilderImpl29(windowInsetsCompat);
            } else {
                builderImpl20 = new BuilderImpl20(windowInsetsCompat);
            }
            builderImpl20.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), r4, r5, r6, r7));
            builderImpl20.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), r4, r5, r6, r7));
            return builderImpl20.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public boolean isTypeVisible(int r4) {
            if (r4 != 1 && r4 != 2) {
                if (r4 == 4) {
                    return false;
                }
                if (r4 != 8 && r4 != 128) {
                    return true;
                }
            }
            return !getInsetsForType(r4, false).equals(Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @SuppressLint({"WrongConstant"})
        public boolean isVisible(int r4) {
            for (int r1 = 1; r1 <= 256; r1 <<= 1) {
                if ((r4 & r1) != 0 && !isTypeVisible(r1)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        public void setRootViewData(Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }

        @SuppressLint({"WrongConstant"})
        private Insets getInsets(int r4, boolean z) {
            Insets insets = Insets.NONE;
            for (int r1 = 1; r1 <= 256; r1 <<= 1) {
                if ((r4 & r1) != 0) {
                    insets = Insets.max(insets, getInsetsForType(r1, z));
                }
            }
            return insets;
        }
    }

    /* loaded from: classes.dex */
    public static class Impl21 extends Impl20 {
        public Insets mStableInsets;

        public Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mStableInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(null, this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(null, this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                WindowInsets windowInsets = this.mPlatformInsets;
                this.mStableInsets = Insets.of(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }
    }

    /* loaded from: classes.dex */
    public static class Impl28 extends Impl21 {
        public Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat consumeDisplayCutout() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.mPlatformInsets.consumeDisplayCutout();
            return WindowInsetsCompat.toWindowInsetsCompat(null, consumeDisplayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            if (Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets)) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public DisplayCutoutCompat getDisplayCutout() {
            DisplayCutout displayCutout;
            displayCutout = this.mPlatformInsets.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new DisplayCutoutCompat(displayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class Type {
        public static int indexOf(int r3) {
            if (r3 != 1) {
                if (r3 == 2) {
                    return 1;
                }
                if (r3 == 4) {
                    return 2;
                }
                if (r3 != 8) {
                    if (r3 == 16) {
                        return 4;
                    }
                    if (r3 != 32) {
                        if (r3 != 64) {
                            if (r3 != 128) {
                                if (r3 == 256) {
                                    return 8;
                                }
                                throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("type needs to be >= FIRST and <= LAST, type=", r3));
                            }
                            return 7;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 3;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class TypeImpl30 {
        public static int toPlatformType(int r4) {
            int statusBars;
            int r0 = 0;
            for (int r2 = 1; r2 <= 256; r2 <<= 1) {
                if ((r4 & r2) != 0) {
                    if (r2 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (r2 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (r2 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (r2 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (r2 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (r2 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (r2 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (r2 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    r0 |= statusBars;
                }
            }
            return r0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.CONSUMED;
        } else {
            CONSUMED = Impl.CONSUMED;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
            return;
        }
        if (r0 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (r0 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else {
            this.mImpl = new Impl21(this, windowInsets);
        }
    }

    public static Insets insetInsets(Insets insets, int r6, int r7, int r8, int r9) {
        int max = Math.max(0, insets.left - r6);
        int max2 = Math.max(0, insets.top - r7);
        int max3 = Math.max(0, insets.right - r8);
        int max4 = Math.max(0, insets.bottom - r9);
        if (max == r6 && max2 == r7 && max3 == r8 && max4 == r9) {
            return insets;
        }
        return Insets.of(max, max2, max3, max4);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat(windowInsets);
        if (view != null) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api19Impl.isAttachedToWindow(view)) {
                WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(view);
                Impl impl = windowInsetsCompat.mImpl;
                impl.setRootWindowInsets(rootWindowInsets);
                impl.copyRootViewBounds(view.getRootView());
            }
        }
        return windowInsetsCompat;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
    }

    public final Insets getInsets(int r2) {
        return this.mImpl.getInsets(r2);
    }

    public final Insets getInsetsIgnoringVisibility(int r2) {
        return this.mImpl.getInsetsIgnoringVisibility(r2);
    }

    @Deprecated
    public final int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public final int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public final int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public final int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    public final int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @Deprecated
    public final WindowInsetsCompat replaceSystemWindowInsets(int r3, int r4, int r5, int r6) {
        BuilderImpl builderImpl20;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 30) {
            builderImpl20 = new BuilderImpl30(this);
        } else if (r0 >= 29) {
            builderImpl20 = new BuilderImpl29(this);
        } else {
            builderImpl20 = new BuilderImpl20(this);
        }
        builderImpl20.setSystemWindowInsets(Insets.of(r3, r4, r5, r6));
        return builderImpl20.build();
    }

    public final WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class BuilderImpl20 extends BuilderImpl {
        public static Constructor<WindowInsets> sConstructor = null;
        public static boolean sConstructorFetched = false;
        public static Field sConsumedField = null;
        public static boolean sConsumedFieldFetched = false;
        public WindowInsets mPlatformInsets;
        public Insets mStableInsets;

        public BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        private static WindowInsets createWindowInsetsInstance() {
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(null, this.mPlatformInsets);
            Insets[] insetsArr = this.mInsetsTypeMask;
            Impl impl = windowInsetsCompat.mImpl;
            impl.setOverriddenInsets(insetsArr);
            impl.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        public BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    /* loaded from: classes.dex */
    public static class BuilderImpl29 extends BuilderImpl {
        public final WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = DrawableUtils$$ExternalSyntheticApiModelOutline1.m();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat build() {
            WindowInsets build;
            applyInsetTypes();
            build = this.mPlatBuilder.build();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(null, build);
            windowInsetsCompat.mImpl.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setMandatorySystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setTappableElementInsets(Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }

        public BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder m;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                m = DrawableUtils$$ExternalSyntheticApiModelOutline2.m(windowInsets);
            } else {
                m = DrawableUtils$$ExternalSyntheticApiModelOutline1.m();
            }
            this.mPlatBuilder = m;
        }
    }

    public WindowInsetsCompat() {
        this.mImpl = new Impl(this);
    }

    /* loaded from: classes.dex */
    public static class Impl {
        public static final WindowInsetsCompat CONSUMED;
        public final WindowInsetsCompat mHost;

        static {
            BuilderImpl builderImpl20;
            int r0 = Build.VERSION.SDK_INT;
            if (r0 >= 30) {
                builderImpl20 = new BuilderImpl30();
            } else if (r0 >= 29) {
                builderImpl20 = new BuilderImpl29();
            } else {
                builderImpl20 = new BuilderImpl20();
            }
            CONSUMED = builderImpl20.build().mImpl.consumeDisplayCutout().mImpl.consumeStableInsets().mImpl.consumeSystemWindowInsets();
        }

        public Impl(WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            if (isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && ObjectsCompat$Api19Impl.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) && ObjectsCompat$Api19Impl.equals(getStableInsets(), impl.getStableInsets()) && ObjectsCompat$Api19Impl.equals(getDisplayCutout(), impl.getDisplayCutout())) {
                return true;
            }
            return false;
        }

        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        public Insets getInsets(int r1) {
            return Insets.NONE;
        }

        public Insets getInsetsIgnoringVisibility(int r2) {
            if ((r2 & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        public Insets getStableInsets() {
            return Insets.NONE;
        }

        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        public WindowInsetsCompat inset(int r1, int r2, int r3, int r4) {
            return CONSUMED;
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public boolean isVisible(int r1) {
            return true;
        }

        public void copyRootViewBounds(View view) {
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    /* loaded from: classes.dex */
    public static class Impl29 extends Impl28 {
        public Insets mMandatorySystemGestureInsets;
        public Insets mSystemGestureInsets;
        public Insets mTappableElementInsets;

        public Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getMandatorySystemGestureInsets() {
            android.graphics.Insets mandatorySystemGestureInsets;
            if (this.mMandatorySystemGestureInsets == null) {
                mandatorySystemGestureInsets = this.mPlatformInsets.getMandatorySystemGestureInsets();
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(mandatorySystemGestureInsets);
            }
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getSystemGestureInsets() {
            android.graphics.Insets systemGestureInsets;
            if (this.mSystemGestureInsets == null) {
                systemGestureInsets = this.mPlatformInsets.getSystemGestureInsets();
                this.mSystemGestureInsets = Insets.toCompatInsets(systemGestureInsets);
            }
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets getTappableElementInsets() {
            android.graphics.Insets tappableElementInsets;
            if (this.mTappableElementInsets == null) {
                tappableElementInsets = this.mPlatformInsets.getTappableElementInsets();
                this.mTappableElementInsets = Insets.toCompatInsets(tappableElementInsets);
            }
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat inset(int r2, int r3, int r4, int r5) {
            WindowInsets inset;
            inset = this.mPlatformInsets.inset(r2, r3, r4, r5);
            return WindowInsetsCompat.toWindowInsetsCompat(null, inset);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(Insets insets) {
        }
    }

    /* loaded from: classes.dex */
    public static class Impl30 extends Impl29 {
        public static final WindowInsetsCompat CONSUMED;

        static {
            WindowInsets windowInsets;
            windowInsets = WindowInsets.CONSUMED;
            CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(null, windowInsets);
        }

        public Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsets(int r2) {
            android.graphics.Insets insets;
            insets = this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(r2));
            return Insets.toCompatInsets(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets getInsetsIgnoringVisibility(int r2) {
            android.graphics.Insets insetsIgnoringVisibility;
            insetsIgnoringVisibility = this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(r2));
            return Insets.toCompatInsets(insetsIgnoringVisibility);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int r2) {
            boolean isVisible;
            isVisible = this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(r2));
            return isVisible;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void copyRootViewBounds(View view) {
        }
    }
}
