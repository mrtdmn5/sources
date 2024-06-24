package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class ViewInfoStore {
    public final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new SimpleArrayMap<>();
    public final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray<>();

    /* loaded from: classes.dex */
    public static class InfoRecord {
        public static final Pools$SimplePool sPool = new Pools$SimplePool(20);
        public int flags;
        public RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        public RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        public static InfoRecord obtain() {
            InfoRecord infoRecord = (InfoRecord) sPool.acquire();
            if (infoRecord == null) {
                return new InfoRecord();
            }
            return infoRecord;
        }
    }

    /* loaded from: classes.dex */
    public interface ProcessCallback {
    }

    public final void addToPostLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> simpleArrayMap = this.mLayoutHolderMap;
        InfoRecord orDefault = simpleArrayMap.getOrDefault(viewHolder, null);
        if (orDefault == null) {
            orDefault = InfoRecord.obtain();
            simpleArrayMap.put(viewHolder, orDefault);
        }
        orDefault.postInfo = itemHolderInfo;
        orDefault.flags |= 8;
    }

    public final RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int r7) {
        InfoRecord valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> simpleArrayMap = this.mLayoutHolderMap;
        int indexOfKey = simpleArrayMap.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = simpleArrayMap.valueAt(indexOfKey)) != null) {
            int r3 = valueAt.flags;
            if ((r3 & r7) != 0) {
                int r32 = r3 & (~r7);
                valueAt.flags = r32;
                if (r7 == 4) {
                    itemHolderInfo = valueAt.preInfo;
                } else if (r7 == 8) {
                    itemHolderInfo = valueAt.postInfo;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((r32 & 12) == 0) {
                    simpleArrayMap.removeAt(indexOfKey);
                    valueAt.flags = 0;
                    valueAt.preInfo = null;
                    valueAt.postInfo = null;
                    InfoRecord.sPool.release(valueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public final void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord orDefault = this.mLayoutHolderMap.getOrDefault(viewHolder, null);
        if (orDefault == null) {
            return;
        }
        orDefault.flags &= -2;
    }

    public final void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray<RecyclerView.ViewHolder> longSparseArray = this.mOldChangedHolders;
        int size = longSparseArray.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (viewHolder == longSparseArray.valueAt(size)) {
                Object[] objArr = longSparseArray.mValues;
                Object obj = objArr[size];
                Object obj2 = LongSparseArray.DELETED;
                if (obj != obj2) {
                    objArr[size] = obj2;
                    longSparseArray.mGarbage = true;
                }
            } else {
                size--;
            }
        }
        InfoRecord remove = this.mLayoutHolderMap.remove(viewHolder);
        if (remove != null) {
            remove.flags = 0;
            remove.preInfo = null;
            remove.postInfo = null;
            InfoRecord.sPool.release(remove);
        }
    }
}
