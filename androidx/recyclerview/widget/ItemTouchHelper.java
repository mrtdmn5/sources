package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public final Callback mCallback;
    public ArrayList mDistances;
    public long mDragScrollStartTimeInMs;
    public float mDx;
    public float mDy;
    public GestureDetectorCompat mGestureDetector;
    public float mInitialTouchX;
    public float mInitialTouchY;
    public ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    public float mMaxSwipeVelocity;
    public RecyclerView mRecyclerView;
    public int mSelectedFlags;
    public float mSelectedStartX;
    public float mSelectedStartY;
    public int mSlop;
    public ArrayList mSwapTargets;
    public float mSwipeEscapeVelocity;
    public Rect mTmpRect;
    public VelocityTracker mVelocityTracker;
    public final ArrayList mPendingCleanup = new ArrayList();
    public final float[] mTmpPosition = new float[2];
    public RecyclerView.ViewHolder mSelected = null;
    public int mActivePointerId = -1;
    public int mActionState = 0;
    public final ArrayList mRecoverAnimations = new ArrayList();
    public final AnonymousClass1 mScrollRunnable = new AnonymousClass1();
    public View mOverdrawChild = null;
    public final AnonymousClass2 mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int findPointerIndex;
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            itemTouchHelper.mGestureDetector.mImpl.mDetector.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            RecoverAnimation recoverAnimation = null;
            if (actionMasked == 0) {
                itemTouchHelper.mActivePointerId = motionEvent.getPointerId(0);
                itemTouchHelper.mInitialTouchX = motionEvent.getX();
                itemTouchHelper.mInitialTouchY = motionEvent.getY();
                VelocityTracker velocityTracker = itemTouchHelper.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                itemTouchHelper.mVelocityTracker = VelocityTracker.obtain();
                if (itemTouchHelper.mSelected == null) {
                    ArrayList arrayList = itemTouchHelper.mRecoverAnimations;
                    if (!arrayList.isEmpty()) {
                        View findChildView = itemTouchHelper.findChildView(motionEvent);
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            RecoverAnimation recoverAnimation2 = (RecoverAnimation) arrayList.get(size);
                            if (recoverAnimation2.mViewHolder.itemView == findChildView) {
                                recoverAnimation = recoverAnimation2;
                                break;
                            }
                            size--;
                        }
                    }
                    if (recoverAnimation != null) {
                        itemTouchHelper.mInitialTouchX -= recoverAnimation.mX;
                        itemTouchHelper.mInitialTouchY -= recoverAnimation.mY;
                        RecyclerView.ViewHolder viewHolder = recoverAnimation.mViewHolder;
                        itemTouchHelper.endRecoverAnimation(viewHolder, true);
                        if (itemTouchHelper.mPendingCleanup.remove(viewHolder.itemView)) {
                            itemTouchHelper.mCallback.clearView(itemTouchHelper.mRecyclerView, viewHolder);
                        }
                        itemTouchHelper.select(viewHolder, recoverAnimation.mActionState);
                        itemTouchHelper.updateDxDy(itemTouchHelper.mSelectedFlags, 0, motionEvent);
                    }
                }
            } else if (actionMasked != 3 && actionMasked != 1) {
                int r3 = itemTouchHelper.mActivePointerId;
                if (r3 != -1 && (findPointerIndex = motionEvent.findPointerIndex(r3)) >= 0) {
                    itemTouchHelper.checkSelectForSwipe(actionMasked, findPointerIndex, motionEvent);
                }
            } else {
                itemTouchHelper.mActivePointerId = -1;
                itemTouchHelper.select(null, 0);
            }
            VelocityTracker velocityTracker2 = itemTouchHelper.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (itemTouchHelper.mSelected != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (!z) {
                return;
            }
            ItemTouchHelper.this.select(null, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void onTouchEvent(MotionEvent motionEvent) {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            itemTouchHelper.mGestureDetector.mImpl.mDetector.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = itemTouchHelper.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (itemTouchHelper.mActivePointerId == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(itemTouchHelper.mActivePointerId);
            if (findPointerIndex >= 0) {
                itemTouchHelper.checkSelectForSwipe(actionMasked, findPointerIndex, motionEvent);
            }
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.mSelected;
            if (viewHolder == null) {
                return;
            }
            int r5 = 0;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == itemTouchHelper.mActivePointerId) {
                                if (actionIndex == 0) {
                                    r5 = 1;
                                }
                                itemTouchHelper.mActivePointerId = motionEvent.getPointerId(r5);
                                itemTouchHelper.updateDxDy(itemTouchHelper.mSelectedFlags, actionIndex, motionEvent);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    VelocityTracker velocityTracker2 = itemTouchHelper.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                } else {
                    if (findPointerIndex >= 0) {
                        itemTouchHelper.updateDxDy(itemTouchHelper.mSelectedFlags, findPointerIndex, motionEvent);
                        itemTouchHelper.moveIfNecessary(viewHolder);
                        RecyclerView recyclerView = itemTouchHelper.mRecyclerView;
                        AnonymousClass1 anonymousClass1 = itemTouchHelper.mScrollRunnable;
                        recyclerView.removeCallbacks(anonymousClass1);
                        anonymousClass1.run();
                        itemTouchHelper.mRecyclerView.invalidate();
                        return;
                    }
                    return;
                }
            }
            itemTouchHelper.select(null, 0);
            itemTouchHelper.mActivePointerId = -1;
        }
    };

    /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:            if (r11 < 0) goto L23;     */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0076, code lost:            if (r11 > 0) goto L23;     */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00fa  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 300
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.AnonymousClass1.run():void");
        }
    }

    /* loaded from: classes.dex */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean mShouldReactToLongPress = true;

        public ItemTouchHelperGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            ItemTouchHelper itemTouchHelper;
            View findChildView;
            RecyclerView.ViewHolder childViewHolder;
            if (!this.mShouldReactToLongPress || (findChildView = (itemTouchHelper = ItemTouchHelper.this).findChildView(motionEvent)) == null || (childViewHolder = itemTouchHelper.mRecyclerView.getChildViewHolder(findChildView)) == null || !itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, childViewHolder)) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            int r3 = itemTouchHelper.mActivePointerId;
            if (pointerId == r3) {
                int findPointerIndex = motionEvent.findPointerIndex(r3);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                itemTouchHelper.mInitialTouchX = x;
                itemTouchHelper.mInitialTouchY = y;
                itemTouchHelper.mDy = 0.0f;
                itemTouchHelper.mDx = 0.0f;
                if (itemTouchHelper.mCallback.isLongPressDragEnabled()) {
                    itemTouchHelper.select(childViewHolder, 2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int r3, int r4);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.recyclerview.widget.ItemTouchHelper$2] */
    public ItemTouchHelper(Callback callback) {
        this.mCallback = callback;
    }

    public static boolean hitTest(View view, float f, float f2, float f3, float f4) {
        if (f >= f3 && f <= f3 + view.getWidth() && f2 >= f4 && f2 <= f4 + view.getHeight()) {
            return true;
        }
        return false;
    }

    public final void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        AnonymousClass2 anonymousClass2 = this.mOnItemTouchListener;
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.mRecyclerView.removeOnItemTouchListener(anonymousClass2);
            this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
            ArrayList arrayList = this.mRecoverAnimations;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                RecoverAnimation recoverAnimation = (RecoverAnimation) arrayList.get(0);
                recoverAnimation.mValueAnimator.cancel();
                this.mCallback.clearView(this.mRecyclerView, recoverAnimation.mViewHolder);
            }
            arrayList.clear();
            this.mOverdrawChild = null;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
            if (itemTouchHelperGestureListener != null) {
                itemTouchHelperGestureListener.mShouldReactToLongPress = false;
                this.mItemTouchHelperGestureListener = null;
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector = null;
            }
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.mSwipeEscapeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.mMaxSwipeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
            this.mRecyclerView.addItemDecoration(this);
            this.mRecyclerView.addOnItemTouchListener(anonymousClass2);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this);
            this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
            this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
        }
    }

    public final int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int r10) {
        int r0;
        if ((r10 & 12) != 0) {
            int r2 = 8;
            if (this.mDx > 0.0f) {
                r0 = 8;
            } else {
                r0 = 4;
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            Callback callback = this.mCallback;
            if (velocityTracker != null && this.mActivePointerId > -1) {
                velocityTracker.computeCurrentVelocity(1000, callback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if (xVelocity <= 0.0f) {
                    r2 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((r2 & r10) != 0 && r0 == r2 && abs >= callback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                    return r2;
                }
            }
            float swipeThreshold = callback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getWidth();
            if ((r10 & r0) != 0 && Math.abs(this.mDx) > swipeThreshold) {
                return r0;
            }
            return 0;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkSelectForSwipe(int r9, int r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.checkSelectForSwipe(int, int, android.view.MotionEvent):void");
    }

    public final int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int r10) {
        int r0;
        if ((r10 & 3) != 0) {
            int r2 = 2;
            if (this.mDy > 0.0f) {
                r0 = 2;
            } else {
                r0 = 1;
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            Callback callback = this.mCallback;
            if (velocityTracker != null && this.mActivePointerId > -1) {
                velocityTracker.computeCurrentVelocity(1000, callback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if (yVelocity <= 0.0f) {
                    r2 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((r2 & r10) != 0 && r2 == r0 && abs >= callback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                    return r2;
                }
            }
            float swipeThreshold = callback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getHeight();
            if ((r10 & r0) != 0 && Math.abs(this.mDy) > swipeThreshold) {
                return r0;
            }
            return 0;
        }
        return 0;
    }

    public final void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z) {
        RecoverAnimation recoverAnimation;
        ArrayList arrayList = this.mRecoverAnimations;
        int size = arrayList.size();
        do {
            size--;
            if (size >= 0) {
                recoverAnimation = (RecoverAnimation) arrayList.get(size);
            } else {
                return;
            }
        } while (recoverAnimation.mViewHolder != viewHolder);
        recoverAnimation.mOverridden |= z;
        if (!recoverAnimation.mEnded) {
            recoverAnimation.mValueAnimator.cancel();
        }
        arrayList.remove(size);
    }

    public final View findChildView(MotionEvent motionEvent) {
        RecoverAnimation recoverAnimation;
        View view;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            View view2 = viewHolder.itemView;
            if (hitTest(view2, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view2;
            }
        }
        ArrayList arrayList = this.mRecoverAnimations;
        int size = arrayList.size();
        do {
            size--;
            if (size >= 0) {
                recoverAnimation = (RecoverAnimation) arrayList.get(size);
                view = recoverAnimation.mViewHolder.itemView;
            } else {
                return this.mRecyclerView.findChildViewUnder(x, y);
            }
        } while (!hitTest(view, x, y, recoverAnimation.mX, recoverAnimation.mY));
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view) {
        rect.setEmpty();
    }

    public final void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
        } else {
            fArr[0] = this.mSelected.itemView.getTranslationX();
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        } else {
            fArr[1] = this.mSelected.itemView.getTranslationY();
        }
    }

    public final void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        int r19;
        int r17;
        int r18;
        if (this.mRecyclerView.isLayoutRequested() || this.mActionState != 2) {
            return;
        }
        Callback callback = this.mCallback;
        float moveThreshold = callback.getMoveThreshold(viewHolder);
        int r7 = (int) (this.mSelectedStartX + this.mDx);
        int r8 = (int) (this.mSelectedStartY + this.mDy);
        if (Math.abs(r8 - viewHolder.itemView.getTop()) < viewHolder.itemView.getHeight() * moveThreshold && Math.abs(r7 - viewHolder.itemView.getLeft()) < viewHolder.itemView.getWidth() * moveThreshold) {
            return;
        }
        ArrayList arrayList = this.mSwapTargets;
        if (arrayList == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            arrayList.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = callback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int r4 = boundingBoxMargin * 2;
        int width = viewHolder.itemView.getWidth() + round + r4;
        int height = viewHolder.itemView.getHeight() + round2 + r4;
        int r42 = (round + width) / 2;
        int r11 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int r15 = 0;
        while (r15 < childCount) {
            View childAt = layoutManager.getChildAt(r15);
            if (childAt != viewHolder.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                r17 = round;
                r18 = round2;
                if (callback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(r42 - ((childAt.getRight() + childAt.getLeft()) / 2));
                    int abs2 = Math.abs(r11 - ((childAt.getBottom() + childAt.getTop()) / 2));
                    int r14 = (abs2 * abs2) + (abs * abs);
                    int size = this.mSwapTargets.size();
                    r19 = r42;
                    int r43 = 0;
                    int r5 = 0;
                    while (r5 < size) {
                        int r20 = size;
                        if (r14 <= ((Integer) this.mDistances.get(r5)).intValue()) {
                            break;
                        }
                        r43++;
                        r5++;
                        size = r20;
                    }
                    this.mSwapTargets.add(r43, childViewHolder);
                    this.mDistances.add(r43, Integer.valueOf(r14));
                } else {
                    r19 = r42;
                }
            } else {
                r19 = r42;
                r17 = round;
                r18 = round2;
            }
            r15++;
            round = r17;
            round2 = r18;
            r42 = r19;
        }
        ArrayList arrayList2 = this.mSwapTargets;
        if (arrayList2.size() == 0) {
            return;
        }
        RecyclerView.ViewHolder chooseDropTarget = callback.chooseDropTarget(viewHolder, arrayList2, r7, r8);
        if (chooseDropTarget == null) {
            this.mSwapTargets.clear();
            this.mDistances.clear();
            return;
        }
        int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
        int absoluteAdapterPosition2 = viewHolder.getAbsoluteAdapterPosition();
        if (callback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
            this.mCallback.onMoved(this.mRecyclerView, viewHolder, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, r7, r8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewDetachedFromWindow(View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null, 0);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        if (this.mSelected != null) {
            float[] fArr = this.mTmpPosition;
            getSelectedDxDy(fArr);
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        if (this.mSelected != null) {
            float[] fArr = this.mTmpPosition;
            getSelectedDxDy(fArr);
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f2);
    }

    public final void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0094, code lost:            if (r2 > 0) goto L44;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void select(androidx.recyclerview.widget.RecyclerView.ViewHolder r25, int r26) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.select(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public final void updateDxDy(int r2, int r3, MotionEvent motionEvent) {
        float x = motionEvent.getX(r3);
        float y = motionEvent.getY(r3);
        float f = x - this.mInitialTouchX;
        this.mDx = f;
        this.mDy = y - this.mInitialTouchY;
        if ((r2 & 4) == 0) {
            this.mDx = Math.max(0.0f, f);
        }
        if ((r2 & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((r2 & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((r2 & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewAttachedToWindow() {
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new AnonymousClass1();
        private static final Interpolator sDragViewScrollCapInterpolator = new AnonymousClass2();
        private int mCachedMaxScrollSpeed = -1;

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$Callback$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        }

        /* renamed from: androidx.recyclerview.widget.ItemTouchHelper$Callback$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass2 implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        public static int convertToRelativeDirection(int r3, int r4) {
            int r42;
            int r1 = r3 & ABS_HORIZONTAL_DIR_FLAGS;
            if (r1 == 0) {
                return r3;
            }
            int r32 = r3 & (~r1);
            if (r4 == 0) {
                r42 = r1 << 2;
            } else {
                int r43 = r1 << 1;
                r32 |= (-789517) & r43;
                r42 = (r43 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return r32 | r42;
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int r0, int r1) {
            return r1 << (r0 * 8);
        }

        public static int makeMovementFlags(int r2, int r3) {
            return makeFlag(2, r2) | makeFlag(1, r3) | makeFlag(0, r3 | r2);
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int r17, int r18) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = viewHolder.itemView.getWidth() + r17;
            int height = viewHolder.itemView.getHeight() + r18;
            int left2 = r17 - viewHolder.itemView.getLeft();
            int top2 = r18 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int r7 = -1;
            for (int r8 = 0; r8 < size; r8++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(r8);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > r7) {
                    viewHolder2 = viewHolder3;
                    r7 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - r17) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > r7) {
                    viewHolder2 = viewHolder3;
                    r7 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - r18) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > r7) {
                    viewHolder2 = viewHolder3;
                    r7 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > r7) {
                    viewHolder2 = viewHolder3;
                    r7 = abs;
                }
            }
            return viewHolder2;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                float floatValue = ((Float) tag).floatValue();
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api21Impl.setElevation(view, floatValue);
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, null);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }

        public int convertToAbsoluteDirection(int r4, int r5) {
            int r52;
            int r1 = r4 & RELATIVE_DIR_FLAGS;
            if (r1 == 0) {
                return r4;
            }
            int r42 = r4 & (~r1);
            if (r5 == 0) {
                r52 = r1 >> 2;
            } else {
                int r53 = r1 >> 1;
                r42 |= (-3158065) & r53;
                r52 = (r53 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return r42 | r52;
        }

        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int movementFlags = getMovementFlags(recyclerView, viewHolder);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return convertToAbsoluteDirection(movementFlags, ViewCompat.Api17Impl.getLayoutDirection(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int r2, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                if (r2 == 8) {
                    return 200L;
                }
                return 250L;
            }
            if (r2 == 8) {
                return itemAnimator.mMoveDuration;
            }
            return itemAnimator.mRemoveDuration;
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & 16711680) != 0) {
                return true;
            }
            return false;
        }

        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0) {
                return true;
            }
            return false;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int r6, int r7, int r8, long j) {
            int maxDragScroll = getMaxDragScroll(recyclerView);
            int abs = Math.abs(r7);
            int signum = (int) Math.signum(r7);
            float f = 1.0f;
            int interpolation = (int) (sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (abs * 1.0f) / r6)) * signum * maxDragScroll);
            if (j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation2 = (int) (sDragScrollInterpolator.getInterpolation(f) * interpolation);
            if (interpolation2 == 0) {
                if (r7 > 0) {
                    return 1;
                }
                return -1;
            }
            return interpolation2;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int r10, boolean z) {
            View view = viewHolder.itemView;
            if (z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                Float valueOf = Float.valueOf(ViewCompat.Api21Impl.getElevation(view));
                int childCount = recyclerView.getChildCount();
                float f3 = 0.0f;
                for (int r1 = 0; r1 < childCount; r1++) {
                    View childAt = recyclerView.getChildAt(r1);
                    if (childAt != view) {
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        float elevation = ViewCompat.Api21Impl.getElevation(childAt);
                        if (elevation > f3) {
                            f3 = elevation;
                        }
                    }
                }
                ViewCompat.Api21Impl.setElevation(view, f3 + 1.0f);
                view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
            }
            view.setTranslationX(f);
            view.setTranslationY(f2);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int r6, boolean z) {
            View view = viewHolder.itemView;
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int r18, float f, float f2) {
            int size = list.size();
            for (int r10 = 0; r10 < size; r10++) {
                RecoverAnimation recoverAnimation = list.get(r10);
                float f3 = recoverAnimation.mStartDx;
                float f4 = recoverAnimation.mTargetX;
                RecyclerView.ViewHolder viewHolder2 = recoverAnimation.mViewHolder;
                if (f3 == f4) {
                    recoverAnimation.mX = viewHolder2.itemView.getTranslationX();
                } else {
                    recoverAnimation.mX = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f4, f3, recoverAnimation.mFraction, f3);
                }
                float f5 = recoverAnimation.mStartDy;
                float f6 = recoverAnimation.mTargetY;
                if (f5 == f6) {
                    recoverAnimation.mY = viewHolder2.itemView.getTranslationY();
                } else {
                    recoverAnimation.mY = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f6, f5, recoverAnimation.mFraction, f5);
                }
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, r18, true);
                canvas.restoreToCount(save2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int r19, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int r12 = 0; r12 < size; r12++) {
                RecoverAnimation recoverAnimation = list.get(r12);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, r19, true);
                canvas.restoreToCount(save2);
            }
            for (int r10 = size - 1; r10 >= 0; r10--) {
                RecoverAnimation recoverAnimation2 = list.get(r10);
                boolean z2 = recoverAnimation2.mEnded;
                if (z2 && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(r10);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int r4, RecyclerView.ViewHolder viewHolder2, int r6, int r7, int r8) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, r7, r8);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(r6);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(r6);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(r6);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(r6);
                }
            }
        }

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int r2);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int r2) {
        }
    }

    /* loaded from: classes.dex */
    public static class RecoverAnimation implements Animator.AnimatorListener {
        public final int mActionState;
        public float mFraction;
        public boolean mIsPendingCleanup;
        public final float mStartDx;
        public final float mStartDy;
        public final float mTargetX;
        public final float mTargetY;
        public final ValueAnimator mValueAnimator;
        public final RecyclerView.ViewHolder mViewHolder;
        public float mX;
        public float mY;
        public boolean mOverridden = false;
        public boolean mEnded = false;

        public RecoverAnimation(RecyclerView.ViewHolder viewHolder, int r3, float f, float f2, float f3, float f4) {
            this.mActionState = r3;
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.mFraction = valueAnimator.getAnimatedFraction();
                }
            });
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            this.mFraction = 0.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.mFraction = 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }
}
