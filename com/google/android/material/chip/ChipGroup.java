package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class ChipGroup extends FlowLayout {
    public final CheckableGroup<Chip> checkableGroup;
    public int chipSpacingHorizontal;
    public int chipSpacingVertical;
    public final int defaultCheckedId;
    public OnCheckedStateChangeListener onCheckedStateChangeListener;
    public final PassThroughHierarchyChangeListener passThroughListener;

    /* renamed from: com.google.android.material.chip.ChipGroup$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements CheckableGroup.OnCheckedStateChangeListener {
        public AnonymousClass1() {
        }
    }

    /* renamed from: com.google.android.material.chip.ChipGroup$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements OnCheckedStateChangeListener {
        public AnonymousClass2() {
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams() {
            super(-2, -2);
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface OnCheckedChangeListener {
    }

    /* loaded from: classes3.dex */
    public interface OnCheckedStateChangeListener {
    }

    /* loaded from: classes3.dex */
    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;

        public PassThroughHierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    view2.setId(ViewCompat.Api17Impl.generateViewId());
                }
                CheckableGroup<Chip> checkableGroup = chipGroup.checkableGroup;
                Chip chip = (Chip) view2;
                checkableGroup.checkables.put(Integer.valueOf(chip.getId()), chip);
                if (chip.isChecked()) {
                    checkableGroup.checkInternal(chip);
                }
                chip.setInternalOnCheckedChangeListener(new CheckableGroup.AnonymousClass1());
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                CheckableGroup<Chip> checkableGroup = chipGroup.checkableGroup;
                Chip chip = (Chip) view2;
                checkableGroup.getClass();
                chip.setInternalOnCheckedChangeListener(null);
                checkableGroup.checkables.remove(Integer.valueOf(chip.getId()));
                checkableGroup.checkedIds.remove(Integer.valueOf(chip.getId()));
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.chipGroupStyle, 2132083788), attributeSet, R.attr.chipGroupStyle);
        CheckableGroup<Chip> checkableGroup = new CheckableGroup<>();
        this.checkableGroup = checkableGroup;
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.passThroughListener = passThroughHierarchyChangeListener;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, R$styleable.ChipGroup, R.attr.chipGroupStyle, 2132083788, new int[0]);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(obtainStyledAttributes.getDimensionPixelOffset(2, dimensionPixelOffset));
        setChipSpacingVertical(obtainStyledAttributes.getDimensionPixelOffset(3, dimensionPixelOffset));
        setSingleLine(obtainStyledAttributes.getBoolean(5, false));
        setSingleSelection(obtainStyledAttributes.getBoolean(6, false));
        setSelectionRequired(obtainStyledAttributes.getBoolean(4, false));
        this.defaultCheckedId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        checkableGroup.onCheckedStateChangeListener = new AnonymousClass1();
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setImportantForAccessibility(this, 1);
    }

    private int getChipCount() {
        int r1 = 0;
        for (int r0 = 0; r0 < getChildCount(); r0++) {
            if (getChildAt(r0) instanceof Chip) {
                r1++;
            }
        }
        return r1;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.checkableGroup.getSingleCheckedId();
    }

    public List<Integer> getCheckedChipIds() {
        return this.checkableGroup.getCheckedIdsSortedByChildOrder(this);
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public final boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r1 = this.defaultCheckedId;
        if (r1 != -1) {
            CheckableGroup<Chip> checkableGroup = this.checkableGroup;
            MaterialCheckable<Chip> materialCheckable = (MaterialCheckable) checkableGroup.checkables.get(Integer.valueOf(r1));
            if (materialCheckable != null && checkableGroup.checkInternal(materialCheckable)) {
                checkableGroup.onCheckedStateChanged();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int r0;
        int r2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.singleLine) {
            r0 = getChipCount();
        } else {
            r0 = -1;
        }
        int rowCount = getRowCount();
        if (this.checkableGroup.singleSelection) {
            r2 = 1;
        } else {
            r2 = 2;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(rowCount, r0, r2, false).mInfo);
    }

    public void setChipSpacing(int r1) {
        setChipSpacingHorizontal(r1);
        setChipSpacingVertical(r1);
    }

    public void setChipSpacingHorizontal(int r2) {
        if (this.chipSpacingHorizontal != r2) {
            this.chipSpacingHorizontal = r2;
            setItemSpacing(r2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int r2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(r2));
    }

    public void setChipSpacingResource(int r2) {
        setChipSpacing(getResources().getDimensionPixelOffset(r2));
    }

    public void setChipSpacingVertical(int r2) {
        if (this.chipSpacingVertical != r2) {
            this.chipSpacingVertical = r2;
            setLineSpacing(r2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int r2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(r2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int r2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new AnonymousClass2());
        }
    }

    public void setOnCheckedStateChangeListener(OnCheckedStateChangeListener onCheckedStateChangeListener) {
        this.onCheckedStateChangeListener = onCheckedStateChangeListener;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.passThroughListener.onHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.checkableGroup.selectionRequired = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int r2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int r2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        CheckableGroup<Chip> checkableGroup = this.checkableGroup;
        if (checkableGroup.singleSelection != z) {
            checkableGroup.singleSelection = z;
            boolean z2 = !checkableGroup.checkedIds.isEmpty();
            Iterator it = checkableGroup.checkables.values().iterator();
            while (it.hasNext()) {
                checkableGroup.uncheckInternal((MaterialCheckable) it.next(), false);
            }
            if (z2) {
                checkableGroup.onCheckedStateChanged();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(int r2) {
        setSingleLine(getResources().getBoolean(r2));
    }

    public void setSingleSelection(int r2) {
        setSingleSelection(getResources().getBoolean(r2));
    }
}
