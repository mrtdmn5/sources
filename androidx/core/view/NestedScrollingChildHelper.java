package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class NestedScrollingChildHelper {
    public boolean mIsNestedScrollingEnabled;
    public ViewParent mNestedScrollingParentNonTouch;
    public ViewParent mNestedScrollingParentTouch;
    public int[] mTempNestedScrollConsumed;
    public final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent nestedScrollingParentForType;
        if (!this.mIsNestedScrollingEnabled || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        try {
            return ViewParentCompat$Api21Impl.onNestedFling(nestedScrollingParentForType, this.mView, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public final boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent nestedScrollingParentForType;
        if (!this.mIsNestedScrollingEnabled || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        try {
            return ViewParentCompat$Api21Impl.onNestedPreFling(nestedScrollingParentForType, this.mView, f, f2);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    public final boolean dispatchNestedPreScroll(int r16, int r17, int[] r18, int[] r19, int r20) {
        ViewParent nestedScrollingParentForType;
        int r12;
        int r13;
        int[] r14;
        if (!this.mIsNestedScrollingEnabled || (nestedScrollingParentForType = getNestedScrollingParentForType(r20)) == null) {
            return false;
        }
        if (r16 == 0 && r17 == 0) {
            if (r19 == null) {
                return false;
            }
            r19[0] = 0;
            r19[1] = 0;
            return false;
        }
        View view = this.mView;
        if (r19 != null) {
            view.getLocationInWindow(r19);
            r12 = r19[0];
            r13 = r19[1];
        } else {
            r12 = 0;
            r13 = 0;
        }
        if (r18 == null) {
            if (this.mTempNestedScrollConsumed == null) {
                this.mTempNestedScrollConsumed = new int[2];
            }
            r14 = this.mTempNestedScrollConsumed;
        } else {
            r14 = r18;
        }
        r14[0] = 0;
        r14[1] = 0;
        View view2 = this.mView;
        if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) nestedScrollingParentForType).onNestedPreScroll(view2, r16, r17, r14, r20);
        } else if (r20 == 0) {
            try {
                ViewParentCompat$Api21Impl.onNestedPreScroll(nestedScrollingParentForType, view2, r16, r17, r14);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedPreScroll", e);
            }
        }
        if (r19 != null) {
            view.getLocationInWindow(r19);
            r19[0] = r19[0] - r12;
            r19[1] = r19[1] - r13;
        }
        if (r14[0] == 0 && r14[1] == 0) {
            return false;
        }
        return true;
    }

    public final boolean dispatchNestedScrollInternal(int r17, int r18, int r19, int r20, int[] r21, int r22, int[] r23) {
        ViewParent nestedScrollingParentForType;
        int r14;
        int r15;
        int[] r9;
        if (!this.mIsNestedScrollingEnabled || (nestedScrollingParentForType = getNestedScrollingParentForType(r22)) == null) {
            return false;
        }
        if (r17 == 0 && r18 == 0 && r19 == 0 && r20 == 0) {
            if (r21 != null) {
                r21[0] = 0;
                r21[1] = 0;
            }
            return false;
        }
        View view = this.mView;
        if (r21 != null) {
            view.getLocationInWindow(r21);
            r14 = r21[0];
            r15 = r21[1];
        } else {
            r14 = 0;
            r15 = 0;
        }
        if (r23 == null) {
            if (this.mTempNestedScrollConsumed == null) {
                this.mTempNestedScrollConsumed = new int[2];
            }
            int[] r2 = this.mTempNestedScrollConsumed;
            r2[0] = 0;
            r2[1] = 0;
            r9 = r2;
        } else {
            r9 = r23;
        }
        View view2 = this.mView;
        if (nestedScrollingParentForType instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) nestedScrollingParentForType).onNestedScroll(view2, r17, r18, r19, r20, r22, r9);
        } else {
            r9[0] = r9[0] + r19;
            r9[1] = r9[1] + r20;
            if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onNestedScroll(view2, r17, r18, r19, r20, r22);
            } else if (r22 == 0) {
                try {
                    ViewParentCompat$Api21Impl.onNestedScroll(nestedScrollingParentForType, view2, r17, r18, r19, r20);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedScroll", e);
                }
            }
        }
        if (r21 != null) {
            view.getLocationInWindow(r21);
            r21[0] = r21[0] - r14;
            r21[1] = r21[1] - r15;
        }
        return true;
    }

    public final ViewParent getNestedScrollingParentForType(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                return null;
            }
            return this.mNestedScrollingParentNonTouch;
        }
        return this.mNestedScrollingParentTouch;
    }

    public final boolean startNestedScroll(int r12, int r13) {
        boolean z;
        boolean onStartNestedScroll;
        if (getNestedScrollingParentForType(r13) != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.mIsNestedScrollingEnabled) {
            View view = this.mView;
            View view2 = view;
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                boolean z2 = parent instanceof NestedScrollingParent2;
                if (z2) {
                    onStartNestedScroll = ((NestedScrollingParent2) parent).onStartNestedScroll(view2, view, r12, r13);
                } else {
                    if (r13 == 0) {
                        try {
                            onStartNestedScroll = ViewParentCompat$Api21Impl.onStartNestedScroll(parent, view2, view, r12);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                        }
                    }
                    onStartNestedScroll = false;
                }
                if (onStartNestedScroll) {
                    if (r13 != 0) {
                        if (r13 == 1) {
                            this.mNestedScrollingParentNonTouch = parent;
                        }
                    } else {
                        this.mNestedScrollingParentTouch = parent;
                    }
                    if (z2) {
                        ((NestedScrollingParent2) parent).onNestedScrollAccepted(view2, view, r12, r13);
                    } else if (r13 == 0) {
                        try {
                            ViewParentCompat$Api21Impl.onNestedScrollAccepted(parent, view2, view, r12);
                        } catch (AbstractMethodError e2) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
        }
        return false;
    }

    public final void stopNestedScroll(int r5) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(r5);
        if (nestedScrollingParentForType != null) {
            boolean z = nestedScrollingParentForType instanceof NestedScrollingParent2;
            View view = this.mView;
            if (z) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onStopNestedScroll(view, r5);
            } else if (r5 == 0) {
                try {
                    ViewParentCompat$Api21Impl.onStopNestedScroll(nestedScrollingParentForType, view);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (r5 != 0) {
                if (r5 == 1) {
                    this.mNestedScrollingParentNonTouch = null;
                    return;
                }
                return;
            }
            this.mNestedScrollingParentTouch = null;
        }
    }
}
