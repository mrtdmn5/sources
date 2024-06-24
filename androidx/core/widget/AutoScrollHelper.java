package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    public int mActivationDelay;
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public final AccelerateInterpolator mEdgeInterpolator;
    public int mEdgeType;
    public boolean mEnabled;
    public final float[] mMaximumEdges;
    public final float[] mMaximumVelocity;
    public final float[] mMinimumVelocity;
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public final float[] mRelativeEdges;
    public final float[] mRelativeVelocity;
    public ScrollAnimationRunnable mRunnable;
    public final ClampedScroller mScroller;
    public final View mTarget;

    /* loaded from: classes.dex */
    public static class ClampedScroller {
        public int mEffectiveRampDown;
        public int mRampDownDuration;
        public int mRampUpDuration;
        public float mStopValue;
        public float mTargetVelocityX;
        public float mTargetVelocityY;
        public long mStartTime = Long.MIN_VALUE;
        public long mStopTime = -1;
        public long mDeltaTime = 0;

        public final float getValueAt(long j) {
            long j2 = this.mStartTime;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.mStopTime;
            if (j3 >= 0 && j >= j3) {
                float f = this.mStopValue;
                return (AutoScrollHelper.constrain(((float) (j - j3)) / this.mEffectiveRampDown, 0.0f, 1.0f) * f) + (1.0f - f);
            }
            return AutoScrollHelper.constrain(((float) (j - j2)) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }
    }

    /* loaded from: classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        public ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (!autoScrollHelper.mAnimating) {
                return;
            }
            boolean z2 = autoScrollHelper.mNeedsReset;
            ClampedScroller clampedScroller = autoScrollHelper.mScroller;
            if (z2) {
                autoScrollHelper.mNeedsReset = false;
                clampedScroller.getClass();
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                clampedScroller.mStartTime = currentAnimationTimeMillis;
                clampedScroller.mStopTime = -1L;
                clampedScroller.mDeltaTime = currentAnimationTimeMillis;
                clampedScroller.mStopValue = 0.5f;
            }
            if (clampedScroller.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > clampedScroller.mStopTime + clampedScroller.mEffectiveRampDown) {
                z = true;
            } else {
                z = false;
            }
            if (!z && autoScrollHelper.shouldAnimate()) {
                boolean z3 = autoScrollHelper.mNeedsCancel;
                View view = autoScrollHelper.mTarget;
                if (z3) {
                    autoScrollHelper.mNeedsCancel = false;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (clampedScroller.mDeltaTime != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float valueAt = clampedScroller.getValueAt(currentAnimationTimeMillis2);
                    long j = currentAnimationTimeMillis2 - clampedScroller.mDeltaTime;
                    clampedScroller.mDeltaTime = currentAnimationTimeMillis2;
                    ListViewCompat$Api19Impl.scrollListBy(((ListViewAutoScrollHelper) autoScrollHelper).mTarget, (int) (((float) j) * ((valueAt * 4.0f) + ((-4.0f) * valueAt * valueAt)) * clampedScroller.mTargetVelocityY));
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.postOnAnimation(view, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            autoScrollHelper.mAnimating = false;
        }
    }

    public AutoScrollHelper(View view) {
        ClampedScroller clampedScroller = new ClampedScroller();
        this.mScroller = clampedScroller;
        this.mEdgeInterpolator = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.mRelativeEdges = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumEdges = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.mRelativeVelocity = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.mMinimumVelocity = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumVelocity = fArr5;
        this.mTarget = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.mEdgeType = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.mActivationDelay = DEFAULT_ACTIVATION_DELAY;
        clampedScroller.mRampUpDuration = 500;
        clampedScroller.mRampDownDuration = 500;
    }

    public static float constrain(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float computeTargetVelocity(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.mRelativeEdges
            r0 = r0[r7]
            float[] r1 = r3.mMaximumEdges
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = constrain(r0, r2, r1)
            float r1 = r3.constrainEdgeValue(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.constrainEdgeValue(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.mEdgeInterpolator
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = constrain(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.mRelativeVelocity
            r0 = r0[r7]
            float[] r1 = r3.mMinimumVelocity
            r1 = r1[r7]
            float[] r2 = r3.mMaximumVelocity
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r4 = constrain(r4, r1, r7)
            return r4
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = constrain(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.computeTargetVelocity(float, float, float, int):float");
    }

    public final float constrainEdgeValue(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int r1 = this.mEdgeType;
        if (r1 != 0 && r1 != 1) {
            if (r1 == 2 && f < 0.0f) {
                return f / (-f2);
            }
        } else if (f < f2) {
            if (f >= 0.0f) {
                return 1.0f - (f / f2);
            }
            if (this.mAnimating && r1 == 1) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:            if (r0 != 3) goto L29;     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.mEnabled
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r8 = 3
            if (r0 == r8) goto L16
            goto L7b
        L16:
            r7.requestStop()
            goto L7b
        L1a:
            r7.mNeedsCancel = r2
            r7.mAlreadyDelayed = r1
        L1e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.mTarget
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.computeTargetVelocity(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.computeTargetVelocity(r9, r8, r3, r2)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r9 = r7.mScroller
            r9.mTargetVelocityX = r0
            r9.mTargetVelocityY = r8
            boolean r8 = r7.mAnimating
            if (r8 != 0) goto L7b
            boolean r8 = r7.shouldAnimate()
            if (r8 == 0) goto L7b
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r8 = r7.mRunnable
            if (r8 != 0) goto L5f
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r8 = new androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable
            r8.<init>()
            r7.mRunnable = r8
        L5f:
            r7.mAnimating = r2
            r7.mNeedsReset = r2
            boolean r8 = r7.mAlreadyDelayed
            if (r8 != 0) goto L74
            int r8 = r7.mActivationDelay
            if (r8 <= 0) goto L74
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r9 = r7.mRunnable
            long r5 = (long) r8
            java.util.WeakHashMap<android.view.View, androidx.core.view.ViewPropertyAnimatorCompat> r8 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            androidx.core.view.ViewCompat.Api16Impl.postOnAnimationDelayed(r4, r9, r5)
            goto L79
        L74:
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r8 = r7.mRunnable
            r8.run()
        L79:
            r7.mAlreadyDelayed = r2
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void requestStop() {
        int r1 = 0;
        if (this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }
        ClampedScroller clampedScroller = this.mScroller;
        clampedScroller.getClass();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int r4 = (int) (currentAnimationTimeMillis - clampedScroller.mStartTime);
        int r5 = clampedScroller.mRampDownDuration;
        if (r4 > r5) {
            r1 = r5;
        } else if (r4 >= 0) {
            r1 = r4;
        }
        clampedScroller.mEffectiveRampDown = r1;
        clampedScroller.mStopValue = clampedScroller.getValueAt(currentAnimationTimeMillis);
        clampedScroller.mStopTime = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean shouldAnimate() {
        /*
            r9 = this;
            androidx.core.widget.AutoScrollHelper$ClampedScroller r0 = r9.mScroller
            float r1 = r0.mTargetVelocityY
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.mTargetVelocityX
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 0
            if (r1 == 0) goto L55
            r3 = r9
            androidx.core.widget.ListViewAutoScrollHelper r3 = (androidx.core.widget.ListViewAutoScrollHelper) r3
            android.widget.ListView r3 = r3.mTarget
            int r4 = r3.getCount()
            r5 = 1
            if (r4 != 0) goto L23
        L21:
            r1 = r2
            goto L51
        L23:
            int r6 = r3.getChildCount()
            int r7 = r3.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L41
            if (r8 < r4) goto L50
            int r6 = r6 - r5
            android.view.View r1 = r3.getChildAt(r6)
            int r1 = r1.getBottom()
            int r3 = r3.getHeight()
            if (r1 > r3) goto L50
            goto L21
        L41:
            if (r1 >= 0) goto L21
            if (r7 > 0) goto L50
            android.view.View r1 = r3.getChildAt(r2)
            int r1 = r1.getTop()
            if (r1 < 0) goto L50
            goto L21
        L50:
            r1 = r5
        L51:
            if (r1 != 0) goto L54
            goto L55
        L54:
            r2 = r5
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.shouldAnimate():boolean");
    }
}
