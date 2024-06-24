package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ChildHelper {
    public final Callback mCallback;
    public final Bucket mBucket = new Bucket();
    public final ArrayList mHiddenViews = new ArrayList();

    /* loaded from: classes.dex */
    public static class Bucket {
        public long mData = 0;
        public Bucket mNext;

        public final void clear(int r5) {
            if (r5 >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(r5 - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << r5);
        }

        public final int countOnesBefore(int r7) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (r7 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << r7) - 1));
            }
            if (r7 < 64) {
                return Long.bitCount(this.mData & ((1 << r7) - 1));
            }
            return Long.bitCount(this.mData) + bucket.countOnesBefore(r7 - 64);
        }

        public final void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public final boolean get(int r5) {
            if (r5 >= 64) {
                ensureNext();
                return this.mNext.get(r5 - 64);
            }
            if ((this.mData & (1 << r5)) != 0) {
                return true;
            }
            return false;
        }

        public final void insert(int r10, boolean z) {
            boolean z2;
            if (r10 >= 64) {
                ensureNext();
                this.mNext.insert(r10 - 64, z);
                return;
            }
            long j = this.mData;
            if ((Long.MIN_VALUE & j) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j2 = (1 << r10) - 1;
            this.mData = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                set(r10);
            } else {
                clear(r10);
            }
            if (z2 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z2);
            }
        }

        public final boolean remove(int r11) {
            boolean z;
            if (r11 >= 64) {
                ensureNext();
                return this.mNext.remove(r11 - 64);
            }
            long j = 1 << r11;
            long j2 = this.mData;
            if ((j2 & j) != 0) {
                z = true;
            } else {
                z = false;
            }
            long j3 = j2 & (~j);
            this.mData = j3;
            long j4 = j - 1;
            this.mData = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z;
        }

        public final void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public final void set(int r5) {
            if (r5 >= 64) {
                ensureNext();
                this.mNext.set(r5 - 64);
            } else {
                this.mData |= 1 << r5;
            }
        }

        public final String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* loaded from: classes.dex */
    public interface Callback {
    }

    public ChildHelper(RecyclerView.AnonymousClass5 anonymousClass5) {
        this.mCallback = anonymousClass5;
    }

    public final void addView(View view, int r4, boolean z) {
        int offset;
        Callback callback = this.mCallback;
        if (r4 < 0) {
            offset = ((RecyclerView.AnonymousClass5) callback).getChildCount();
        } else {
            offset = getOffset(r4);
        }
        this.mBucket.insert(offset, z);
        if (z) {
            hideViewInternal(view);
        }
        RecyclerView recyclerView = RecyclerView.this;
        recyclerView.addView(view, offset);
        recyclerView.dispatchChildAttached(view);
    }

    public final void attachViewToParent(View view, int r4, ViewGroup.LayoutParams layoutParams, boolean z) {
        int offset;
        Callback callback = this.mCallback;
        if (r4 < 0) {
            offset = ((RecyclerView.AnonymousClass5) callback).getChildCount();
        } else {
            offset = getOffset(r4);
        }
        this.mBucket.insert(offset, z);
        if (z) {
            hideViewInternal(view);
        }
        RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) callback;
        anonymousClass5.getClass();
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        RecyclerView recyclerView = RecyclerView.this;
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(recyclerView, sb));
            }
            childViewHolderInt.clearTmpDetachFlag();
        }
        recyclerView.attachViewToParent(view, offset, layoutParams);
    }

    public final void detachViewFromParent(int r5) {
        RecyclerView.ViewHolder childViewHolderInt;
        int offset = getOffset(r5);
        this.mBucket.remove(offset);
        RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.mCallback;
        View childAt = RecyclerView.this.getChildAt(offset);
        RecyclerView recyclerView = RecyclerView.this;
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(ChildHelper$$ExternalSyntheticOutline0.m(recyclerView, sb));
            }
            childViewHolderInt.addFlags(256);
        }
        recyclerView.detachViewFromParent(offset);
    }

    public final View getChildAt(int r2) {
        return RecyclerView.this.getChildAt(getOffset(r2));
    }

    public final int getChildCount() {
        return ((RecyclerView.AnonymousClass5) this.mCallback).getChildCount() - this.mHiddenViews.size();
    }

    public final int getOffset(int r6) {
        if (r6 < 0) {
            return -1;
        }
        int childCount = ((RecyclerView.AnonymousClass5) this.mCallback).getChildCount();
        int r2 = r6;
        while (r2 < childCount) {
            Bucket bucket = this.mBucket;
            int countOnesBefore = r6 - (r2 - bucket.countOnesBefore(r2));
            if (countOnesBefore == 0) {
                while (bucket.get(r2)) {
                    r2++;
                }
                return r2;
            }
            r2 += countOnesBefore;
        }
        return -1;
    }

    public final View getUnfilteredChildAt(int r2) {
        return RecyclerView.this.getChildAt(r2);
    }

    public final int getUnfilteredChildCount() {
        return ((RecyclerView.AnonymousClass5) this.mCallback).getChildCount();
    }

    public final void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.mCallback;
        anonymousClass5.getClass();
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
        }
    }

    public final int indexOfChild(View view) {
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild == -1) {
            return -1;
        }
        Bucket bucket = this.mBucket;
        if (bucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - bucket.countOnesBefore(indexOfChild);
    }

    public final boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public final void removeViewAt(int r4) {
        int offset = getOffset(r4);
        RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.mCallback;
        View childAt = RecyclerView.this.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        anonymousClass5.removeViewAt(offset);
    }

    public final String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public final void unhideViewInternal(View view) {
        if (this.mHiddenViews.remove(view)) {
            RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.mCallback;
            anonymousClass5.getClass();
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }
    }
}
