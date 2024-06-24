package com.google.android.material.snackbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int r0 = message.what;
            if (r0 != 0) {
                if (r0 != 1) {
                    return false;
                }
                ((BaseTransientBottomBar) message.obj).getClass();
                throw null;
            }
            ((BaseTransientBottomBar) message.obj).getClass();
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        public final BehaviorDelegate delegate = new BehaviorDelegate(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public final boolean canSwipeDismissView(View view) {
            this.delegate.getClass();
            return view instanceof SnackbarBaseLayout;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.delegate.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    synchronized (SnackbarManager.getInstance().lock) {
                    }
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                synchronized (SnackbarManager.getInstance().lock) {
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public static class BehaviorDelegate {
        public BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.getClass();
            swipeDismissBehavior.alphaStartSwipeDistance = Math.min(Math.max(0.0f, 0.1f), 1.0f);
            swipeDismissBehavior.alphaEndSwipeDistance = Math.min(Math.max(0.0f, 0.6f), 1.0f);
            swipeDismissBehavior.swipeDirection = 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class SnackbarBaseLayout extends FrameLayout {
        public static final AnonymousClass1 consumeAllTouchListener = new AnonymousClass1();
        public final float actionTextColorAlpha;
        public int animationMode;
        public final float backgroundOverlayColorAlpha;
        public ColorStateList backgroundTint;
        public PorterDuff.Mode backgroundTintMode;
        public BaseTransientBottomBar<?> baseTransientBottomBar;
        public final int maxInlineActionWidth;
        public final int maxWidth;

        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(6)) {
                float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api21Impl.setElevation(this, dimensionPixelSize);
            }
            this.animationMode = obtainStyledAttributes.getInt(2, 0);
            this.backgroundOverlayColorAlpha = obtainStyledAttributes.getFloat(3, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, obtainStyledAttributes, 4));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = obtainStyledAttributes.getFloat(1, 1.0f);
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.maxInlineActionWidth = obtainStyledAttributes.getDimensionPixelSize(7, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(MaterialColors.layer(MaterialColors.getColor(R.attr.colorSurface, this), getBackgroundOverlayColorAlpha(), MaterialColors.getColor(R.attr.colorOnSurface, this)));
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    DrawableCompat$Api21Impl.setTintList(gradientDrawable, colorStateList);
                }
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api16Impl.setBackground(this, gradientDrawable);
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.baseTransientBottomBar = baseTransientBottomBar;
        }

        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        public int getAnimationMode() {
            return this.animationMode;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        public int getMaxInlineActionWidth() {
            return this.maxInlineActionWidth;
        }

        public int getMaxWidth() {
            return this.maxWidth;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.baseTransientBottomBar;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.getClass();
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.baseTransientBottomBar != null) {
                synchronized (SnackbarManager.getInstance().lock) {
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
            super.onLayout(z, r2, r3, r4, r5);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            int r22 = this.maxWidth;
            if (r22 > 0 && getMeasuredWidth() > r22) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(r22, 1073741824), r3);
            }
        }

        public void setAnimationMode(int r1) {
            this.animationMode = r1;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.backgroundTint != null) {
                drawable = drawable.mutate();
                DrawableCompat$Api21Impl.setTintList(drawable, this.backgroundTint);
                DrawableCompat$Api21Impl.setTintMode(drawable, this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                Drawable mutate = getBackground().mutate();
                DrawableCompat$Api21Impl.setTintList(mutate, colorStateList);
                DrawableCompat$Api21Impl.setTintMode(mutate, this.backgroundTintMode);
                if (mutate != getBackground()) {
                    super.setBackgroundDrawable(mutate);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                Drawable mutate = getBackground().mutate();
                DrawableCompat$Api21Impl.setTintMode(mutate, mode);
                if (mutate != getBackground()) {
                    super.setBackgroundDrawable(mutate);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                if (this.baseTransientBottomBar != null) {
                    int r5 = BaseTransientBottomBar.$r8$clinit;
                    throw null;
                }
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            AnonymousClass1 anonymousClass1;
            if (onClickListener != null) {
                anonymousClass1 = null;
            } else {
                anonymousClass1 = consumeAllTouchListener;
            }
            setOnTouchListener(anonymousClass1);
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public static void dispatchDismiss(int r1) {
        synchronized (SnackbarManager.getInstance().lock) {
        }
    }
}
