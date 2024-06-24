package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.internal.MaterialCheckable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class CheckableGroup<T extends MaterialCheckable<T>> {
    public final HashMap checkables = new HashMap();
    public final HashSet checkedIds = new HashSet();
    public OnCheckedStateChangeListener onCheckedStateChangeListener;
    public boolean selectionRequired;
    public boolean singleSelection;

    /* renamed from: com.google.android.material.internal.CheckableGroup$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements MaterialCheckable.OnCheckedChangeListener<MaterialCheckable<Object>> {
        public AnonymousClass1() {
        }
    }

    /* loaded from: classes3.dex */
    public interface OnCheckedStateChangeListener {
    }

    public final boolean checkInternal(MaterialCheckable<T> materialCheckable) {
        int id = materialCheckable.getId();
        HashSet hashSet = this.checkedIds;
        if (hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        MaterialCheckable<T> materialCheckable2 = (MaterialCheckable) this.checkables.get(Integer.valueOf(getSingleCheckedId()));
        if (materialCheckable2 != null) {
            uncheckInternal(materialCheckable2, false);
        }
        boolean add = hashSet.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return add;
    }

    public final ArrayList getCheckedIdsSortedByChildOrder(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.checkedIds);
        ArrayList arrayList = new ArrayList();
        for (int r2 = 0; r2 < viewGroup.getChildCount(); r2++) {
            View childAt = viewGroup.getChildAt(r2);
            if ((childAt instanceof MaterialCheckable) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int getSingleCheckedId() {
        if (this.singleSelection) {
            HashSet hashSet = this.checkedIds;
            if (!hashSet.isEmpty()) {
                return ((Integer) hashSet.iterator().next()).intValue();
            }
        }
        return -1;
    }

    public final void onCheckedStateChanged() {
        OnCheckedStateChangeListener onCheckedStateChangeListener = this.onCheckedStateChangeListener;
        if (onCheckedStateChangeListener != null) {
            new HashSet(this.checkedIds);
            ChipGroup chipGroup = ChipGroup.this;
            ChipGroup.OnCheckedStateChangeListener onCheckedStateChangeListener2 = chipGroup.onCheckedStateChangeListener;
            if (onCheckedStateChangeListener2 != null) {
                chipGroup.checkableGroup.getCheckedIdsSortedByChildOrder(chipGroup);
                ChipGroup chipGroup2 = ChipGroup.this;
                if (chipGroup2.checkableGroup.singleSelection) {
                    chipGroup2.getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    public final boolean uncheckInternal(MaterialCheckable<T> materialCheckable, boolean z) {
        int id = materialCheckable.getId();
        HashSet hashSet = this.checkedIds;
        if (!hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            materialCheckable.setChecked(true);
            return false;
        }
        boolean remove = hashSet.remove(Integer.valueOf(id));
        if (materialCheckable.isChecked()) {
            materialCheckable.setChecked(false);
        }
        return remove;
    }
}
