package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.PathInterpolator;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.SimpleArrayMap;
import androidx.compose.foundation.layout.InsetsListener;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class ViewCompat {
    public static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
    public static final ViewCompat$$ExternalSyntheticLambda0 NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    public static boolean sAccessibilityDelegateCheckFailed;
    public static Field sAccessibilityDelegateField;
    public static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    public static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    /* renamed from: androidx.core.view.ViewCompat$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 extends AccessibilityViewProperty<CharSequence> {
        public AnonymousClass3() {
            super(R.id.tag_state_description, CharSequence.class, 64, 30);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final CharSequence frameworkGet(View view) {
            return Api30Impl.getStateDescription(view);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final void frameworkSet(View view, CharSequence charSequence) {
            Api30Impl.setStateDescription(view, charSequence);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass4 extends AccessibilityViewProperty<Boolean> {
        public AnonymousClass4() {
            super(R.id.tag_accessibility_heading, Boolean.class, 0, 28);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final Boolean frameworkGet(View view) {
            return Boolean.valueOf(Api28Impl.isAccessibilityHeading(view));
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final void frameworkSet(View view, Boolean bool) {
            Api28Impl.setAccessibilityHeading(view, bool.booleanValue());
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final boolean shouldUpdate(Boolean bool, Boolean bool2) {
            return !AccessibilityViewProperty.booleanNullToFalseEquals(bool, bool2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AccessibilityViewProperty<T> {
        public final int mContentChangeType;
        public final int mFrameworkMinimumSdk;
        public final int mTagKey;
        public final Class<T> mType;

        public AccessibilityViewProperty(int r1, Class<T> cls, int r3, int r4) {
            this.mTagKey = r1;
            this.mType = cls;
            this.mContentChangeType = r3;
            this.mFrameworkMinimumSdk = r4;
        }

        public static boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            boolean z;
            boolean z2;
            if (bool != null && bool.booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            if (bool2 != null && bool2.booleanValue()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2) {
                return true;
            }
            return false;
        }

        public abstract T frameworkGet(View view);

        public abstract void frameworkSet(View view, T t);

        public final T get(View view) {
            boolean z;
            if (Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return frameworkGet(view);
            }
            T t = (T) view.getTag(this.mTagKey);
            if (this.mType.isInstance(t)) {
                return t;
            }
            return null;
        }

        public final void set(View view, T t) {
            boolean z;
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            if (Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                frameworkSet(view, t);
                return;
            }
            if (shouldUpdate(get(view), t)) {
                View.AccessibilityDelegate accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view);
                if (accessibilityDelegateInternal == null) {
                    accessibilityDelegateCompat = null;
                } else if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                    accessibilityDelegateCompat = ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
                } else {
                    accessibilityDelegateCompat = new AccessibilityDelegateCompat(accessibilityDelegateInternal);
                }
                if (accessibilityDelegateCompat == null) {
                    accessibilityDelegateCompat = new AccessibilityDelegateCompat();
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
                view.setTag(this.mTagKey, t);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(this.mContentChangeType, view);
            }
        }

        public abstract boolean shouldUpdate(T t, T t2);
    }

    /* loaded from: classes.dex */
    public static class Api15Impl {
        public static boolean hasOnClickListeners(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* loaded from: classes.dex */
    public static class Api16Impl {
        public static AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return view.getAccessibilityNodeProvider();
        }

        public static boolean getFitsSystemWindows(View view) {
            return view.getFitsSystemWindows();
        }

        public static int getImportantForAccessibility(View view) {
            return view.getImportantForAccessibility();
        }

        public static int getMinimumHeight(View view) {
            return view.getMinimumHeight();
        }

        public static int getMinimumWidth(View view) {
            return view.getMinimumWidth();
        }

        public static ViewParent getParentForAccessibility(View view) {
            return view.getParentForAccessibility();
        }

        public static int getWindowSystemUiVisibility(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public static boolean hasOverlappingRendering(View view) {
            return view.hasOverlappingRendering();
        }

        public static boolean hasTransientState(View view) {
            return view.hasTransientState();
        }

        public static boolean performAccessibilityAction(View view, int r1, Bundle bundle) {
            return view.performAccessibilityAction(r1, bundle);
        }

        public static void postInvalidateOnAnimation(View view) {
            view.postInvalidateOnAnimation();
        }

        public static void postOnAnimation(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public static void removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public static void requestFitSystemWindows(View view) {
            view.requestFitSystemWindows();
        }

        public static void setBackground(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static void setHasTransientState(View view, boolean z) {
            view.setHasTransientState(z);
        }

        public static void setImportantForAccessibility(View view, int r1) {
            view.setImportantForAccessibility(r1);
        }

        public static void postInvalidateOnAnimation(View view, int r1, int r2, int r3, int r4) {
            view.postInvalidateOnAnimation(r1, r2, r3, r4);
        }
    }

    /* loaded from: classes.dex */
    public static class Api17Impl {
        public static int generateViewId() {
            return View.generateViewId();
        }

        public static Display getDisplay(View view) {
            return view.getDisplay();
        }

        public static int getLabelFor(View view) {
            return view.getLabelFor();
        }

        public static int getLayoutDirection(View view) {
            return view.getLayoutDirection();
        }

        public static int getPaddingEnd(View view) {
            return view.getPaddingEnd();
        }

        public static int getPaddingStart(View view) {
            return view.getPaddingStart();
        }

        public static boolean isPaddingRelative(View view) {
            return view.isPaddingRelative();
        }

        public static void setLabelFor(View view, int r1) {
            view.setLabelFor(r1);
        }

        public static void setLayerPaint(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public static void setLayoutDirection(View view, int r1) {
            view.setLayoutDirection(r1);
        }

        public static void setPaddingRelative(View view, int r1, int r2, int r3, int r4) {
            view.setPaddingRelative(r1, r2, r3, r4);
        }
    }

    /* loaded from: classes.dex */
    public static class Api18Impl {
        public static Rect getClipBounds(View view) {
            return view.getClipBounds();
        }

        public static boolean isInLayout(View view) {
            return view.isInLayout();
        }

        public static void setClipBounds(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* loaded from: classes.dex */
    public static class Api19Impl {
        public static int getAccessibilityLiveRegion(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        public static boolean isLaidOut(View view) {
            return view.isLaidOut();
        }

        public static boolean isLayoutDirectionResolved(View view) {
            return view.isLayoutDirectionResolved();
        }

        public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int r3) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, r3);
        }

        public static void setAccessibilityLiveRegion(View view, int r1) {
            view.setAccessibilityLiveRegion(r1);
        }

        public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int r1) {
            accessibilityEvent.setContentChangeTypes(r1);
        }
    }

    /* loaded from: classes.dex */
    public static class Api20Impl {
        public static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void requestApplyInsets(View view) {
            view.requestApplyInsets();
        }
    }

    /* loaded from: classes.dex */
    public static class Api21Impl {
        public static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view, view.computeSystemWindowInsets(windowInsets, rect));
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        public static boolean dispatchNestedPreFling(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        public static boolean dispatchNestedPreScroll(View view, int r1, int r2, int[] r3, int[] r4) {
            return view.dispatchNestedPreScroll(r1, r2, r3, r4);
        }

        public static boolean dispatchNestedScroll(View view, int r1, int r2, int r3, int r4, int[] r5) {
            return view.dispatchNestedScroll(r1, r2, r3, r4, r5);
        }

        public static ColorStateList getBackgroundTintList(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode getBackgroundTintMode(View view) {
            return view.getBackgroundTintMode();
        }

        public static float getElevation(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsetsCompat.BuilderImpl builderImpl20;
            if (WindowInsetsCompat.Api21ReflectionHolder.sReflectionSucceeded && view.isAttachedToWindow()) {
                try {
                    Object obj = WindowInsetsCompat.Api21ReflectionHolder.sViewAttachInfoField.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) WindowInsetsCompat.Api21ReflectionHolder.sStableInsets.get(obj);
                        Rect rect2 = (Rect) WindowInsetsCompat.Api21ReflectionHolder.sContentInsets.get(obj);
                        if (rect != null && rect2 != null) {
                            int r2 = Build.VERSION.SDK_INT;
                            if (r2 >= 30) {
                                builderImpl20 = new WindowInsetsCompat.BuilderImpl30();
                            } else if (r2 >= 29) {
                                builderImpl20 = new WindowInsetsCompat.BuilderImpl29();
                            } else {
                                builderImpl20 = new WindowInsetsCompat.BuilderImpl20();
                            }
                            builderImpl20.setStableInsets(Insets.of(rect.left, rect.top, rect.right, rect.bottom));
                            builderImpl20.setSystemWindowInsets(Insets.of(rect2.left, rect2.top, rect2.right, rect2.bottom));
                            WindowInsetsCompat build = builderImpl20.build();
                            build.mImpl.setRootWindowInsets(build);
                            build.mImpl.copyRootViewBounds(view.getRootView());
                            return build;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }

        public static String getTransitionName(View view) {
            return view.getTransitionName();
        }

        public static float getTranslationZ(View view) {
            return view.getTranslationZ();
        }

        public static float getZ(View view) {
            return view.getZ();
        }

        public static boolean hasNestedScrollingParent(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean isImportantForAccessibility(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean isNestedScrollingEnabled(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void setElevation(View view, float f) {
            view.setElevation(f);
        }

        public static void setNestedScrollingEnabled(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public static void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                    public WindowInsetsCompat mLastInsets = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(view2, windowInsets);
                        int r1 = Build.VERSION.SDK_INT;
                        OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
                        if (r1 < 30) {
                            Api21Impl.callCompatInsetAnimationCallback(windowInsets, view);
                            if (windowInsetsCompat.equals(this.mLastInsets)) {
                                return onApplyWindowInsetsListener2.onApplyWindowInsets(view2, windowInsetsCompat).toWindowInsets();
                            }
                        }
                        this.mLastInsets = windowInsetsCompat;
                        WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener2.onApplyWindowInsets(view2, windowInsetsCompat);
                        if (r1 >= 30) {
                            return onApplyWindowInsets.toWindowInsets();
                        }
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        Api20Impl.requestApplyInsets(view2);
                        return onApplyWindowInsets.toWindowInsets();
                    }
                });
            }
        }

        public static void setTransitionName(View view, String str) {
            view.setTransitionName(str);
        }

        public static void setTranslationZ(View view, float f) {
            view.setTranslationZ(f);
        }

        public static void setZ(View view, float f) {
            view.setZ(f);
        }

        public static boolean startNestedScroll(View view, int r1) {
            return view.startNestedScroll(r1);
        }

        public static void stopNestedScroll(View view) {
            view.stopNestedScroll();
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(null, rootWindowInsets);
            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
            impl.setRootWindowInsets(windowInsetsCompat);
            impl.copyRootViewBounds(view.getRootView());
            return windowInsetsCompat;
        }

        public static int getScrollIndicators(View view) {
            return view.getScrollIndicators();
        }

        public static void setScrollIndicators(View view, int r1) {
            view.setScrollIndicators(r1);
        }

        public static void setScrollIndicators(View view, int r1, int r2) {
            view.setScrollIndicators(r1, r2);
        }
    }

    /* loaded from: classes.dex */
    public static class Api24Impl {
        public static void cancelDragAndDrop(View view) {
            view.cancelDragAndDrop();
        }

        public static void dispatchFinishTemporaryDetach(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        public static void dispatchStartTemporaryDetach(View view) {
            view.dispatchStartTemporaryDetach();
        }

        public static void setPointerIcon(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int r4) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, r4);
        }

        public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* loaded from: classes.dex */
    public static class Api26Impl {
        public static void addKeyboardNavigationClusters(View view, Collection<View> collection, int r2) {
            view.addKeyboardNavigationClusters(collection, r2);
        }

        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }

        public static int getImportantForAutofill(View view) {
            return view.getImportantForAutofill();
        }

        public static int getNextClusterForwardId(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean hasExplicitFocusable(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean isFocusedByDefault(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean isImportantForAutofill(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean isKeyboardNavigationCluster(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View keyboardNavigationClusterSearch(View view, View view2, int r2) {
            return view.keyboardNavigationClusterSearch(view2, r2);
        }

        public static boolean restoreDefaultFocus(View view) {
            return view.restoreDefaultFocus();
        }

        public static void setAutofillHints(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void setFocusedByDefault(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        public static void setImportantForAutofill(View view, int r1) {
            view.setImportantForAutofill(r1);
        }

        public static void setKeyboardNavigationCluster(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        public static void setNextClusterForwardId(View view, int r1) {
            view.setNextClusterForwardId(r1);
        }

        public static void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        public static void addOnUnhandledKeyEventListener(View view, final OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.ViewCompat$Api28Impl$$ExternalSyntheticLambda0
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return ViewCompat.OnUnhandledKeyEventListenerCompat.this.onUnhandledKeyEvent();
                }
            };
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static CharSequence getAccessibilityPaneTitle(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean isAccessibilityHeading(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean isScreenReaderFocusable(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.getOrDefault(onUnhandledKeyEventListenerCompat, null)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        public static <T> T requireViewById(View view, int r1) {
            return (T) view.requireViewById(r1);
        }

        public static void setAccessibilityHeading(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void setAutofillId(View view, AutofillId autofillId) {
            view.setAutofillId(autofillId);
        }

        public static void setScreenReaderFocusable(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        public static View.AccessibilityDelegate getAccessibilityDelegate(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> getSystemGestureExclusionRects(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void saveAttributeDataForStyleable(View view, Context context, int[] r2, AttributeSet attributeSet, TypedArray typedArray, int r5, int r6) {
            view.saveAttributeDataForStyleable(context, r2, attributeSet, typedArray, r5, r6);
        }

        public static void setContentCaptureSession(View view, ContentCaptureSession contentCaptureSession) {
            view.setContentCaptureSession(contentCaptureSession);
        }

        public static void setSystemGestureExclusionRects(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* loaded from: classes.dex */
    public static class Api30Impl {
        public static int getImportantForContentCapture(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence getStateDescription(View view) {
            return view.getStateDescription();
        }

        public static boolean isImportantForContentCapture(View view) {
            return view.isImportantForContentCapture();
        }

        public static void setImportantForContentCapture(View view, int r1) {
            view.setImportantForContentCapture(r1);
        }

        public static void setStateDescription(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public static final class Api31Impl {
        public static String[] getReceiveContentMimeTypes(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo wrapped = contentInfoCompat.mCompat.getWrapped();
            Objects.requireNonNull(wrapped);
            ContentInfo m = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m(wrapped);
            ContentInfo performReceiveContent = view.performReceiveContent(m);
            if (performReceiveContent == null) {
                return null;
            }
            if (performReceiveContent == m) {
                return contentInfoCompat;
            }
            return new ContentInfoCompat(new ContentInfoCompat.Compat31Impl(performReceiveContent));
        }

        public static void setOnReceiveContentListener(View view, String[] strArr, OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        public final OnReceiveContentListener mJetpackListener;

        public OnReceiveContentListenerAdapter(OnReceiveContentListener onReceiveContentListener) {
            this.mJetpackListener = onReceiveContentListener;
        }

        public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompat = new ContentInfoCompat(new ContentInfoCompat.Compat31Impl(contentInfo));
            ContentInfoCompat onReceiveContent = this.mJetpackListener.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            if (onReceiveContent == contentInfoCompat) {
                return contentInfo;
            }
            ContentInfo wrapped = onReceiveContent.mCompat.getWrapped();
            Objects.requireNonNull(wrapped);
            return ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m(wrapped);
        }
    }

    /* loaded from: classes.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent();
    }

    /* loaded from: classes.dex */
    public static class UnhandledKeyEventManager {
        public static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();
        public WeakHashMap<View, Boolean> mViewsContainingListeners = null;
        public SparseArray<WeakReference<View>> mCapturedKeys = null;
        public WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;

        public static boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public final View dispatchInOrder(View view, KeyEvent keyEvent) {
            View dispatchInOrder;
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    do {
                        childCount--;
                        if (childCount >= 0) {
                            dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                        }
                    } while (dispatchInOrder == null);
                    return dispatchInOrder;
                }
                if (onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
                return null;
            }
            return null;
        }
    }

    static {
        new AtomicInteger(1);
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new ViewCompat$$ExternalSyntheticLambda0();
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }
        return viewPropertyAnimatorCompat;
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets dispatchApplyWindowInsets = Api20Impl.dispatchApplyWindowInsets(view, windowInsets);
            if (!dispatchApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(view, dispatchApplyWindowInsets);
            }
        }
        return windowInsetsCompat;
    }

    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = UnhandledKeyEventManager.sViewsWithListeners;
        UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (unhandledKeyEventManager == null) {
            unhandledKeyEventManager = new UnhandledKeyEventManager();
            view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = unhandledKeyEventManager.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = UnhandledKeyEventManager.sViewsWithListeners;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (unhandledKeyEventManager.mViewsContainingListeners == null) {
                        unhandledKeyEventManager.mViewsContainingListeners = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = UnhandledKeyEventManager.sViewsWithListeners;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            unhandledKeyEventManager.mViewsContainingListeners.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                unhandledKeyEventManager.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View dispatchInOrder = unhandledKeyEventManager.dispatchInOrder(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                if (unhandledKeyEventManager.mCapturedKeys == null) {
                    unhandledKeyEventManager.mCapturedKeys = new SparseArray<>();
                }
                unhandledKeyEventManager.mCapturedKeys.put(keyCode, new WeakReference<>(dispatchInOrder));
            }
        }
        if (dispatchInOrder == null) {
            return false;
        }
        return true;
    }

    public static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getAccessibilityDelegate(view);
        }
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (!(obj instanceof View.AccessibilityDelegate)) {
                return null;
            }
            return (View.AccessibilityDelegate) obj;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static ArrayList getActionList(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getReceiveContentMimeTypes(view);
        }
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(int r11, View view) {
        boolean z;
        Object tag;
        boolean z2;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        int r1 = Build.VERSION.SDK_INT;
        boolean z3 = false;
        if (r1 >= 28) {
            z = true;
        } else {
            z = false;
        }
        CharSequence charSequence = null;
        if (z) {
            tag = Api28Impl.getAccessibilityPaneTitle(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        if (((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int r10 = 32;
        if (Api19Impl.getAccessibilityLiveRegion(view) == 0 && !z2) {
            if (r11 == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                Api19Impl.setContentChangeTypes(obtain, r11);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                List<CharSequence> text = obtain.getText();
                if (r1 >= 28) {
                    z3 = true;
                }
                if (z3) {
                    charSequence = Api28Impl.getAccessibilityPaneTitle(view);
                } else {
                    Object tag2 = view.getTag(R.id.tag_accessibility_pane_title);
                    if (CharSequence.class.isInstance(tag2)) {
                        charSequence = tag2;
                    }
                }
                text.add(charSequence);
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    Api19Impl.notifySubtreeAccessibilityStateChanged(view.getParent(), view, view, r11);
                    return;
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e);
                    return;
                }
            }
            return;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z2) {
            r10 = 2048;
        }
        obtain2.setEventType(r10);
        Api19Impl.setContentChangeTypes(obtain2, r11);
        if (z2) {
            List<CharSequence> text2 = obtain2.getText();
            if (r1 >= 28) {
                z3 = true;
            }
            if (z3) {
                charSequence = Api28Impl.getAccessibilityPaneTitle(view);
            } else {
                Object tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                if (CharSequence.class.isInstance(tag3)) {
                    charSequence = tag3;
                }
            }
            text2.add(charSequence);
            if (Api16Impl.getImportantForAccessibility(view) == 0) {
                Api16Impl.setImportantForAccessibility(view, 1);
            }
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets onApplyWindowInsets = Api20Impl.onApplyWindowInsets(view, windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(view, onApplyWindowInsets);
            }
        }
        return windowInsetsCompat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.performReceiveContent(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        OnReceiveContentViewBehavior onReceiveContentViewBehavior = NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
        if (onReceiveContentListener != null) {
            ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            if (view instanceof OnReceiveContentViewBehavior) {
                onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
            }
            return onReceiveContentViewBehavior.onReceiveContent(onReceiveContent);
        }
        if (view instanceof OnReceiveContentViewBehavior) {
            onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
        }
        return onReceiveContentViewBehavior.onReceiveContent(contentInfoCompat);
    }

    public static void removeActionWithId(int r2, View view) {
        ArrayList actionList = getActionList(view);
        for (int r0 = 0; r0 < actionList.size(); r0++) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) actionList.get(r0)).getId() == r2) {
                actionList.remove(r0);
                return;
            }
        }
    }

    public static void replaceAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, AccessibilityViewCommand accessibilityViewCommand) {
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, accessibilityActionCompat.mId, null, accessibilityViewCommand, accessibilityActionCompat.mViewCommandArgumentClass);
        View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            accessibilityDelegateCompat = null;
        } else if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            accessibilityDelegateCompat = ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
        } else {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat(accessibilityDelegateInternal);
        }
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegateCompat);
        removeActionWithId(accessibilityActionCompat2.getId(), view);
        getActionList(view).add(accessibilityActionCompat2);
        notifyViewAccessibilityStateChangedIfNeeded(0, view);
    }

    public static void saveAttributeDataForStyleable(View view, @SuppressLint({"ContextFirst"}) Context context, int[] r9, AttributeSet attributeSet, TypedArray typedArray, int r12) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view, context, r9, attributeSet, typedArray, r12, 0);
        }
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        AccessibilityDelegateCompat.AccessibilityDelegateAdapter accessibilityDelegateAdapter;
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (Api16Impl.getImportantForAccessibility(view) == 0) {
            Api16Impl.setImportantForAccessibility(view, 1);
        }
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegateAdapter = null;
        } else {
            accessibilityDelegateAdapter = accessibilityDelegateCompat.mBridge;
        }
        view.setAccessibilityDelegate(accessibilityDelegateAdapter);
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        boolean z;
        new AccessibilityViewProperty<CharSequence>() { // from class: androidx.core.view.ViewCompat.2
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public final CharSequence frameworkGet(View view2) {
                return Api28Impl.getAccessibilityPaneTitle(view2);
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public final void frameworkSet(View view2, CharSequence charSequence2) {
                Api28Impl.setAccessibilityPaneTitle(view2, charSequence2);
            }

            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public final boolean shouldUpdate(CharSequence charSequence2, CharSequence charSequence3) {
                return !TextUtils.equals(charSequence2, charSequence3);
            }
        }.set(view, charSequence);
        AccessibilityPaneVisibilityManager accessibilityPaneVisibilityManager = sAccessibilityPaneVisibilityManager;
        if (charSequence != null) {
            WeakHashMap<View, Boolean> weakHashMap = accessibilityPaneVisibilityManager.mPanesToVisible;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z));
            view.addOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
            if (Api19Impl.isAttachedToWindow(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(accessibilityPaneVisibilityManager);
                return;
            }
            return;
        }
        accessibilityPaneVisibilityManager.mPanesToVisible.remove(view);
        view.removeOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
        Api16Impl.removeOnGlobalLayoutListener(view.getViewTreeObserver(), accessibilityPaneVisibilityManager);
    }

    public static void setWindowInsetsAnimationCallback(View view, InsetsListener insetsListener) {
        WindowInsetsAnimationCompat.Impl30.ProxyCallback proxyCallback = null;
        if (Build.VERSION.SDK_INT >= 30) {
            if (insetsListener != null) {
                proxyCallback = new WindowInsetsAnimationCompat.Impl30.ProxyCallback(insetsListener);
            }
            WindowInsetsAnimationCompat$Impl30$$ExternalSyntheticApiModelOutline2.m(view, proxyCallback);
            return;
        }
        PathInterpolator pathInterpolator = WindowInsetsAnimationCompat.Impl21.SHOW_IME_INTERPOLATOR;
        Object tag = view.getTag(R.id.tag_on_apply_window_listener);
        if (insetsListener == null) {
            view.setTag(R.id.tag_window_insets_animation_callback, null);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            return;
        }
        View.OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener = new WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener(view, insetsListener);
        view.setTag(R.id.tag_window_insets_animation_callback, impl21OnApplyWindowInsetsListener);
        if (tag == null) {
            view.setOnApplyWindowInsetsListener(impl21OnApplyWindowInsetsListener);
        }
    }

    /* loaded from: classes.dex */
    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            boolean z;
            int r2;
            if (Build.VERSION.SDK_INT < 28) {
                WeakHashMap<View, Boolean> weakHashMap = this.mPanesToVisible;
                for (Map.Entry<View, Boolean> entry : weakHashMap.entrySet()) {
                    View key = entry.getKey();
                    boolean booleanValue = entry.getValue().booleanValue();
                    if (key.isShown() && key.getWindowVisibility() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (booleanValue != z) {
                        if (z) {
                            r2 = 16;
                        } else {
                            r2 = 32;
                        }
                        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r2, key);
                        weakHashMap.put(key, Boolean.valueOf(z));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
