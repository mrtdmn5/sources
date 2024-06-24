package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.kronaby.watch.app.R;

/* loaded from: classes.dex */
public abstract class AbsActionBarView extends ViewGroup {
    public ActionMenuPresenter mActionMenuPresenter;
    public int mContentHeight;
    public boolean mEatingHover;
    public boolean mEatingTouch;
    public ActionMenuView mMenuView;
    public final Context mPopupContext;
    public final VisibilityAnimListener mVisAnimListener;
    public ViewPropertyAnimatorCompat mVisibilityAnim;

    /* loaded from: classes.dex */
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        public boolean mCanceled = false;
        public int mFinalVisibility;

        public VisibilityAnimListener() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationCancel(View view) {
            this.mCanceled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            if (this.mCanceled) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.mVisibilityAnim = null;
            AbsActionBarView.super.setVisibility(this.mFinalVisibility);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationStart() {
            AbsActionBarView.super.setVisibility(0);
            this.mCanceled = false;
        }
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int measureChildView(View view, int r2, int r3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE), r3);
        return Math.max(0, (r2 - view.getMeasuredWidth()) - 0);
    }

    public static int positionChild(View view, boolean z, int r4, int r5, int r6) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int r62 = ((r6 - measuredHeight) / 2) + r5;
        if (z) {
            view.layout(r4 - measuredWidth, r62, r4, measuredHeight + r62);
        } else {
            view.layout(r4, r62, r4 + measuredWidth, measuredHeight + r62);
        }
        if (z) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim != null) {
            return this.mVisAnimListener.mFinalVisibility;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        int r0;
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            Configuration configuration2 = actionMenuPresenter.mContext.getResources().getConfiguration();
            int r1 = configuration2.screenWidthDp;
            int r2 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp <= 600 && r1 <= 600 && ((r1 <= 960 || r2 <= 720) && (r1 <= 720 || r2 <= 960))) {
                if (r1 < 500 && ((r1 <= 640 || r2 <= 480) && (r1 <= 480 || r2 <= 640))) {
                    if (r1 >= 360) {
                        r0 = 3;
                    } else {
                        r0 = 2;
                    }
                } else {
                    r0 = 4;
                }
            } else {
                r0 = 5;
            }
            actionMenuPresenter.mMaxItems = r0;
            MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
            if (menuBuilder != null) {
                menuBuilder.onItemsChanged(true);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        if (r2 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            super.setVisibility(r2);
        }
    }

    public final ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r4, long j) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        VisibilityAnimListener visibilityAnimListener = this.mVisAnimListener;
        if (r4 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(this);
            animate.alpha(1.0f);
            animate.setDuration(j);
            AbsActionBarView.this.mVisibilityAnim = animate;
            visibilityAnimListener.mFinalVisibility = r4;
            animate.setListener(visibilityAnimListener);
            return animate;
        }
        ViewPropertyAnimatorCompat animate2 = ViewCompat.animate(this);
        animate2.alpha(0.0f);
        animate2.setDuration(j);
        AbsActionBarView.this.mVisibilityAnim = animate2;
        visibilityAnimListener.mFinalVisibility = r4;
        animate2.setListener(visibilityAnimListener);
        return animate2;
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet, int r5) {
        super(context, attributeSet, r5);
        this.mVisAnimListener = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.mPopupContext = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.mPopupContext = context;
        }
    }
}
