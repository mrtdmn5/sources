package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes3.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialog$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        public final WindowInsetsCompat insetsCompat;
        public final boolean lightBottomSheet;
        public final boolean lightStatusBar;

        public EdgeToEdgeCallback(FrameLayout frameLayout, WindowInsetsCompat windowInsetsCompat) {
            boolean z;
            ColorStateList backgroundTintList;
            this.insetsCompat = windowInsetsCompat;
            if ((frameLayout.getSystemUiVisibility() & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.lightStatusBar = z;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(frameLayout).materialShapeDrawable;
            if (materialShapeDrawable != null) {
                backgroundTintList = materialShapeDrawable.drawableState.fillColor;
            } else {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                backgroundTintList = ViewCompat.Api21Impl.getBackgroundTintList(frameLayout);
            }
            if (backgroundTintList != null) {
                this.lightBottomSheet = MaterialColors.isColorLight(backgroundTintList.getDefaultColor());
            } else if (frameLayout.getBackground() instanceof ColorDrawable) {
                this.lightBottomSheet = MaterialColors.isColorLight(((ColorDrawable) frameLayout.getBackground()).getColor());
            } else {
                this.lightBottomSheet = z;
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onLayout(View view) {
            setPaddingForPosition(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View view, float f) {
            setPaddingForPosition(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View view, int r2) {
            setPaddingForPosition(view);
        }

        public final void setPaddingForPosition(View view) {
            int top = view.getTop();
            WindowInsetsCompat windowInsetsCompat = this.insetsCompat;
            if (top < windowInsetsCompat.getSystemWindowInsetTop()) {
                BottomSheetDialog.setLightStatusBar(view, this.lightBottomSheet);
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.setLightStatusBar(view, this.lightStatusBar);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }
    }

    public BottomSheetDialog(Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.bottomSheetCallback;
            ArrayList<BottomSheetBehavior.BottomSheetCallback> arrayList = from.callbacks;
            if (!arrayList.contains(bottomSheetCallback)) {
                arrayList.add(bottomSheetCallback);
            }
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private static int getThemeResId(Context context, int r3) {
        if (r3 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            return 2132083335;
        }
        return r3;
    }

    public static void setLightStatusBar(View view, boolean z) {
        int r2;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            r2 = systemUiVisibility | DfuBaseService.ERROR_REMOTE_MASK;
        } else {
            r2 = systemUiVisibility & (-8193);
        }
        view.setSystemUiVisibility(r2);
    }

    private View wrapInBottomSheet(int r4, View view, ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (r4 != 0 && view == null) {
            view = getLayoutInflater().inflate(r4, (ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            FrameLayout frameLayout = this.bottomSheet;
            OnApplyWindowInsetsListener onApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.edgeToEdgeCallback != null) {
                        BottomSheetBehavior bottomSheetBehavior = bottomSheetDialog.behavior;
                        bottomSheetBehavior.callbacks.remove(bottomSheetDialog.edgeToEdgeCallback);
                    }
                    bottomSheetDialog.edgeToEdgeCallback = new EdgeToEdgeCallback(bottomSheetDialog.bottomSheet, windowInsetsCompat);
                    BottomSheetBehavior bottomSheetBehavior2 = bottomSheetDialog.behavior;
                    BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = bottomSheetDialog.edgeToEdgeCallback;
                    ArrayList<BottomSheetBehavior.BottomSheetCallback> arrayList = bottomSheetBehavior2.callbacks;
                    if (!arrayList.contains(bottomSheetCallback)) {
                        arrayList.add(bottomSheetCallback);
                    }
                    return windowInsetsCompat;
                }
            };
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(frameLayout, onApplyWindowInsetsListener);
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && bottomSheetDialog.shouldWindowCloseOnTouchOutside()) {
                    bottomSheetDialog.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AccessibilityDelegateCompat() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
                AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                if (BottomSheetDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.addAction(Constants.MB);
                    accessibilityNodeInfo.setDismissable(true);
                } else {
                    accessibilityNodeInfo.setDismissable(false);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view2, int r42, Bundle bundle) {
                if (r42 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.cancelable) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view2, r42, bundle);
            }
        });
        this.bottomSheet.setOnTouchListener(new AnonymousClass4());
        return this.container;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        if (this.dismissWithAnimation && behavior.state != 5) {
            behavior.setState(5);
        } else {
            super.cancel();
        }
    }

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255) {
                z = true;
            } else {
                z = false;
            }
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            if (z) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.state == 5) {
            bottomSheetBehavior.setState(4);
        }
    }

    public void removeDefaultCallback() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        bottomSheetBehavior.callbacks.remove(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    public void setDismissWithAnimation(boolean z) {
        this.dismissWithAnimation = z;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public BottomSheetDialog(Context context, int r2) {
        super(context, getThemeResId(context, r2));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View view, int r22) {
                if (r22 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View view, float f) {
            }
        };
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View view, int r22) {
                if (r22 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View view, float f) {
            }
        };
        supportRequestWindowFeature(1);
        this.cancelable = z;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
