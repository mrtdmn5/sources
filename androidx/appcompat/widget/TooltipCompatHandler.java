package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.kronaby.watch.app.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static TooltipCompatHandler sActiveHandler;
    public static TooltipCompatHandler sPendingHandler;
    public final View mAnchor;
    public int mAnchorX;
    public int mAnchorY;
    public boolean mFromTouch;
    public final int mHoverSlop;
    public TooltipPopup mPopup;
    public final CharSequence mTooltipText;
    public final AnonymousClass1 mShowRunnable = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler.1
        @Override // java.lang.Runnable
        public final void run() {
            TooltipCompatHandler.this.show(false);
        }
    };
    public final AnonymousClass2 mHideRunnable = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler.2
        @Override // java.lang.Runnable
        public final void run() {
            TooltipCompatHandler.this.hide();
        }
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.TooltipCompatHandler$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.TooltipCompatHandler$2] */
    public TooltipCompatHandler(View view, CharSequence charSequence) {
        int scaledTouchSlop;
        this.mAnchor = view;
        this.mTooltipText = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledTouchSlop = ViewConfigurationCompat.Api28Impl.getScaledHoverSlop(viewConfiguration);
        } else {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.mHoverSlop = scaledTouchSlop;
        this.mAnchorX = Integer.MAX_VALUE;
        this.mAnchorY = Integer.MAX_VALUE;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = sPendingHandler;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.mAnchor.removeCallbacks(tooltipCompatHandler2.mShowRunnable);
        }
        sPendingHandler = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.mAnchor.postDelayed(tooltipCompatHandler.mShowRunnable, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void hide() {
        boolean z;
        TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
        View view = this.mAnchor;
        if (tooltipCompatHandler == this) {
            sActiveHandler = null;
            TooltipPopup tooltipPopup = this.mPopup;
            if (tooltipPopup != null) {
                View view2 = tooltipPopup.mContentView;
                if (view2.getParent() != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    ((WindowManager) tooltipPopup.mContext.getSystemService("window")).removeView(view2);
                }
                this.mPopup = null;
                this.mAnchorX = Integer.MAX_VALUE;
                this.mAnchorY = Integer.MAX_VALUE;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (sPendingHandler == this) {
            setPendingHandler(null);
        }
        view.removeCallbacks(this.mHideRunnable);
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.mPopup != null && this.mFromTouch) {
            return false;
        }
        View view2 = this.mAnchor;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                this.mAnchorX = Integer.MAX_VALUE;
                this.mAnchorY = Integer.MAX_VALUE;
                hide();
            }
        } else if (view2.isEnabled() && this.mPopup == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int abs = Math.abs(x - this.mAnchorX);
            int r2 = this.mHoverSlop;
            if (abs <= r2 && Math.abs(y - this.mAnchorY) <= r2) {
                z = false;
            } else {
                this.mAnchorX = x;
                this.mAnchorY = y;
                z = true;
            }
            if (z) {
                setPendingHandler(this);
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.mAnchorX = view.getWidth() / 2;
        this.mAnchorY = view.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        hide();
    }

    public final void show(boolean z) {
        boolean z2;
        int height;
        int r4;
        int r15;
        String str;
        int r14;
        String str2;
        int r0;
        long longPressTimeout;
        long j;
        long j2;
        boolean z3;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        View view = this.mAnchor;
        if (!ViewCompat.Api19Impl.isAttachedToWindow(view)) {
            return;
        }
        setPendingHandler(null);
        TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.hide();
        }
        sActiveHandler = this;
        this.mFromTouch = z;
        TooltipPopup tooltipPopup = new TooltipPopup(view.getContext());
        this.mPopup = tooltipPopup;
        int r3 = this.mAnchorX;
        int r42 = this.mAnchorY;
        boolean z4 = this.mFromTouch;
        View view2 = tooltipPopup.mContentView;
        if (view2.getParent() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Context context = tooltipPopup.mContext;
        if (z2) {
            if (view2.getParent() != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
        }
        tooltipPopup.mMessageView.setText(this.mTooltipText);
        WindowManager.LayoutParams layoutParams = tooltipPopup.mLayoutParams;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            r3 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = r42 + dimensionPixelOffset2;
            r4 = r42 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            r4 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = context.getResources();
        if (z4) {
            r15 = R.dimen.tooltip_y_offset_touch;
        } else {
            r15 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(r15);
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
        if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
            Context context2 = view.getContext();
            while (true) {
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
                if (context2 instanceof Activity) {
                    rootView = ((Activity) context2).getWindow().getDecorView();
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
        }
        if (rootView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            str2 = "window";
        } else {
            Rect rect = tooltipPopup.mTmpDisplayFrame;
            rootView.getWindowVisibleDisplayFrame(rect);
            if (rect.left >= 0 || rect.top >= 0) {
                str = "window";
                r14 = 0;
            } else {
                Resources resources2 = context.getResources();
                str = "window";
                int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    r0 = resources2.getDimensionPixelSize(identifier);
                } else {
                    r0 = 0;
                }
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                r14 = 0;
                rect.set(0, r0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            int[] r02 = tooltipPopup.mTmpAppPos;
            rootView.getLocationOnScreen(r02);
            int[] r2 = tooltipPopup.mTmpAnchorPos;
            view.getLocationOnScreen(r2);
            int r9 = r2[r14] - r02[r14];
            r2[r14] = r9;
            r2[1] = r2[1] - r02[1];
            layoutParams.x = (r9 + r3) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(r14, r14);
            view2.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = view2.getMeasuredHeight();
            int r22 = r2[1];
            int r43 = ((r4 + r22) - dimensionPixelOffset3) - measuredHeight;
            int r23 = r22 + height + dimensionPixelOffset3;
            if (z4) {
                if (r43 >= 0) {
                    layoutParams.y = r43;
                } else {
                    layoutParams.y = r23;
                }
            } else if (measuredHeight + r23 <= rect.height()) {
                layoutParams.y = r23;
            } else {
                layoutParams.y = r43;
            }
            str2 = str;
        }
        ((WindowManager) context.getSystemService(str2)).addView(view2, layoutParams);
        view.addOnAttachStateChangeListener(this);
        if (this.mFromTouch) {
            j2 = 2500;
        } else {
            if ((ViewCompat.Api16Impl.getWindowSystemUiVisibility(view) & 1) == 1) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j = 15000;
            }
            j2 = j - longPressTimeout;
        }
        AnonymousClass2 anonymousClass2 = this.mHideRunnable;
        view.removeCallbacks(anonymousClass2);
        view.postDelayed(anonymousClass2, j2);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
