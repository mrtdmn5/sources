package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public int mAnimationState;
    public final AnonymousClass1 mHideRunnable;
    public float mHorizontalDragX;
    public int mHorizontalThumbCenterX;
    public final StateListDrawable mHorizontalThumbDrawable;
    public final int mHorizontalThumbHeight;
    public int mHorizontalThumbWidth;
    public final Drawable mHorizontalTrackDrawable;
    public final int mHorizontalTrackHeight;
    public final int mMargin;
    public RecyclerView mRecyclerView;
    public final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator;
    public float mVerticalDragY;
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    public int mVerticalThumbHeight;
    public final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    public final int mVerticalTrackWidth;
    public static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public int mRecyclerViewWidth = 0;
    public int mRecyclerViewHeight = 0;
    public boolean mNeedVerticalScrollbar = false;
    public boolean mNeedHorizontalScrollbar = false;
    public int mState = 0;
    public int mDragState = 0;
    public final int[] mVerticalRange = new int[2];
    public final int[] mHorizontalRange = new int[2];

    /* loaded from: classes.dex */
    public class AnimatorListener extends AnimatorListenerAdapter {
        public boolean mCanceled = false;

        public AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
                return;
            }
            FastScroller fastScroller = FastScroller.this;
            if (((Float) fastScroller.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                fastScroller.mAnimationState = 2;
                fastScroller.mRecyclerView.invalidate();
            }
        }
    }

    /* loaded from: classes.dex */
    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        public AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller fastScroller = FastScroller.this;
            fastScroller.mVerticalThumbDrawable.setAlpha(floatValue);
            fastScroller.mVerticalTrackDrawable.setAlpha(floatValue);
            fastScroller.mRecyclerView.invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Runnable, androidx.recyclerview.widget.FastScroller$1] */
    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int r10, int r11, int r12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mShowHideAnimator = ofFloat;
        this.mAnimationState = 0;
        ?? r0 = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            @Override // java.lang.Runnable
            public final void run() {
                FastScroller fastScroller = FastScroller.this;
                int r1 = fastScroller.mAnimationState;
                ValueAnimator valueAnimator = fastScroller.mShowHideAnimator;
                if (r1 != 1) {
                    if (r1 != 2) {
                        return;
                    }
                } else {
                    valueAnimator.cancel();
                }
                fastScroller.mAnimationState = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
            }
        };
        this.mHideRunnable = r0;
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView2, int r102, int r112) {
                boolean z;
                boolean z2;
                int computeHorizontalScrollOffset = recyclerView2.computeHorizontalScrollOffset();
                int computeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                FastScroller fastScroller = FastScroller.this;
                int computeVerticalScrollRange = fastScroller.mRecyclerView.computeVerticalScrollRange();
                int r1 = fastScroller.mRecyclerViewHeight;
                int r2 = computeVerticalScrollRange - r1;
                int r3 = fastScroller.mScrollbarMinimumRange;
                if (r2 > 0 && r1 >= r3) {
                    z = true;
                } else {
                    z = false;
                }
                fastScroller.mNeedVerticalScrollbar = z;
                int computeHorizontalScrollRange = fastScroller.mRecyclerView.computeHorizontalScrollRange();
                int r6 = fastScroller.mRecyclerViewWidth;
                if (computeHorizontalScrollRange - r6 > 0 && r6 >= r3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fastScroller.mNeedHorizontalScrollbar = z2;
                boolean z3 = fastScroller.mNeedVerticalScrollbar;
                if (!z3 && !z2) {
                    if (fastScroller.mState != 0) {
                        fastScroller.setState(0);
                        return;
                    }
                    return;
                }
                if (z3) {
                    float f = r1;
                    fastScroller.mVerticalThumbCenterY = (int) ((((f / 2.0f) + computeVerticalScrollOffset) * f) / computeVerticalScrollRange);
                    fastScroller.mVerticalThumbHeight = Math.min(r1, (r1 * r1) / computeVerticalScrollRange);
                }
                if (fastScroller.mNeedHorizontalScrollbar) {
                    float f2 = computeHorizontalScrollOffset;
                    float f3 = r6;
                    fastScroller.mHorizontalThumbCenterX = (int) ((((f3 / 2.0f) + f2) * f3) / computeHorizontalScrollRange);
                    fastScroller.mHorizontalThumbWidth = Math.min(r6, (r6 * r6) / computeHorizontalScrollRange);
                }
                int r9 = fastScroller.mState;
                if (r9 == 0 || r9 == 1) {
                    fastScroller.setState(1);
                }
            }
        };
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(r10, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(r10, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(r10, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(r10, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = r11;
        this.mMargin = r12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.mRecyclerView.removeOnItemTouchListener(this);
                this.mRecyclerView.removeOnScrollListener(onScrollListener);
                this.mRecyclerView.removeCallbacks(r0);
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(this);
                this.mRecyclerView.addOnItemTouchListener(this);
                this.mRecyclerView.addOnScrollListener(onScrollListener);
            }
        }
    }

    public final boolean isPointInsideHorizontalThumb(float f, float f2) {
        if (f2 >= this.mRecyclerViewHeight - this.mHorizontalThumbHeight) {
            int r4 = this.mHorizontalThumbCenterX;
            int r0 = this.mHorizontalThumbWidth;
            if (f >= r4 - (r0 / 2) && f <= (r0 / 2) + r4) {
                return true;
            }
        }
        return false;
    }

    public final boolean isPointInsideVerticalThumb(float f, float f2) {
        boolean z;
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api17Impl.getLayoutDirection(recyclerView) == 1) {
            z = true;
        } else {
            z = false;
        }
        int r3 = this.mVerticalThumbWidth;
        if (z) {
            if (f > r3) {
                return false;
            }
        } else if (f < this.mRecyclerViewWidth - r3) {
            return false;
        }
        int r5 = this.mVerticalThumbCenterY;
        int r0 = this.mVerticalThumbHeight / 2;
        if (f2 < r5 - r0 || f2 > r0 + r5) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        if (this.mRecyclerViewWidth == this.mRecyclerView.getWidth() && this.mRecyclerViewHeight == this.mRecyclerView.getHeight()) {
            if (this.mAnimationState != 0) {
                if (this.mNeedVerticalScrollbar) {
                    int r10 = this.mRecyclerViewWidth;
                    int r2 = this.mVerticalThumbWidth;
                    int r102 = r10 - r2;
                    int r3 = this.mVerticalThumbCenterY;
                    int r4 = this.mVerticalThumbHeight;
                    int r32 = r3 - (r4 / 2);
                    StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
                    stateListDrawable.setBounds(0, 0, r2, r4);
                    int r42 = this.mRecyclerViewHeight;
                    int r6 = this.mVerticalTrackWidth;
                    Drawable drawable = this.mVerticalTrackDrawable;
                    drawable.setBounds(0, 0, r6, r42);
                    RecyclerView recyclerView2 = this.mRecyclerView;
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    boolean z = true;
                    if (ViewCompat.Api17Impl.getLayoutDirection(recyclerView2) != 1) {
                        z = false;
                    }
                    if (z) {
                        drawable.draw(canvas);
                        canvas.translate(r2, r32);
                        canvas.scale(-1.0f, 1.0f);
                        stateListDrawable.draw(canvas);
                        canvas.scale(-1.0f, 1.0f);
                        canvas.translate(-r2, -r32);
                    } else {
                        canvas.translate(r102, 0.0f);
                        drawable.draw(canvas);
                        canvas.translate(0.0f, r32);
                        stateListDrawable.draw(canvas);
                        canvas.translate(-r102, -r32);
                    }
                }
                if (this.mNeedHorizontalScrollbar) {
                    int r103 = this.mRecyclerViewHeight;
                    int r22 = this.mHorizontalThumbHeight;
                    int r104 = r103 - r22;
                    int r33 = this.mHorizontalThumbCenterX;
                    int r43 = this.mHorizontalThumbWidth;
                    int r34 = r33 - (r43 / 2);
                    StateListDrawable stateListDrawable2 = this.mHorizontalThumbDrawable;
                    stateListDrawable2.setBounds(0, 0, r43, r22);
                    int r23 = this.mRecyclerViewWidth;
                    int r44 = this.mHorizontalTrackHeight;
                    Drawable drawable2 = this.mHorizontalTrackDrawable;
                    drawable2.setBounds(0, 0, r23, r44);
                    canvas.translate(0.0f, r104);
                    drawable2.draw(canvas);
                    canvas.translate(r34, 0.0f);
                    stateListDrawable2.draw(canvas);
                    canvas.translate(-r34, -r104);
                    return;
                }
                return;
            }
            return;
        }
        this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
        setState(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int r0 = this.mState;
        if (r0 == 1) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (isPointInsideVerticalThumb || isPointInsideHorizontalThumb)) {
                if (isPointInsideHorizontalThumb) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = (int) motionEvent.getX();
                } else if (isPointInsideVerticalThumb) {
                    this.mDragState = 2;
                    this.mVerticalDragY = (int) motionEvent.getY();
                }
                setState(2);
                return true;
            }
        } else if (r0 == 2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bb, code lost:            if (r9 >= 0) goto L35;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0112, code lost:            if (r5 >= 0) goto L49;     */
    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.FastScroller.onTouchEvent(android.view.MotionEvent):void");
    }

    public final void setState(int r5) {
        AnonymousClass1 anonymousClass1 = this.mHideRunnable;
        StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
        if (r5 == 2 && this.mState != 2) {
            stateListDrawable.setState(PRESSED_STATE_SET);
            this.mRecyclerView.removeCallbacks(anonymousClass1);
        }
        if (r5 == 0) {
            this.mRecyclerView.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && r5 != 2) {
            stateListDrawable.setState(EMPTY_STATE_SET);
            this.mRecyclerView.removeCallbacks(anonymousClass1);
            this.mRecyclerView.postDelayed(anonymousClass1, 1200);
        } else if (r5 == 1) {
            this.mRecyclerView.removeCallbacks(anonymousClass1);
            this.mRecyclerView.postDelayed(anonymousClass1, 1500);
        }
        this.mState = r5;
    }

    public final void show() {
        int r0 = this.mAnimationState;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        if (r0 != 0) {
            if (r0 == 3) {
                valueAnimator.cancel();
            } else {
                return;
            }
        }
        this.mAnimationState = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }
}
