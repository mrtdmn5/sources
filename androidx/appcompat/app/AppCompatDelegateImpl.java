package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.app.TwilightManager;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.WeakHashMap;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public final class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public ActionBar mActionBar;
    public ActionMenuPresenterCallback mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public boolean mActivityHandlesUiMode;
    public boolean mActivityHandlesUiModeChecked;
    public final AppCompatCallback mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoBatteryNightModeManager mAutoBatteryNightModeManager;
    public AutoTimeNightModeManager mAutoTimeNightModeManager;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public DecorContentParent mDecorContentParent;
    public boolean mDestroyed;
    public Configuration mEffectiveConfiguration;
    public boolean mEnableDefaultActionBarUp;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public boolean mIsFloating;
    public final int mLocalNightMode;
    public boolean mLongPressBackDown;
    public SupportMenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public AnonymousClass6 mShowActionModePopup;
    public View mStatusGuard;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;
    public static final SimpleArrayMap<String, Integer> sLocalNightModes = new SimpleArrayMap<>();
    public static final int[] sWindowBackgroundStyleable = {R.attr.windowBackground};
    public static final boolean sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
    public static final boolean sCanApplyOverrideConfiguration = true;
    public ViewPropertyAnimatorCompat mFadeAnim = null;
    public final boolean mHandleNativeActionModes = true;
    public final AnonymousClass2 mInvalidatePanelMenuRunnable = new AnonymousClass2();

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                appCompatDelegateImpl.doInvalidatePanelMenu(0);
            }
            if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 4096) != 0) {
                appCompatDelegateImpl.doInvalidatePanelMenu(108);
            }
            appCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
            appCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$3 */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 implements OnApplyWindowInsetsListener {
        public AnonymousClass3() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            boolean z;
            View view2;
            WindowInsetsCompat windowInsetsCompat2;
            int systemWindowInsetLeft;
            int systemWindowInsetRight;
            boolean z2;
            int color;
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.getClass();
            int systemWindowInsetTop2 = windowInsetsCompat.getSystemWindowInsetTop();
            ActionBarContextView actionBarContextView = appCompatDelegateImpl.mActionModeView;
            int r5 = 0;
            if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.mActionModeView.getLayoutParams();
                boolean z3 = true;
                if (appCompatDelegateImpl.mActionModeView.isShown()) {
                    if (appCompatDelegateImpl.mTempRect1 == null) {
                        appCompatDelegateImpl.mTempRect1 = new Rect();
                        appCompatDelegateImpl.mTempRect2 = new Rect();
                    }
                    Rect rect = appCompatDelegateImpl.mTempRect1;
                    Rect rect2 = appCompatDelegateImpl.mTempRect2;
                    rect.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
                    Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                        }
                    }
                    int r0 = rect.top;
                    int r10 = rect.left;
                    int r9 = rect.right;
                    ViewGroup viewGroup2 = appCompatDelegateImpl.mSubDecor;
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(viewGroup2);
                    if (rootWindowInsets == null) {
                        systemWindowInsetLeft = 0;
                    } else {
                        systemWindowInsetLeft = rootWindowInsets.getSystemWindowInsetLeft();
                    }
                    if (rootWindowInsets == null) {
                        systemWindowInsetRight = 0;
                    } else {
                        systemWindowInsetRight = rootWindowInsets.getSystemWindowInsetRight();
                    }
                    if (marginLayoutParams.topMargin == r0 && marginLayoutParams.leftMargin == r10 && marginLayoutParams.rightMargin == r9) {
                        z2 = false;
                    } else {
                        marginLayoutParams.topMargin = r0;
                        marginLayoutParams.leftMargin = r10;
                        marginLayoutParams.rightMargin = r9;
                        z2 = true;
                    }
                    Context context = appCompatDelegateImpl.mContext;
                    if (r0 > 0 && appCompatDelegateImpl.mStatusGuard == null) {
                        View view3 = new View(context);
                        appCompatDelegateImpl.mStatusGuard = view3;
                        view3.setVisibility(8);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                        layoutParams.leftMargin = systemWindowInsetLeft;
                        layoutParams.rightMargin = systemWindowInsetRight;
                        appCompatDelegateImpl.mSubDecor.addView(appCompatDelegateImpl.mStatusGuard, -1, layoutParams);
                    } else {
                        View view4 = appCompatDelegateImpl.mStatusGuard;
                        if (view4 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view4.getLayoutParams();
                            int r13 = marginLayoutParams2.height;
                            int r14 = marginLayoutParams.topMargin;
                            if (r13 != r14 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                                marginLayoutParams2.height = r14;
                                marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                                marginLayoutParams2.rightMargin = systemWindowInsetRight;
                                appCompatDelegateImpl.mStatusGuard.setLayoutParams(marginLayoutParams2);
                            }
                        }
                    }
                    View view5 = appCompatDelegateImpl.mStatusGuard;
                    if (view5 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && view5.getVisibility() != 0) {
                        View view6 = appCompatDelegateImpl.mStatusGuard;
                        if ((ViewCompat.Api16Impl.getWindowSystemUiVisibility(view6) & DfuBaseService.ERROR_REMOTE_MASK) == 0) {
                            z3 = false;
                        }
                        if (z3) {
                            Object obj = ContextCompat.sLock;
                            color = ContextCompat.Api23Impl.getColor(context, com.kronaby.watch.app.R.color.abc_decor_view_status_guard_light);
                        } else {
                            Object obj2 = ContextCompat.sLock;
                            color = ContextCompat.Api23Impl.getColor(context, com.kronaby.watch.app.R.color.abc_decor_view_status_guard);
                        }
                        view6.setBackgroundColor(color);
                    }
                    if (!appCompatDelegateImpl.mOverlayActionMode && z) {
                        systemWindowInsetTop2 = 0;
                    }
                    z3 = z2;
                } else if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z = false;
                } else {
                    z3 = false;
                    z = false;
                }
                if (z3) {
                    appCompatDelegateImpl.mActionModeView.setLayoutParams(marginLayoutParams);
                }
            } else {
                z = false;
            }
            View view7 = appCompatDelegateImpl.mStatusGuard;
            if (view7 != null) {
                if (!z) {
                    r5 = 8;
                }
                view7.setVisibility(r5);
            }
            if (systemWindowInsetTop != systemWindowInsetTop2) {
                windowInsetsCompat2 = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), systemWindowInsetTop2, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                view2 = view;
            } else {
                view2 = view;
                windowInsetsCompat2 = windowInsetsCompat;
            }
            return ViewCompat.onApplyWindowInsets(view2, windowInsetsCompat2);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$5 */
    /* loaded from: classes.dex */
    public final class AnonymousClass5 implements ContentFrameLayout.OnAttachListener {
        public AnonymousClass5() {
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6 */
    /* loaded from: classes.dex */
    public final class AnonymousClass6 implements Runnable {

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$6$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {
            public AnonymousClass1() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationEnd() {
                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0f);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.mFadeAnim.setListener(null);
                appCompatDelegateImpl.mFadeAnim = null;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationStart() {
                AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
            }
        }

        public AnonymousClass6() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r5 = this;
                androidx.appcompat.app.AppCompatDelegateImpl r0 = androidx.appcompat.app.AppCompatDelegateImpl.this
                android.widget.PopupWindow r1 = r0.mActionModePopup
                androidx.appcompat.widget.ActionBarContextView r2 = r0.mActionModeView
                r3 = 55
                r4 = 0
                r1.showAtLocation(r2, r3, r4, r4)
                androidx.core.view.ViewPropertyAnimatorCompat r1 = r0.mFadeAnim
                if (r1 == 0) goto L13
                r1.cancel()
            L13:
                boolean r1 = r0.mSubDecorInstalled
                if (r1 == 0) goto L25
                android.view.ViewGroup r1 = r0.mSubDecor
                if (r1 == 0) goto L25
                java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r2 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
                boolean r1 = androidx.core.view.ViewCompat.Api19Impl.isLaidOut(r1)
                if (r1 == 0) goto L25
                r1 = 1
                goto L26
            L25:
                r1 = r4
            L26:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r1 == 0) goto L44
                androidx.appcompat.widget.ActionBarContextView r1 = r0.mActionModeView
                r3 = 0
                r1.setAlpha(r3)
                androidx.appcompat.widget.ActionBarContextView r1 = r0.mActionModeView
                androidx.core.view.ViewPropertyAnimatorCompat r1 = androidx.core.view.ViewCompat.animate(r1)
                r1.alpha(r2)
                r0.mFadeAnim = r1
                androidx.appcompat.app.AppCompatDelegateImpl$6$1 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6$1
                r0.<init>()
                r1.setListener(r0)
                goto L4e
            L44:
                androidx.appcompat.widget.ActionBarContextView r1 = r0.mActionModeView
                r1.setAlpha(r2)
                androidx.appcompat.widget.ActionBarContextView r0 = r0.mActionModeView
                r0.setVisibility(r4)
            L4e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.AnonymousClass6.run():void");
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$7 */
    /* loaded from: classes.dex */
    public final class AnonymousClass7 extends ViewPropertyAnimatorListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
            appCompatDelegateImpl.mFadeAnim.setListener(null);
            appCompatDelegateImpl.mFadeAnim = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationStart() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.mActionModeView.setVisibility(0);
            if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                View view = (View) appCompatDelegateImpl.mActionModeView.getParent();
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api20Impl.requestApplyInsets(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle$Delegate {
    }

    /* loaded from: classes.dex */
    public interface ActionBarMenuCallback {
    }

    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.checkCloseActionMenu(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback = AppCompatDelegateImpl.this.getWindowCallback();
            if (windowCallback != null) {
                windowCallback.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        public final ActionMode.Callback mWrapped;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {
            public AnonymousClass1() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationEnd() {
                ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = ActionModeCallbackWrapperV9.this;
                AppCompatDelegateImpl.this.mActionModeView.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.mActionModePopup;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                    View view = (View) appCompatDelegateImpl.mActionModeView.getParent();
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(view);
                }
                appCompatDelegateImpl.mActionModeView.killMode();
                appCompatDelegateImpl.mFadeAnim.setListener(null);
                appCompatDelegateImpl.mFadeAnim = null;
                ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
            }
        }

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
            return this.mWrapped.onCreateActionMode(actionMode, menuBuilder);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.mActionModePopup != null) {
                appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(appCompatDelegateImpl.mShowActionModePopup);
            }
            if (appCompatDelegateImpl.mActionModeView != null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
                if (viewPropertyAnimatorCompat != null) {
                    viewPropertyAnimatorCompat.cancel();
                }
                ViewPropertyAnimatorCompat animate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
                animate.alpha(0.0f);
                appCompatDelegateImpl.mFadeAnim = animate;
                animate.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                    public AnonymousClass1() {
                    }

                    @Override // androidx.core.view.ViewPropertyAnimatorListener
                    public final void onAnimationEnd() {
                        ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = ActionModeCallbackWrapperV9.this;
                        AppCompatDelegateImpl.this.mActionModeView.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl2.mActionModePopup;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl2.mActionModeView.getParent() instanceof View) {
                            View view = (View) appCompatDelegateImpl2.mActionModeView.getParent();
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            ViewCompat.Api20Impl.requestApplyInsets(view);
                        }
                        appCompatDelegateImpl2.mActionModeView.killMode();
                        appCompatDelegateImpl2.mFadeAnim.setListener(null);
                        appCompatDelegateImpl2.mFadeAnim = null;
                        ViewGroup viewGroup = appCompatDelegateImpl2.mSubDecor;
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
                    }
                });
            }
            AppCompatCallback appCompatCallback = appCompatDelegateImpl.mAppCompatCallback;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl.mActionMode);
            }
            appCompatDelegateImpl.mActionMode = null;
            ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
            ViewGroup viewGroup = AppCompatDelegateImpl.this.mSubDecor;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
            return this.mWrapped.onPrepareActionMode(actionMode, menuBuilder);
        }
    }

    /* loaded from: classes.dex */
    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        public ActionBarMenuCallback mActionBarCallback;

        public AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:            if (r6 != false) goto L48;     */
        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                boolean r0 = super.dispatchKeyShortcutEvent(r6)
                r1 = 1
                if (r0 != 0) goto L4f
                int r0 = r6.getKeyCode()
                androidx.appcompat.app.AppCompatDelegateImpl r2 = androidx.appcompat.app.AppCompatDelegateImpl.this
                r2.initWindowDecorActionBar()
                androidx.appcompat.app.ActionBar r3 = r2.mActionBar
                r4 = 0
                if (r3 == 0) goto L1c
                boolean r0 = r3.onKeyShortcut(r0, r6)
                if (r0 == 0) goto L1c
                goto L48
            L1c:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r2.mPreparedPanel
                if (r0 == 0) goto L31
                int r3 = r6.getKeyCode()
                boolean r0 = r2.performPanelShortcut(r0, r3, r6)
                if (r0 == 0) goto L31
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r6 = r2.mPreparedPanel
                if (r6 == 0) goto L48
                r6.isHandled = r1
                goto L48
            L31:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r2.mPreparedPanel
                if (r0 != 0) goto L4a
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r2.getPanelState(r4)
                r2.preparePanel(r0, r6)
                int r3 = r6.getKeyCode()
                boolean r6 = r2.performPanelShortcut(r0, r3, r6)
                r0.isPrepared = r4
                if (r6 == 0) goto L4a
            L48:
                r6 = r1
                goto L4b
            L4a:
                r6 = r4
            L4b:
                if (r6 == 0) goto L4e
                goto L4f
            L4e:
                r1 = r4
            L4f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean onCreatePanelMenu(int r2, Menu menu) {
            if (r2 == 0 && !(menu instanceof MenuBuilder)) {
                return false;
            }
            return super.onCreatePanelMenu(r2, menu);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final View onCreatePanelView(int r3) {
            View view;
            ActionBarMenuCallback actionBarMenuCallback = this.mActionBarCallback;
            if (actionBarMenuCallback != null) {
                ToolbarActionBar.ToolbarMenuCallback toolbarMenuCallback = (ToolbarActionBar.ToolbarMenuCallback) actionBarMenuCallback;
                if (r3 == 0) {
                    view = new View(ToolbarActionBar.this.mDecorToolbar.getContext());
                } else {
                    view = null;
                }
                if (view != null) {
                    return view;
                }
            }
            return super.onCreatePanelView(r3);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean onMenuOpened(int r3, Menu menu) {
            super.onMenuOpened(r3, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (r3 == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(true);
                }
            } else {
                appCompatDelegateImpl.getClass();
            }
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final void onPanelClosed(int r3, Menu menu) {
            super.onPanelClosed(r3, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (r3 == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(false);
                    return;
                }
                return;
            }
            if (r3 == 0) {
                PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(r3);
                if (panelState.isOpen) {
                    appCompatDelegateImpl.closePanel(panelState, false);
                    return;
                }
                return;
            }
            appCompatDelegateImpl.getClass();
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean onPreparePanel(int r6, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (r6 == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = true;
            }
            ActionBarMenuCallback actionBarMenuCallback = this.mActionBarCallback;
            if (actionBarMenuCallback != null) {
                ToolbarActionBar.ToolbarMenuCallback toolbarMenuCallback = (ToolbarActionBar.ToolbarMenuCallback) actionBarMenuCallback;
                if (r6 == 0) {
                    ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                    if (!toolbarActionBar.mToolbarMenuPrepared) {
                        toolbarActionBar.mDecorToolbar.mMenuPrepared = true;
                        toolbarActionBar.mToolbarMenuPrepared = true;
                    }
                }
            }
            boolean onPreparePanel = super.onPreparePanel(r6, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = false;
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int r5) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.getPanelState(0).menu;
            if (menuBuilder != null) {
                super.onProvideKeyboardShortcuts(list, menuBuilder, r5);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, r5);
            }
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int r4) {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.mHandleNativeActionModes && r4 == 0) {
                SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(appCompatDelegateImpl.mContext, callback);
                androidx.appcompat.view.ActionMode startSupportActionMode = appCompatDelegateImpl.startSupportActionMode(callbackWrapper);
                if (startSupportActionMode != null) {
                    return callbackWrapper.getActionModeWrapper(startSupportActionMode);
                }
                return null;
            }
            return super.onWindowStartingActionMode(callback, r4);
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
        }
    }

    /* loaded from: classes.dex */
    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        public final PowerManager mPowerManager;

        public AutoBatteryNightModeManager(Context context) {
            super();
            this.mPowerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final int getApplyableNightMode() {
            if (this.mPowerManager.isPowerSaveMode()) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final void onChange() {
            AppCompatDelegateImpl.this.applyDayNight(true);
        }
    }

    /* loaded from: classes.dex */
    public abstract class AutoNightModeManager {
        public AnonymousClass1 mReceiver;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends BroadcastReceiver {
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                AutoNightModeManager.this.onChange();
            }
        }

        public AutoNightModeManager() {
        }

        public final void cleanup() {
            AnonymousClass1 anonymousClass1 = this.mReceiver;
            if (anonymousClass1 != null) {
                try {
                    AppCompatDelegateImpl.this.mContext.unregisterReceiver(anonymousClass1);
                } catch (IllegalArgumentException unused) {
                }
                this.mReceiver = null;
            }
        }

        public abstract IntentFilter createIntentFilterForBroadcastReceiver();

        public abstract int getApplyableNightMode();

        public abstract void onChange();

        public final void setup() {
            cleanup();
            IntentFilter createIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
            if (createIntentFilterForBroadcastReceiver != null && createIntentFilterForBroadcastReceiver.countActions() != 0) {
                if (this.mReceiver == null) {
                    this.mReceiver = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                        public AnonymousClass1() {
                        }

                        @Override // android.content.BroadcastReceiver
                        public final void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.onChange();
                        }
                    };
                }
                AppCompatDelegateImpl.this.mContext.registerReceiver(this.mReceiver, createIntentFilterForBroadcastReceiver);
            }
        }
    }

    /* loaded from: classes.dex */
    public class AutoTimeNightModeManager extends AutoNightModeManager {
        public final TwilightManager mTwilightManager;

        public AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.mTwilightManager = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final int getApplyableNightMode() {
            boolean z;
            Location location;
            boolean z2;
            long j;
            long j2;
            Location location2;
            TwilightManager twilightManager = this.mTwilightManager;
            TwilightManager.TwilightState twilightState = twilightManager.mTwilightState;
            boolean z3 = false;
            if (twilightState.nextUpdate > System.currentTimeMillis()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = twilightState.isNight;
            } else {
                Context context = twilightManager.mContext;
                int checkSelfPermission = PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
                Location location3 = null;
                LocationManager locationManager = twilightManager.mLocationManager;
                if (checkSelfPermission == 0) {
                    try {
                    } catch (Exception e) {
                        Log.d("TwilightManager", "Failed to get last known location", e);
                    }
                    if (locationManager.isProviderEnabled("network")) {
                        location2 = locationManager.getLastKnownLocation("network");
                        location = location2;
                    }
                    location2 = null;
                    location = location2;
                } else {
                    location = null;
                }
                if (PermissionChecker.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    try {
                        if (locationManager.isProviderEnabled("gps")) {
                            location3 = locationManager.getLastKnownLocation("gps");
                        }
                    } catch (Exception e2) {
                        Log.d("TwilightManager", "Failed to get last known location", e2);
                    }
                }
                if (location3 == null || location == null ? location3 != null : location3.getTime() > location.getTime()) {
                    location = location3;
                }
                if (location != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TwilightCalculator.sInstance == null) {
                        TwilightCalculator.sInstance = new TwilightCalculator();
                    }
                    TwilightCalculator twilightCalculator = TwilightCalculator.sInstance;
                    twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                    twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
                    if (twilightCalculator.state == 1) {
                        z3 = true;
                    }
                    long j3 = twilightCalculator.sunrise;
                    long j4 = twilightCalculator.sunset;
                    twilightCalculator.calculateTwilight(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                    long j5 = twilightCalculator.sunrise;
                    if (j3 != -1 && j4 != -1) {
                        if (currentTimeMillis > j4) {
                            j2 = j5 + 0;
                        } else if (currentTimeMillis > j3) {
                            j2 = j4 + 0;
                        } else {
                            j2 = j3 + 0;
                        }
                        j = j2 + 60000;
                    } else {
                        j = 43200000 + currentTimeMillis;
                    }
                    twilightState.isNight = z3;
                    twilightState.nextUpdate = j;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int r0 = Calendar.getInstance().get(11);
                    if (r0 < 6 || r0 >= 22) {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (!z2) {
                return 1;
            }
            return 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final void onChange() {
            AppCompatDelegateImpl.this.applyDayNight(true);
        }
    }

    /* loaded from: classes.dex */
    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(ContextThemeWrapper contextThemeWrapper) {
            super(contextThemeWrapper, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            boolean z;
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x >= -5 && y >= -5 && x <= getWidth() + 5 && y <= getHeight() + 5) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.closePanel(appCompatDelegateImpl.getPanelState(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int r2) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), r2));
        }
    }

    /* loaded from: classes.dex */
    public static final class PanelFeatureState {
        public int background;
        public View createdPanelView;
        public ListMenuDecorView decorView;
        public final int featureId;
        public Bundle frozenActionViewState;
        public int gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public ContextThemeWrapper listPresenterContext;
        public MenuBuilder menu;
        public boolean refreshDecorView = false;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public int windowAnimations;

        public PanelFeatureState(int r1) {
            this.featureId = r1;
        }
    }

    /* loaded from: classes.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        public PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            boolean z2;
            int r6;
            PanelFeatureState panelFeatureState;
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            int r1 = 0;
            if (rootMenu != menuBuilder) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                menuBuilder = rootMenu;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.mPanels;
            if (panelFeatureStateArr != null) {
                r6 = panelFeatureStateArr.length;
            } else {
                r6 = 0;
            }
            while (true) {
                if (r1 < r6) {
                    panelFeatureState = panelFeatureStateArr[r1];
                    if (panelFeatureState != null && panelFeatureState.menu == menuBuilder) {
                        break;
                    } else {
                        r1++;
                    }
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                if (z2) {
                    appCompatDelegateImpl.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, rootMenu);
                    appCompatDelegateImpl.closePanel(panelFeatureState, true);
                } else {
                    appCompatDelegateImpl.closePanel(panelFeatureState, z);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback;
            if (menuBuilder == menuBuilder.getRootMenu()) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (appCompatDelegateImpl.mHasActionBar && (windowCallback = appCompatDelegateImpl.getWindowCallback()) != null && !appCompatDelegateImpl.mDestroyed) {
                    windowCallback.onMenuOpened(108, menuBuilder);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        SimpleArrayMap<String, Integer> simpleArrayMap;
        Integer orDefault;
        AppCompatActivity appCompatActivity;
        this.mLocalNightMode = -100;
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (context instanceof AppCompatActivity) {
                    appCompatActivity = (AppCompatActivity) context;
                    break;
                } else if (!(context instanceof ContextWrapper)) {
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            appCompatActivity = null;
            if (appCompatActivity != null) {
                this.mLocalNightMode = appCompatActivity.getDelegate().getLocalNightMode();
            }
        }
        if (this.mLocalNightMode == -100 && (orDefault = (simpleArrayMap = sLocalNightModes).getOrDefault(this.mHost.getClass().getName(), null)) != null) {
            this.mLocalNightMode = orDefault.intValue();
            simpleArrayMap.remove(this.mHost.getClass().getName());
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    public static Configuration createOverrideConfigurationForDayNight(Context context, int r2, Configuration configuration) {
        int r1;
        if (r2 != 1) {
            if (r2 != 2) {
                r1 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
            } else {
                r1 = 32;
            }
        } else {
            r1 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = r1 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(R.id.content)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean applyDayNight(boolean r13) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.applyDayNight(boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01a3  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.Context attachBaseContext2(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.attachBaseContext2(android.content.Context):android.content.Context");
    }

    public final void attachToWindow(Window window) {
        int resourceId;
        Drawable drawable;
        if (this.mWindow == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.mAppCompatWindowCallback = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                int[] r0 = sWindowBackgroundStyleable;
                Context context = this.mContext;
                Drawable drawable2 = null;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, r0);
                if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                    AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
                    synchronized (appCompatDrawableManager) {
                        drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
                    }
                    drawable2 = drawable;
                }
                if (drawable2 != null) {
                    window.setBackgroundDrawable(drawable2);
                }
                obtainStyledAttributes.recycle();
                this.mWindow = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final void callOnPanelClosed(int r3, PanelFeatureState panelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (panelFeatureState == null && r3 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (r3 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[r3];
                }
            }
            if (panelFeatureState != null) {
                menuBuilder = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mDestroyed) {
            this.mAppCompatWindowCallback.mWrapped.onPanelClosed(r3, menuBuilder);
        }
    }

    public final void checkCloseActionMenu(MenuBuilder menuBuilder) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !this.mDestroyed) {
            windowCallback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public final void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        ListMenuDecorView listMenuDecorView;
        DecorContentParent decorContentParent;
        if (z && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null && decorContentParent.isOverflowMenuShowing()) {
            checkCloseActionMenu(panelFeatureState.menu);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && (listMenuDecorView = panelFeatureState.decorView) != null) {
            windowManager.removeView(listMenuDecorView);
            if (z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public final void doInvalidatePanelMenu(int r4) {
        PanelFeatureState panelState = getPanelState(r4);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((r4 == 108 || r4 == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0);
            panelState2.isPrepared = false;
            preparePanel(panelState2, null);
        }
    }

    public final void ensureSubDecor() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.mSubDecorInstalled) {
            int[] r0 = R$styleable.AppCompatTheme;
            Context context2 = this.mContext;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(r0);
            if (obtainStyledAttributes.hasValue(117)) {
                if (obtainStyledAttributes.getBoolean(126, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(117, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(118, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(119, false)) {
                    requestWindowFeature(10);
                }
                this.mIsFloating = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                ensureWindow();
                this.mWindow.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (!this.mWindowNoTitle) {
                    if (this.mIsFloating) {
                        viewGroup = (ViewGroup) from.inflate(com.kronaby.watch.app.R.layout.abc_dialog_title_material, (ViewGroup) null);
                        this.mOverlayActionBar = false;
                        this.mHasActionBar = false;
                    } else if (this.mHasActionBar) {
                        TypedValue typedValue = new TypedValue();
                        context2.getTheme().resolveAttribute(com.kronaby.watch.app.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            context = new ContextThemeWrapper(context2, typedValue.resourceId);
                        } else {
                            context = context2;
                        }
                        viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(com.kronaby.watch.app.R.layout.abc_screen_toolbar, (ViewGroup) null);
                        DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(com.kronaby.watch.app.R.id.decor_content_parent);
                        this.mDecorContentParent = decorContentParent;
                        decorContentParent.setWindowCallback(getWindowCallback());
                        if (this.mOverlayActionBar) {
                            this.mDecorContentParent.initFeature(109);
                        }
                        if (this.mFeatureProgress) {
                            this.mDecorContentParent.initFeature(2);
                        }
                        if (this.mFeatureIndeterminateProgress) {
                            this.mDecorContentParent.initFeature(5);
                        }
                    } else {
                        viewGroup = null;
                    }
                } else {
                    viewGroup = this.mOverlayActionMode ? (ViewGroup) from.inflate(com.kronaby.watch.app.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(com.kronaby.watch.app.R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (viewGroup != null) {
                    AnonymousClass3 anonymousClass3 = new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
                        public AnonymousClass3() {
                        }

                        @Override // androidx.core.view.OnApplyWindowInsetsListener
                        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            boolean z;
                            View view2;
                            WindowInsetsCompat windowInsetsCompat2;
                            int systemWindowInsetLeft;
                            int systemWindowInsetRight;
                            boolean z2;
                            int color;
                            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                            appCompatDelegateImpl.getClass();
                            int systemWindowInsetTop2 = windowInsetsCompat.getSystemWindowInsetTop();
                            ActionBarContextView actionBarContextView = appCompatDelegateImpl.mActionModeView;
                            int r5 = 0;
                            if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.mActionModeView.getLayoutParams();
                                boolean z3 = true;
                                if (appCompatDelegateImpl.mActionModeView.isShown()) {
                                    if (appCompatDelegateImpl.mTempRect1 == null) {
                                        appCompatDelegateImpl.mTempRect1 = new Rect();
                                        appCompatDelegateImpl.mTempRect2 = new Rect();
                                    }
                                    Rect rect = appCompatDelegateImpl.mTempRect1;
                                    Rect rect2 = appCompatDelegateImpl.mTempRect2;
                                    rect.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                                    ViewGroup viewGroup2 = appCompatDelegateImpl.mSubDecor;
                                    Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                                    if (method != null) {
                                        try {
                                            method.invoke(viewGroup2, rect, rect2);
                                        } catch (Exception e) {
                                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                                        }
                                    }
                                    int r02 = rect.top;
                                    int r10 = rect.left;
                                    int r9 = rect.right;
                                    ViewGroup viewGroup22 = appCompatDelegateImpl.mSubDecor;
                                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                    WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(viewGroup22);
                                    if (rootWindowInsets == null) {
                                        systemWindowInsetLeft = 0;
                                    } else {
                                        systemWindowInsetLeft = rootWindowInsets.getSystemWindowInsetLeft();
                                    }
                                    if (rootWindowInsets == null) {
                                        systemWindowInsetRight = 0;
                                    } else {
                                        systemWindowInsetRight = rootWindowInsets.getSystemWindowInsetRight();
                                    }
                                    if (marginLayoutParams.topMargin == r02 && marginLayoutParams.leftMargin == r10 && marginLayoutParams.rightMargin == r9) {
                                        z2 = false;
                                    } else {
                                        marginLayoutParams.topMargin = r02;
                                        marginLayoutParams.leftMargin = r10;
                                        marginLayoutParams.rightMargin = r9;
                                        z2 = true;
                                    }
                                    Context context3 = appCompatDelegateImpl.mContext;
                                    if (r02 > 0 && appCompatDelegateImpl.mStatusGuard == null) {
                                        View view3 = new View(context3);
                                        appCompatDelegateImpl.mStatusGuard = view3;
                                        view3.setVisibility(8);
                                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                                        layoutParams.leftMargin = systemWindowInsetLeft;
                                        layoutParams.rightMargin = systemWindowInsetRight;
                                        appCompatDelegateImpl.mSubDecor.addView(appCompatDelegateImpl.mStatusGuard, -1, layoutParams);
                                    } else {
                                        View view4 = appCompatDelegateImpl.mStatusGuard;
                                        if (view4 != null) {
                                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view4.getLayoutParams();
                                            int r13 = marginLayoutParams2.height;
                                            int r14 = marginLayoutParams.topMargin;
                                            if (r13 != r14 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                                                marginLayoutParams2.height = r14;
                                                marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                                                marginLayoutParams2.rightMargin = systemWindowInsetRight;
                                                appCompatDelegateImpl.mStatusGuard.setLayoutParams(marginLayoutParams2);
                                            }
                                        }
                                    }
                                    View view5 = appCompatDelegateImpl.mStatusGuard;
                                    if (view5 != null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z && view5.getVisibility() != 0) {
                                        View view6 = appCompatDelegateImpl.mStatusGuard;
                                        if ((ViewCompat.Api16Impl.getWindowSystemUiVisibility(view6) & DfuBaseService.ERROR_REMOTE_MASK) == 0) {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            Object obj = ContextCompat.sLock;
                                            color = ContextCompat.Api23Impl.getColor(context3, com.kronaby.watch.app.R.color.abc_decor_view_status_guard_light);
                                        } else {
                                            Object obj2 = ContextCompat.sLock;
                                            color = ContextCompat.Api23Impl.getColor(context3, com.kronaby.watch.app.R.color.abc_decor_view_status_guard);
                                        }
                                        view6.setBackgroundColor(color);
                                    }
                                    if (!appCompatDelegateImpl.mOverlayActionMode && z) {
                                        systemWindowInsetTop2 = 0;
                                    }
                                    z3 = z2;
                                } else if (marginLayoutParams.topMargin != 0) {
                                    marginLayoutParams.topMargin = 0;
                                    z = false;
                                } else {
                                    z3 = false;
                                    z = false;
                                }
                                if (z3) {
                                    appCompatDelegateImpl.mActionModeView.setLayoutParams(marginLayoutParams);
                                }
                            } else {
                                z = false;
                            }
                            View view7 = appCompatDelegateImpl.mStatusGuard;
                            if (view7 != null) {
                                if (!z) {
                                    r5 = 8;
                                }
                                view7.setVisibility(r5);
                            }
                            if (systemWindowInsetTop != systemWindowInsetTop2) {
                                windowInsetsCompat2 = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), systemWindowInsetTop2, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                                view2 = view;
                            } else {
                                view2 = view;
                                windowInsetsCompat2 = windowInsetsCompat;
                            }
                            return ViewCompat.onApplyWindowInsets(view2, windowInsetsCompat2);
                        }
                    };
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(viewGroup, anonymousClass3);
                    if (this.mDecorContentParent == null) {
                        this.mTitleView = (TextView) viewGroup.findViewById(com.kronaby.watch.app.R.id.title);
                    }
                    Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, new Object[0]);
                    } catch (IllegalAccessException e) {
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
                    } catch (NoSuchMethodException unused) {
                        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                    } catch (InvocationTargetException e2) {
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.kronaby.watch.app.R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(R.id.content);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(R.id.content);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.mWindow.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new AnonymousClass5());
                    this.mSubDecor = viewGroup;
                    Object obj = this.mHost;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.mTitle;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        DecorContentParent decorContentParent2 = this.mDecorContentParent;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setWindowTitle(charSequence);
                        } else {
                            ActionBar actionBar = this.mActionBar;
                            if (actionBar != null) {
                                actionBar.setWindowTitle(charSequence);
                            } else {
                                TextView textView = this.mTitleView;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.mSubDecor.findViewById(R.id.content);
                    View decorView = this.mWindow.getDecorView();
                    contentFrameLayout2.mDecorPadding.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    if (ViewCompat.Api19Impl.isLaidOut(contentFrameLayout2)) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(r0);
                    obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(122)) {
                        obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(123)) {
                        obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(120)) {
                        obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(121)) {
                        obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.mSubDecorInstalled = true;
                    PanelFeatureState panelState = getPanelState(0);
                    if (!this.mDestroyed && panelState.menu == null) {
                        this.mInvalidatePanelMenuFeatures |= 4096;
                        if (!this.mInvalidatePanelMenuPosted) {
                            ViewCompat.Api16Impl.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
                            this.mInvalidatePanelMenuPosted = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow != null) {
        } else {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final <T extends View> T findViewById(int r2) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(r2);
    }

    public final AutoNightModeManager getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            if (TwilightManager.sInstance == null) {
                Context applicationContext = context.getApplicationContext();
                TwilightManager.sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(TwilightManager.sInstance);
        }
        return this.mAutoTimeNightModeManager;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawableToggleImpl getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final MenuInflater getMenuInflater() {
        Context context;
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                context = actionBar.getThemedContext();
            } else {
                context = this.mContext;
            }
            this.mMenuInflater = new SupportMenuInflater(context);
        }
        return this.mMenuInflater;
    }

    public final PanelFeatureState getPanelState(int r5) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= r5) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[r5 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[r5];
        if (panelFeatureState == null) {
            PanelFeatureState panelFeatureState2 = new PanelFeatureState(r5);
            panelFeatureStateArr[r5] = panelFeatureState2;
            return panelFeatureState2;
        }
        return panelFeatureState;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public final void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity) obj, this.mOverlayActionBar);
            } else if (obj instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void invalidateOptionsMenu() {
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null && actionBar.invalidateOptionsMenu()) {
            return;
        }
        this.mInvalidatePanelMenuFeatures |= 1;
        if (!this.mInvalidatePanelMenuPosted) {
            View decorView = this.mWindow.getDecorView();
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api16Impl.postOnAnimation(decorView, this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    public final int mapNightMode(Context context, int r4) {
        if (r4 == -100) {
            return -1;
        }
        if (r4 != -1) {
            if (r4 != 0) {
                if (r4 != 1 && r4 != 2) {
                    if (r4 == 3) {
                        if (this.mAutoBatteryNightModeManager == null) {
                            this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(context);
                        }
                        return this.mAutoBatteryNightModeManager.getApplyableNightMode();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return getAutoTimeNightModeManager(context).getApplyableNightMode();
            }
        }
        return r4;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onConfigurationChanged(Configuration configuration) {
        if (this.mHasActionBar && this.mSubDecorInstalled) {
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.onConfigurationChanged();
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = this.mContext;
        synchronized (appCompatDrawableManager) {
            ResourceManagerInternal resourceManagerInternal = appCompatDrawableManager.mResourceManager;
            synchronized (resourceManagerInternal) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = resourceManagerInternal.mDrawableCaches.get(context);
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        applyDayNight(false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onCreate() {
        String str;
        this.mBaseContextAttached = true;
        applyDayNight(false);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = NavUtils.getParentActivityName(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar actionBar = this.mActionBar;
                if (actionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
                AppCompatDelegate.sActivityDelegates.add(new WeakReference<>(this));
            }
        }
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0112, code lost:            if (r10.equals("ImageButton") == false) goto L229;     */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mHost
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = androidx.appcompat.app.AppCompatDelegate.sActivityDelegatesLock
            monitor-enter(r0)
            androidx.appcompat.app.AppCompatDelegate.removeDelegateFromActives(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.mInvalidatePanelMenuPosted
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.mWindow
            android.view.View r0 = r0.getDecorView()
            androidx.appcompat.app.AppCompatDelegateImpl$2 r1 = r3.mInvalidatePanelMenuRunnable
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.mDestroyed = r0
            int r0 = r3.mLocalNightMode
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.mHost
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.sLocalNightModes
            java.lang.Object r1 = r3.mHost
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.mLocalNightMode
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.sLocalNightModes
            java.lang.Object r1 = r3.mHost
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            androidx.appcompat.app.ActionBar r0 = r3.mActionBar
            if (r0 == 0) goto L63
            r0.onDestroy()
        L63:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoTimeNightModeManager r0 = r3.mAutoTimeNightModeManager
            if (r0 == 0) goto L6a
            r0.cleanup()
        L6a:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoBatteryNightModeManager r0 = r3.mAutoBatteryNightModeManager
            if (r0 == 0) goto L71
            r0.cleanup()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onDestroy():void");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        int r3;
        int r4;
        PanelFeatureState panelFeatureState;
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !this.mDestroyed) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            PanelFeatureState[] panelFeatureStateArr = this.mPanels;
            if (panelFeatureStateArr != null) {
                r3 = panelFeatureStateArr.length;
                r4 = 0;
            } else {
                r3 = 0;
                r4 = 0;
            }
            while (true) {
                if (r4 < r3) {
                    panelFeatureState = panelFeatureStateArr[r4];
                    if (panelFeatureState != null && panelFeatureState.menu == rootMenu) {
                        break;
                    }
                    r4++;
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                return windowCallback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey() || this.mDecorContentParent.isOverflowMenuShowPending())) {
            Window.Callback windowCallback = getWindowCallback();
            if (this.mDecorContentParent.isOverflowMenuShowing()) {
                this.mDecorContentParent.hideOverflowMenu();
                if (!this.mDestroyed) {
                    windowCallback.onPanelClosed(108, getPanelState(0).menu);
                    return;
                }
                return;
            }
            if (windowCallback != null && !this.mDestroyed) {
                if (this.mInvalidatePanelMenuPosted && (1 & this.mInvalidatePanelMenuFeatures) != 0) {
                    View decorView = this.mWindow.getDecorView();
                    AnonymousClass2 anonymousClass2 = this.mInvalidatePanelMenuRunnable;
                    decorView.removeCallbacks(anonymousClass2);
                    anonymousClass2.run();
                }
                PanelFeatureState panelState = getPanelState(0);
                MenuBuilder menuBuilder2 = panelState.menu;
                if (menuBuilder2 != null && !panelState.refreshMenuContent && windowCallback.onPreparePanel(0, panelState.createdPanelView, menuBuilder2)) {
                    windowCallback.onMenuOpened(108, panelState.menu);
                    this.mDecorContentParent.showOverflowMenu();
                    return;
                }
                return;
            }
            return;
        }
        PanelFeatureState panelState2 = getPanelState(0);
        panelState2.refreshDecorView = true;
        closePanel(panelState2, false);
        openPanel(panelState2, null);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onPostCreate() {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onPostResume() {
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onStart() {
        applyDayNight(true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onStop() {
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0175, code lost:            if (r15.mAdapter.getCount() > 0) goto L208;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0151, code lost:            if (r15 != null) goto L194;     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void openPanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.openPanel(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean performPanelShortcut(PanelFeatureState panelFeatureState, int r4, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((!panelFeatureState.isPrepared && !preparePanel(panelFeatureState, keyEvent)) || (menuBuilder = panelFeatureState.menu) == null) {
            return false;
        }
        return menuBuilder.performShortcut(r4, keyEvent, 1);
    }

    public final boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        Resources.Theme theme;
        int r14;
        boolean z2;
        DecorContentParent decorContentParent3;
        DecorContentParent decorContentParent4;
        if (this.mDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            closePanel(panelFeatureState2, false);
        }
        Window.Callback windowCallback = getWindowCallback();
        int r3 = panelFeatureState.featureId;
        if (windowCallback != null) {
            panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(r3);
        }
        if (r3 != 0 && r3 != 108) {
            z = false;
        } else {
            z = true;
        }
        if (z && (decorContentParent4 = this.mDecorContentParent) != null) {
            decorContentParent4.setMenuPrepared();
        }
        if (panelFeatureState.createdPanelView == null && (!z || !(this.mActionBar instanceof ToolbarActionBar))) {
            MenuBuilder menuBuilder = panelFeatureState.menu;
            if (menuBuilder == null || panelFeatureState.refreshMenuContent) {
                if (menuBuilder == null) {
                    Context context = this.mContext;
                    if ((r3 == 0 || r3 == 108) && this.mDecorContentParent != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(com.kronaby.watch.app.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(com.kronaby.watch.app.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(com.kronaby.watch.app.R.attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(theme);
                            context = contextThemeWrapper;
                        }
                    }
                    MenuBuilder menuBuilder2 = new MenuBuilder(context);
                    menuBuilder2.mCallback = this;
                    MenuBuilder menuBuilder3 = panelFeatureState.menu;
                    if (menuBuilder2 != menuBuilder3) {
                        if (menuBuilder3 != null) {
                            menuBuilder3.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                        }
                        panelFeatureState.menu = menuBuilder2;
                        ListMenuPresenter listMenuPresenter = panelFeatureState.listMenuPresenter;
                        if (listMenuPresenter != null) {
                            menuBuilder2.addMenuPresenter(listMenuPresenter, menuBuilder2.mContext);
                        }
                    }
                    if (panelFeatureState.menu == null) {
                        return false;
                    }
                }
                if (z && (decorContentParent2 = this.mDecorContentParent) != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                    }
                    decorContentParent2.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!windowCallback.onCreatePanelMenu(r3, panelFeatureState.menu)) {
                    MenuBuilder menuBuilder4 = panelFeatureState.menu;
                    if (menuBuilder4 != null) {
                        if (menuBuilder4 != null) {
                            menuBuilder4.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                        }
                        panelFeatureState.menu = null;
                    }
                    if (z && (decorContentParent = this.mDecorContentParent) != null) {
                        decorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.frozenActionViewState;
            if (bundle != null) {
                panelFeatureState.menu.restoreActionViewStates(bundle);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z && (decorContentParent3 = this.mDecorContentParent) != null) {
                    decorContentParent3.setMenu(null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            if (keyEvent != null) {
                r14 = keyEvent.getDeviceId();
            } else {
                r14 = -1;
            }
            if (KeyCharacterMap.load(r14).getKeyboardType() != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            panelFeatureState.menu.setQwertyMode(z2);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean requestWindowFeature(int r6) {
        if (r6 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            r6 = 108;
        } else if (r6 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            r6 = 109;
        }
        if (this.mWindowNoTitle && r6 == 108) {
            return false;
        }
        if (this.mHasActionBar && r6 == 1) {
            this.mHasActionBar = false;
        }
        if (r6 != 1) {
            if (r6 != 2) {
                if (r6 != 5) {
                    if (r6 != 10) {
                        if (r6 != 108) {
                            if (r6 != 109) {
                                return this.mWindow.requestFeature(r6);
                            }
                            throwFeatureRequestIfSubDecorInstalled();
                            this.mOverlayActionBar = true;
                            return true;
                        }
                        throwFeatureRequestIfSubDecorInstalled();
                        this.mHasActionBar = true;
                        return true;
                    }
                    throwFeatureRequestIfSubDecorInstalled();
                    this.mOverlayActionMode = true;
                    return true;
                }
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = true;
                return true;
            }
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setSupportActionBar(Toolbar toolbar) {
        CharSequence charSequence;
        Object obj = this.mHost;
        if (!(obj instanceof Activity)) {
            return;
        }
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        if (!(actionBar instanceof WindowDecorActionBar)) {
            this.mMenuInflater = null;
            if (actionBar != null) {
                actionBar.onDestroy();
            }
            this.mActionBar = null;
            if (toolbar != null) {
                if (obj instanceof Activity) {
                    charSequence = ((Activity) obj).getTitle();
                } else {
                    charSequence = this.mTitle;
                }
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, charSequence, this.mAppCompatWindowCallback);
                this.mActionBar = toolbarActionBar;
                this.mAppCompatWindowCallback.mActionBarCallback = toolbarActionBar.mMenuCallback;
            } else {
                this.mAppCompatWindowCallback.mActionBarCallback = null;
            }
            invalidateOptionsMenu();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTheme(int r1) {
        this.mThemeResId = r1;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x013c, code lost:            if (androidx.core.view.ViewCompat.Api19Impl.isLaidOut(r9) != false) goto L146;     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.appcompat.view.ActionMode startSupportActionMode(androidx.appcompat.view.ActionMode.Callback r9) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.startSupportActionMode(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public final void throwFeatureRequestIfSubDecorInstalled() {
        if (!this.mSubDecorInstalled) {
        } else {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(int r3) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(r3, viewGroup);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onSaveInstanceState() {
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
