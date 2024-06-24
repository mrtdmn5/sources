package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ViewDragHelper {
    public static final AnonymousClass1 sInterpolator = new AnonymousClass1();
    public final Callback mCallback;
    public View mCapturedView;
    public int mDragState;
    public int[] mEdgeDragsInProgress;
    public int[] mEdgeDragsLocked;
    public final int mEdgeSize;
    public int[] mInitialEdgesTouched;
    public float[] mInitialMotionX;
    public float[] mInitialMotionY;
    public float[] mLastMotionX;
    public float[] mLastMotionY;
    public final float mMaxVelocity;
    public final float mMinVelocity;
    public final ViewGroup mParentView;
    public int mPointersDown;
    public boolean mReleaseInProgress;
    public final OverScroller mScroller;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public int mActivePointerId = -1;
    public final AnonymousClass2 mSetIdleRunnable = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    /* renamed from: androidx.customview.widget.ViewDragHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.customview.widget.ViewDragHelper$2] */
    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup != null) {
            if (callback != null) {
                this.mParentView = viewGroup;
                this.mCallback = callback;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.mEdgeSize = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mScroller = new OverScroller(context, sInterpolator);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public final void cancel() {
        this.mActivePointerId = -1;
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public final void captureChildView(int r3, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.mParentView;
        if (parent == viewGroup) {
            this.mCapturedView = view;
            this.mActivePointerId = r3;
            this.mCallback.onViewCaptured(r3, view);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
    }

    public final boolean checkNewEdgeDrag(float f, float f2, int r6, int r7) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.mInitialEdgesTouched[r6] & r7) != r7 || (0 & r7) == 0 || (this.mEdgeDragsLocked[r6] & r7) == r7 || (this.mEdgeDragsInProgress[r6] & r7) == r7) {
            return false;
        }
        int r0 = this.mTouchSlop;
        if (abs <= r0 && abs2 <= r0) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            this.mCallback.getClass();
        }
        if ((this.mEdgeDragsInProgress[r6] & r7) != 0 || abs <= this.mTouchSlop) {
            return false;
        }
        return true;
    }

    public final boolean checkTouchSlop(View view, float f, float f2) {
        boolean z;
        boolean z2;
        if (view == null) {
            return false;
        }
        Callback callback = this.mCallback;
        if (callback.getViewHorizontalDragRange(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (callback.getViewVerticalDragRange() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            float f3 = (f2 * f2) + (f * f);
            int r4 = this.mTouchSlop;
            if (f3 <= r4 * r4) {
                return false;
            }
            return true;
        }
        if (z) {
            if (Math.abs(f) <= this.mTouchSlop) {
                return false;
            }
            return true;
        }
        if (!z2 || Math.abs(f2) <= this.mTouchSlop) {
            return false;
        }
        return true;
    }

    public final void clearMotionHistory(int r7) {
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            int r1 = this.mPointersDown;
            boolean z = true;
            int r3 = 1 << r7;
            if ((r3 & r1) == 0) {
                z = false;
            }
            if (z) {
                fArr[r7] = 0.0f;
                this.mInitialMotionY[r7] = 0.0f;
                this.mLastMotionX[r7] = 0.0f;
                this.mLastMotionY[r7] = 0.0f;
                this.mInitialEdgesTouched[r7] = 0;
                this.mEdgeDragsInProgress[r7] = 0;
                this.mEdgeDragsLocked[r7] = 0;
                this.mPointersDown = (~r3) & r1;
            }
        }
    }

    public final int computeAxisDuration(int r5, int r6, int r7) {
        int abs;
        if (r5 == 0) {
            return 0;
        }
        float width = this.mParentView.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(r5) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int abs2 = Math.abs(r6);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(sin / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(r5) / r7) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    public final boolean continueSettling() {
        if (this.mDragState == 2) {
            OverScroller overScroller = this.mScroller;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                View view = this.mCapturedView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.mCapturedView;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.mParentView.post(this.mSetIdleRunnable);
            }
        }
        if (this.mDragState != 2) {
            return false;
        }
        return true;
    }

    public final View findTopChildUnder(int r5, int r6) {
        ViewGroup viewGroup = this.mParentView;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.mCallback.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (r5 >= childAt.getLeft() && r5 < childAt.getRight() && r6 >= childAt.getTop() && r6 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean forceSettleCapturedViewAt(int r11, int r12, int r13, int r14) {
        /*
            r10 = this;
            android.view.View r0 = r10.mCapturedView
            int r2 = r0.getLeft()
            android.view.View r0 = r10.mCapturedView
            int r3 = r0.getTop()
            int r4 = r11 - r2
            int r5 = r12 - r3
            android.widget.OverScroller r1 = r10.mScroller
            r11 = 0
            if (r4 != 0) goto L1e
            if (r5 != 0) goto L1e
            r1.abortAnimation()
            r10.setDragState(r11)
            return r11
        L1e:
            android.view.View r12 = r10.mCapturedView
            float r0 = r10.mMinVelocity
            int r0 = (int) r0
            float r6 = r10.mMaxVelocity
            int r6 = (int) r6
            int r7 = java.lang.Math.abs(r13)
            if (r7 >= r0) goto L2e
            r13 = r11
            goto L35
        L2e:
            if (r7 <= r6) goto L35
            if (r13 <= 0) goto L34
            r13 = r6
            goto L35
        L34:
            int r13 = -r6
        L35:
            int r7 = java.lang.Math.abs(r14)
            if (r7 >= r0) goto L3c
            goto L43
        L3c:
            if (r7 <= r6) goto L44
            if (r14 <= 0) goto L42
            r14 = r6
            goto L44
        L42:
            int r11 = -r6
        L43:
            r14 = r11
        L44:
            int r11 = java.lang.Math.abs(r4)
            int r0 = java.lang.Math.abs(r5)
            int r6 = java.lang.Math.abs(r13)
            int r7 = java.lang.Math.abs(r14)
            int r8 = r6 + r7
            int r9 = r11 + r0
            if (r13 == 0) goto L5d
            float r11 = (float) r6
            float r6 = (float) r8
            goto L5f
        L5d:
            float r11 = (float) r11
            float r6 = (float) r9
        L5f:
            float r11 = r11 / r6
            if (r14 == 0) goto L65
            float r0 = (float) r7
            float r6 = (float) r8
            goto L67
        L65:
            float r0 = (float) r0
            float r6 = (float) r9
        L67:
            float r0 = r0 / r6
            androidx.customview.widget.ViewDragHelper$Callback r6 = r10.mCallback
            int r12 = r6.getViewHorizontalDragRange(r12)
            int r12 = r10.computeAxisDuration(r4, r13, r12)
            int r13 = r6.getViewVerticalDragRange()
            int r13 = r10.computeAxisDuration(r5, r14, r13)
            float r12 = (float) r12
            float r12 = r12 * r11
            float r11 = (float) r13
            float r11 = r11 * r0
            float r11 = r11 + r12
            int r6 = (int) r11
            r1.startScroll(r2, r3, r4, r5, r6)
            r11 = 2
            r10.setDragState(r11)
            r11 = 1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.forceSettleCapturedViewAt(int, int, int, int):boolean");
    }

    public final boolean isValidPointerForActionMove(int r4) {
        boolean z;
        if ((this.mPointersDown & (1 << r4)) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + r4 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void processTouchEvent(MotionEvent motionEvent) {
        int r10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int r2 = 0;
        Callback callback = this.mCallback;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (this.mDragState == 1 && pointerId == this.mActivePointerId) {
                                    int pointerCount = motionEvent.getPointerCount();
                                    while (true) {
                                        if (r2 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(r2);
                                            if (pointerId2 != this.mActivePointerId) {
                                                View findTopChildUnder = findTopChildUnder((int) motionEvent.getX(r2), (int) motionEvent.getY(r2));
                                                View view = this.mCapturedView;
                                                if (findTopChildUnder == view && tryCaptureViewForDrag(pointerId2, view)) {
                                                    r10 = this.mActivePointerId;
                                                    break;
                                                }
                                            }
                                            r2++;
                                        } else {
                                            r10 = -1;
                                            break;
                                        }
                                    }
                                    if (r10 == -1) {
                                        releaseViewForPointerUp();
                                    }
                                }
                                clearMotionHistory(pointerId);
                                return;
                            }
                            return;
                        }
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        float x = motionEvent.getX(actionIndex);
                        float y = motionEvent.getY(actionIndex);
                        saveInitialMotion(x, y, pointerId3);
                        if (this.mDragState == 0) {
                            tryCaptureViewForDrag(pointerId3, findTopChildUnder((int) x, (int) y));
                            if ((this.mInitialEdgesTouched[pointerId3] & 0) != 0) {
                                callback.getClass();
                                return;
                            }
                            return;
                        }
                        int r1 = (int) x;
                        int r102 = (int) y;
                        View view2 = this.mCapturedView;
                        if (view2 != null && r1 >= view2.getLeft() && r1 < view2.getRight() && r102 >= view2.getTop() && r102 < view2.getBottom()) {
                            r2 = 1;
                        }
                        if (r2 != 0) {
                            tryCaptureViewForDrag(pointerId3, this.mCapturedView);
                            return;
                        }
                        return;
                    }
                    if (this.mDragState == 1) {
                        this.mReleaseInProgress = true;
                        callback.onViewReleased(this.mCapturedView, 0.0f, 0.0f);
                        this.mReleaseInProgress = false;
                        if (this.mDragState == 1) {
                            setDragState(0);
                        }
                    }
                    cancel();
                    return;
                }
                if (this.mDragState == 1) {
                    if (isValidPointerForActionMove(this.mActivePointerId)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.mLastMotionX;
                        int r4 = this.mActivePointerId;
                        int r12 = (int) (x2 - fArr[r4]);
                        int r0 = (int) (y2 - this.mLastMotionY[r4]);
                        int left = this.mCapturedView.getLeft() + r12;
                        int top = this.mCapturedView.getTop() + r0;
                        int left2 = this.mCapturedView.getLeft();
                        int top2 = this.mCapturedView.getTop();
                        if (r12 != 0) {
                            left = callback.clampViewPositionHorizontal(this.mCapturedView, left);
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            this.mCapturedView.offsetLeftAndRight(left - left2);
                        }
                        if (r0 != 0) {
                            top = callback.clampViewPositionVertical(this.mCapturedView, top);
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                            this.mCapturedView.offsetTopAndBottom(top - top2);
                        }
                        if (r12 != 0 || r0 != 0) {
                            callback.onViewPositionChanged(this.mCapturedView, left, top);
                        }
                        saveLastMotion(motionEvent);
                        return;
                    }
                    return;
                }
                int pointerCount2 = motionEvent.getPointerCount();
                while (r2 < pointerCount2) {
                    int pointerId4 = motionEvent.getPointerId(r2);
                    if (isValidPointerForActionMove(pointerId4)) {
                        float x3 = motionEvent.getX(r2);
                        float y3 = motionEvent.getY(r2);
                        float f = x3 - this.mInitialMotionX[pointerId4];
                        float f2 = y3 - this.mInitialMotionY[pointerId4];
                        reportNewEdgeDrags(f, f2, pointerId4);
                        if (this.mDragState != 1) {
                            View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                            if (checkTouchSlop(findTopChildUnder2, f, f2) && tryCaptureViewForDrag(pointerId4, findTopChildUnder2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    r2++;
                }
                saveLastMotion(motionEvent);
                return;
            }
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View findTopChildUnder3 = findTopChildUnder((int) x4, (int) y4);
        saveInitialMotion(x4, y4, pointerId5);
        tryCaptureViewForDrag(pointerId5, findTopChildUnder3);
        if ((this.mInitialEdgesTouched[pointerId5] & 0) != 0) {
            callback.getClass();
        }
    }

    public final void releaseViewForPointerUp() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        float f = this.mMaxVelocity;
        velocityTracker.computeCurrentVelocity(1000, f);
        float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float abs = Math.abs(xVelocity);
        float f2 = this.mMinVelocity;
        float f3 = 0.0f;
        if (abs < f2) {
            xVelocity = 0.0f;
        } else if (abs > f) {
            if (xVelocity > 0.0f) {
                xVelocity = f;
            } else {
                xVelocity = -f;
            }
        }
        float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f2) {
            if (abs2 > f) {
                if (yVelocity <= 0.0f) {
                    f = -f;
                }
                f3 = f;
            } else {
                f3 = yVelocity;
            }
        }
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, xVelocity, f3);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void reportNewEdgeDrags(float f, float f2, int r5) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f, f2, r5, 1);
        boolean z = checkNewEdgeDrag;
        if (checkNewEdgeDrag(f2, f, r5, 4)) {
            z = (checkNewEdgeDrag ? 1 : 0) | 4;
        }
        boolean z2 = z;
        if (checkNewEdgeDrag(f, f2, r5, 2)) {
            z2 = (z ? 1 : 0) | 2;
        }
        ?? r0 = z2;
        if (checkNewEdgeDrag(f2, f, r5, 8)) {
            r0 = (z2 ? 1 : 0) | 8;
        }
        if (r0 != 0) {
            int[] r3 = this.mEdgeDragsInProgress;
            r3[r5] = r3[r5] | r0;
            this.mCallback.getClass();
        }
    }

    public final void saveInitialMotion(float f, float f2, int r13) {
        float[] fArr = this.mInitialMotionX;
        int r1 = 0;
        if (fArr == null || fArr.length <= r13) {
            int r2 = r13 + 1;
            float[] fArr2 = new float[r2];
            float[] fArr3 = new float[r2];
            float[] fArr4 = new float[r2];
            float[] fArr5 = new float[r2];
            int[] r7 = new int[r2];
            int[] r8 = new int[r2];
            int[] r22 = new int[r2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] r0 = this.mInitialEdgesTouched;
                System.arraycopy(r0, 0, r7, 0, r0.length);
                int[] r02 = this.mEdgeDragsInProgress;
                System.arraycopy(r02, 0, r8, 0, r02.length);
                int[] r03 = this.mEdgeDragsLocked;
                System.arraycopy(r03, 0, r22, 0, r03.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = r7;
            this.mEdgeDragsInProgress = r8;
            this.mEdgeDragsLocked = r22;
        }
        float[] fArr9 = this.mInitialMotionX;
        this.mLastMotionX[r13] = f;
        fArr9[r13] = f;
        float[] fArr10 = this.mInitialMotionY;
        this.mLastMotionY[r13] = f2;
        fArr10[r13] = f2;
        int[] r04 = this.mInitialEdgesTouched;
        int r11 = (int) f;
        int r12 = (int) f2;
        ViewGroup viewGroup = this.mParentView;
        int left = viewGroup.getLeft();
        int r4 = this.mEdgeSize;
        if (r11 < left + r4) {
            r1 = 1;
        }
        if (r12 < viewGroup.getTop() + r4) {
            r1 |= 4;
        }
        if (r11 > viewGroup.getRight() - r4) {
            r1 |= 2;
        }
        if (r12 > viewGroup.getBottom() - r4) {
            r1 |= 8;
        }
        r04[r13] = r1;
        this.mPointersDown |= 1 << r13;
    }

    public final void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int r1 = 0; r1 < pointerCount; r1++) {
            int pointerId = motionEvent.getPointerId(r1);
            if (isValidPointerForActionMove(pointerId)) {
                float x = motionEvent.getX(r1);
                float y = motionEvent.getY(r1);
                this.mLastMotionX[pointerId] = x;
                this.mLastMotionY[pointerId] = y;
            }
        }
    }

    public final void setDragState(int r3) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != r3) {
            this.mDragState = r3;
            this.mCallback.onViewDragStateChanged(r3);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public final boolean settleCapturedViewAt(int r4, int r5) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(r4, r5, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d2, code lost:            if (r13 != r12) goto L54;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean shouldInterceptTouchEvent(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean tryCaptureViewForDrag(int r3, View view) {
        if (view == this.mCapturedView && this.mActivePointerId == r3) {
            return true;
        }
        if (view != null && this.mCallback.tryCaptureView(r3, view)) {
            this.mActivePointerId = r3;
            captureChildView(r3, view);
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract int clampViewPositionHorizontal(View view, int r2);

        public abstract int clampViewPositionVertical(View view, int r2);

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange() {
            return 0;
        }

        public abstract void onViewDragStateChanged(int r1);

        public abstract void onViewPositionChanged(View view, int r2, int r3);

        public abstract void onViewReleased(View view, float f, float f2);

        public abstract boolean tryCaptureView(int r1, View view);

        public void onViewCaptured(int r1, View view) {
        }
    }
}
