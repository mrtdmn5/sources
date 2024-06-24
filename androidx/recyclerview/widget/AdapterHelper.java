package androidx.recyclerview.widget;

import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.watch.device.Command;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AdapterHelper implements OpReorderer.Callback {
    public final Callback mCallback;
    public final Pools$SimplePool mUpdateOpPool = new Pools$SimplePool(30);
    public final ArrayList<UpdateOp> mPendingUpdates = new ArrayList<>();
    public final ArrayList<UpdateOp> mPostponedList = new ArrayList<>();
    public int mExistingUpdateTypes = 0;
    public final OpReorderer mOpReorderer = new OpReorderer(this);

    /* loaded from: classes.dex */
    public interface Callback {
    }

    /* loaded from: classes.dex */
    public static final class UpdateOp {
        public int cmd;
        public int itemCount;
        public Object payload;
        public int positionStart;

        public UpdateOp(int r1, int r2, int r3, Object obj) {
            this.cmd = r1;
            this.positionStart = r2;
            this.itemCount = r3;
            this.payload = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int r1 = this.cmd;
            if (r1 != updateOp.cmd) {
                return false;
            }
            if (r1 == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.payload)) {
                    return false;
                }
            } else if (updateOp.payload != null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int r1 = this.cmd;
            if (r1 != 1) {
                if (r1 != 2) {
                    if (r1 != 4) {
                        if (r1 != 8) {
                            str = "??";
                        } else {
                            str = "mv";
                        }
                    } else {
                        str = "up";
                    }
                } else {
                    str = Command.FILE_REMOVE;
                }
            } else {
                str = "add";
            }
            sb.append(str);
            sb.append(",s:");
            sb.append(this.positionStart);
            sb.append("c:");
            sb.append(this.itemCount);
            sb.append(",p:");
            sb.append(this.payload);
            sb.append("]");
            return sb.toString();
        }
    }

    public AdapterHelper(RecyclerView.AnonymousClass6 anonymousClass6) {
        this.mCallback = anonymousClass6;
    }

    public final boolean canFindInPreLayout(int r9) {
        ArrayList<UpdateOp> arrayList = this.mPostponedList;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            UpdateOp updateOp = arrayList.get(r3);
            int r5 = updateOp.cmd;
            if (r5 == 8) {
                if (findPositionOffset(updateOp.itemCount, r3 + 1) == r9) {
                    return true;
                }
            } else if (r5 == 1) {
                int r52 = updateOp.positionStart;
                int r4 = updateOp.itemCount + r52;
                while (r52 < r4) {
                    if (findPositionOffset(r52, r3 + 1) == r9) {
                        return true;
                    }
                    r52++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final void consumePostponedUpdates() {
        ArrayList<UpdateOp> arrayList = this.mPostponedList;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            ((RecyclerView.AnonymousClass6) this.mCallback).dispatchUpdate(arrayList.get(r3));
        }
        recycleUpdateOpsAndClearList(arrayList);
        this.mExistingUpdateTypes = 0;
    }

    public final void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        ArrayList<UpdateOp> arrayList = this.mPendingUpdates;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            UpdateOp updateOp = arrayList.get(r3);
            int r5 = updateOp.cmd;
            Callback callback = this.mCallback;
            if (r5 != 1) {
                if (r5 != 2) {
                    if (r5 != 4) {
                        if (r5 == 8) {
                            RecyclerView.AnonymousClass6 anonymousClass6 = (RecyclerView.AnonymousClass6) callback;
                            anonymousClass6.dispatchUpdate(updateOp);
                            int r52 = updateOp.positionStart;
                            int r4 = updateOp.itemCount;
                            RecyclerView recyclerView = RecyclerView.this;
                            recyclerView.offsetPositionRecordsForMove(r52, r4);
                            recyclerView.mItemsAddedOrRemoved = true;
                        }
                    } else {
                        RecyclerView.AnonymousClass6 anonymousClass62 = (RecyclerView.AnonymousClass6) callback;
                        anonymousClass62.dispatchUpdate(updateOp);
                        int r53 = updateOp.positionStart;
                        int r8 = updateOp.itemCount;
                        Object obj = updateOp.payload;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.viewRangeUpdate(r53, r8, obj);
                        recyclerView2.mItemsChanged = true;
                    }
                } else {
                    RecyclerView.AnonymousClass6 anonymousClass63 = (RecyclerView.AnonymousClass6) callback;
                    anonymousClass63.dispatchUpdate(updateOp);
                    int r54 = updateOp.positionStart;
                    int r42 = updateOp.itemCount;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.offsetPositionRecordsForRemove(r54, r42, true);
                    recyclerView3.mItemsAddedOrRemoved = true;
                    recyclerView3.mState.mDeletedInvisibleItemCountSincePreviousLayout += r42;
                }
            } else {
                RecyclerView.AnonymousClass6 anonymousClass64 = (RecyclerView.AnonymousClass6) callback;
                anonymousClass64.dispatchUpdate(updateOp);
                int r55 = updateOp.positionStart;
                int r43 = updateOp.itemCount;
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.offsetPositionRecordsForInsert(r55, r43);
                recyclerView4.mItemsAddedOrRemoved = true;
            }
        }
        recycleUpdateOpsAndClearList(arrayList);
        this.mExistingUpdateTypes = 0;
    }

    public final void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int r3;
        Pools$SimplePool pools$SimplePool;
        boolean z;
        int r0 = updateOp.cmd;
        if (r0 != 1 && r0 != 8) {
            int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, r0);
            int r2 = updateOp.positionStart;
            int r32 = updateOp.cmd;
            if (r32 != 2) {
                if (r32 == 4) {
                    r3 = 1;
                } else {
                    throw new IllegalArgumentException("op should be remove or update." + updateOp);
                }
            } else {
                r3 = 0;
            }
            int r7 = 1;
            int r8 = 1;
            while (true) {
                int r9 = updateOp.itemCount;
                pools$SimplePool = this.mUpdateOpPool;
                if (r7 >= r9) {
                    break;
                }
                int updatePositionWithPostponed2 = updatePositionWithPostponed((r3 * r7) + updateOp.positionStart, updateOp.cmd);
                int r12 = updateOp.cmd;
                if (r12 == 2 ? updatePositionWithPostponed2 == updatePositionWithPostponed : !(r12 != 4 || updatePositionWithPostponed2 != updatePositionWithPostponed + 1)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    r8++;
                } else {
                    UpdateOp obtainUpdateOp = obtainUpdateOp(r12, updatePositionWithPostponed, r8, updateOp.payload);
                    dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, r2);
                    obtainUpdateOp.payload = null;
                    pools$SimplePool.release(obtainUpdateOp);
                    if (updateOp.cmd == 4) {
                        r2 += r8;
                    }
                    r8 = 1;
                    updatePositionWithPostponed = updatePositionWithPostponed2;
                }
                r7++;
            }
            Object obj = updateOp.payload;
            updateOp.payload = null;
            pools$SimplePool.release(updateOp);
            if (r8 > 0) {
                UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, r8, obj);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, r2);
                obtainUpdateOp2.payload = null;
                pools$SimplePool.release(obtainUpdateOp2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public final void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int r6) {
        RecyclerView.AnonymousClass6 anonymousClass6 = (RecyclerView.AnonymousClass6) this.mCallback;
        anonymousClass6.dispatchUpdate(updateOp);
        int r1 = updateOp.cmd;
        if (r1 != 2) {
            if (r1 == 4) {
                int r12 = updateOp.itemCount;
                Object obj = updateOp.payload;
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.viewRangeUpdate(r6, r12, obj);
                recyclerView.mItemsChanged = true;
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        int r5 = updateOp.itemCount;
        RecyclerView recyclerView2 = RecyclerView.this;
        recyclerView2.offsetPositionRecordsForRemove(r6, r5, true);
        recyclerView2.mItemsAddedOrRemoved = true;
        recyclerView2.mState.mDeletedInvisibleItemCountSincePreviousLayout += r5;
    }

    public final int findPositionOffset(int r7, int r8) {
        ArrayList<UpdateOp> arrayList = this.mPostponedList;
        int size = arrayList.size();
        while (r8 < size) {
            UpdateOp updateOp = arrayList.get(r8);
            int r3 = updateOp.cmd;
            if (r3 == 8) {
                int r32 = updateOp.positionStart;
                if (r32 == r7) {
                    r7 = updateOp.itemCount;
                } else {
                    if (r32 < r7) {
                        r7--;
                    }
                    if (updateOp.itemCount <= r7) {
                        r7++;
                    }
                }
            } else {
                int r4 = updateOp.positionStart;
                if (r4 > r7) {
                    continue;
                } else if (r3 == 2) {
                    int r2 = updateOp.itemCount;
                    if (r7 < r4 + r2) {
                        return -1;
                    }
                    r7 -= r2;
                } else if (r3 == 1) {
                    r7 += updateOp.itemCount;
                }
            }
            r8++;
        }
        return r7;
    }

    public final boolean hasPendingUpdates() {
        if (this.mPendingUpdates.size() > 0) {
            return true;
        }
        return false;
    }

    public final UpdateOp obtainUpdateOp(int r2, int r3, int r4, Object obj) {
        UpdateOp updateOp = (UpdateOp) this.mUpdateOpPool.acquire();
        if (updateOp == null) {
            return new UpdateOp(r2, r3, r4, obj);
        }
        updateOp.cmd = r2;
        updateOp.positionStart = r3;
        updateOp.itemCount = r4;
        updateOp.payload = obj;
        return updateOp;
    }

    public final void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int r0 = updateOp.cmd;
        Callback callback = this.mCallback;
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 4) {
                    if (r0 == 8) {
                        int r02 = updateOp.positionStart;
                        int r5 = updateOp.itemCount;
                        RecyclerView recyclerView = RecyclerView.this;
                        recyclerView.offsetPositionRecordsForMove(r02, r5);
                        recyclerView.mItemsAddedOrRemoved = true;
                        return;
                    }
                    throw new IllegalArgumentException("Unknown update op type for " + updateOp);
                }
                int r03 = updateOp.positionStart;
                int r3 = updateOp.itemCount;
                Object obj = updateOp.payload;
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.viewRangeUpdate(r03, r3, obj);
                recyclerView2.mItemsChanged = true;
                return;
            }
            int r04 = updateOp.positionStart;
            int r52 = updateOp.itemCount;
            RecyclerView recyclerView3 = RecyclerView.this;
            recyclerView3.offsetPositionRecordsForRemove(r04, r52, false);
            recyclerView3.mItemsAddedOrRemoved = true;
            return;
        }
        int r05 = updateOp.positionStart;
        int r53 = updateOp.itemCount;
        RecyclerView recyclerView4 = RecyclerView.this;
        recyclerView4.offsetPositionRecordsForInsert(r05, r53);
        recyclerView4.mItemsAddedOrRemoved = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void preProcess() {
        /*
            Method dump skipped, instructions count: 754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AdapterHelper.preProcess():void");
    }

    public final void recycleUpdateOpsAndClearList(ArrayList arrayList) {
        int size = arrayList.size();
        for (int r1 = 0; r1 < size; r1++) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(r1);
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
        arrayList.clear();
    }

    public final int updatePositionWithPostponed(int r10, int r11) {
        int r8;
        int r7;
        ArrayList<UpdateOp> arrayList = this.mPostponedList;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = arrayList.get(size);
            int r5 = updateOp.cmd;
            if (r5 == 8) {
                int r3 = updateOp.positionStart;
                int r52 = updateOp.itemCount;
                if (r3 < r52) {
                    r7 = r3;
                    r8 = r52;
                } else {
                    r8 = r3;
                    r7 = r52;
                }
                if (r10 >= r7 && r10 <= r8) {
                    if (r7 == r3) {
                        if (r11 == 1) {
                            updateOp.itemCount = r52 + 1;
                        } else if (r11 == 2) {
                            updateOp.itemCount = r52 - 1;
                        }
                        r10++;
                    } else {
                        if (r11 == 1) {
                            updateOp.positionStart = r3 + 1;
                        } else if (r11 == 2) {
                            updateOp.positionStart = r3 - 1;
                        }
                        r10--;
                    }
                } else if (r10 < r3) {
                    if (r11 == 1) {
                        updateOp.positionStart = r3 + 1;
                        updateOp.itemCount = r52 + 1;
                    } else if (r11 == 2) {
                        updateOp.positionStart = r3 - 1;
                        updateOp.itemCount = r52 - 1;
                    }
                }
            } else {
                int r32 = updateOp.positionStart;
                if (r32 <= r10) {
                    if (r5 == 1) {
                        r10 -= updateOp.itemCount;
                    } else if (r5 == 2) {
                        r10 += updateOp.itemCount;
                    }
                } else if (r11 == 1) {
                    updateOp.positionStart = r32 + 1;
                } else if (r11 == 2) {
                    updateOp.positionStart = r32 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = arrayList.get(size2);
            int r2 = updateOp2.cmd;
            Pools$SimplePool pools$SimplePool = this.mUpdateOpPool;
            if (r2 == 8) {
                int r22 = updateOp2.itemCount;
                if (r22 == updateOp2.positionStart || r22 < 0) {
                    arrayList.remove(size2);
                    updateOp2.payload = null;
                    pools$SimplePool.release(updateOp2);
                }
            } else if (updateOp2.itemCount <= 0) {
                arrayList.remove(size2);
                updateOp2.payload = null;
                pools$SimplePool.release(updateOp2);
            }
        }
        return r10;
    }
}
