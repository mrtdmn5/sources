package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
public final class ViewBoundsCheck {
    public final BoundFlags mBoundFlags = new BoundFlags();
    public final Callback mCallback;

    /* loaded from: classes.dex */
    public static class BoundFlags {
        public int mBoundFlags = 0;
        public int mChildEnd;
        public int mChildStart;
        public int mRvEnd;
        public int mRvStart;

        public final boolean boundsMatch() {
            int r1;
            int r12;
            int r13;
            int r0 = this.mBoundFlags;
            int r2 = 2;
            if ((r0 & 7) != 0) {
                int r14 = this.mChildStart;
                int r6 = this.mRvStart;
                if (r14 > r6) {
                    r13 = 1;
                } else if (r14 == r6) {
                    r13 = 2;
                } else {
                    r13 = 4;
                }
                if (((r13 << 0) & r0) == 0) {
                    return false;
                }
            }
            if ((r0 & 112) != 0) {
                int r15 = this.mChildStart;
                int r62 = this.mRvEnd;
                if (r15 > r62) {
                    r12 = 1;
                } else if (r15 == r62) {
                    r12 = 2;
                } else {
                    r12 = 4;
                }
                if (((r12 << 4) & r0) == 0) {
                    return false;
                }
            }
            if ((r0 & 1792) != 0) {
                int r16 = this.mChildEnd;
                int r63 = this.mRvStart;
                if (r16 > r63) {
                    r1 = 1;
                } else if (r16 == r63) {
                    r1 = 2;
                } else {
                    r1 = 4;
                }
                if (((r1 << 8) & r0) == 0) {
                    return false;
                }
            }
            if ((r0 & 28672) != 0) {
                int r17 = this.mChildEnd;
                int r64 = this.mRvEnd;
                if (r17 > r64) {
                    r2 = 1;
                } else if (r17 != r64) {
                    r2 = 4;
                }
                if ((r0 & (r2 << 12)) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface Callback {
        View getChildAt(int r1);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    public ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
    }

    public final View findOneViewWithinBoundFlags(int r10, int r11, int r12, int r13) {
        int r3;
        Callback callback = this.mCallback;
        int parentStart = callback.getParentStart();
        int parentEnd = callback.getParentEnd();
        if (r11 > r10) {
            r3 = 1;
        } else {
            r3 = -1;
        }
        View view = null;
        while (r10 != r11) {
            View childAt = callback.getChildAt(r10);
            int childStart = callback.getChildStart(childAt);
            int childEnd = callback.getChildEnd(childAt);
            BoundFlags boundFlags = this.mBoundFlags;
            boundFlags.mRvStart = parentStart;
            boundFlags.mRvEnd = parentEnd;
            boundFlags.mChildStart = childStart;
            boundFlags.mChildEnd = childEnd;
            if (r12 != 0) {
                boundFlags.mBoundFlags = r12 | 0;
                if (boundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (r13 != 0) {
                boundFlags.mBoundFlags = r13 | 0;
                if (boundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            r10 += r3;
        }
        return view;
    }

    public final boolean isViewWithinBoundFlags(View view) {
        Callback callback = this.mCallback;
        int parentStart = callback.getParentStart();
        int parentEnd = callback.getParentEnd();
        int childStart = callback.getChildStart(view);
        int childEnd = callback.getChildEnd(view);
        BoundFlags boundFlags = this.mBoundFlags;
        boundFlags.mRvStart = parentStart;
        boundFlags.mRvEnd = parentEnd;
        boundFlags.mChildStart = childStart;
        boundFlags.mChildEnd = childEnd;
        boundFlags.mBoundFlags = 24579 | 0;
        return boundFlags.boundsMatch();
    }
}
