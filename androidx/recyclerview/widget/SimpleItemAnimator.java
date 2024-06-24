package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    public boolean mSupportsChangeAnimations = true;

    public abstract void animateAdd(RecyclerView.ViewHolder viewHolder);

    public abstract boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int r3, int r4, int r5, int r6);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int r5;
        int r6;
        int r3 = itemHolderInfo.left;
        int r4 = itemHolderInfo.top;
        if (viewHolder2.shouldIgnore()) {
            int r11 = itemHolderInfo.left;
            r6 = itemHolderInfo.top;
            r5 = r11;
        } else {
            r5 = itemHolderInfo2.left;
            r6 = itemHolderInfo2.top;
        }
        return animateChange(viewHolder, viewHolder2, r3, r4, r5, r6);
    }

    public abstract boolean animateMove(RecyclerView.ViewHolder viewHolder, int r2, int r3, int r4, int r5);

    public abstract void animateRemove(RecyclerView.ViewHolder viewHolder);
}
