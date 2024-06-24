package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat$Api17Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public HashSet checkedIds;
    public Integer[] childOrder;
    public final AnonymousClass1 childOrderComparator;
    public final int defaultCheckId;
    public final LinkedHashSet<OnButtonCheckedListener> onButtonCheckedListeners;
    public final ArrayList originalCornerData;
    public final PressedStateTracker pressedStateTracker;
    public boolean selectionRequired;
    public boolean singleSelection;
    public boolean skipCheckedStateTracker;

    /* loaded from: classes3.dex */
    public static class CornerData {
        public static final AbsoluteCornerSize noCorner = new AbsoluteCornerSize(0.0f);
        public final CornerSize bottomLeft;
        public final CornerSize bottomRight;
        public final CornerSize topLeft;
        public final CornerSize topRight;

        public CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }
    }

    /* loaded from: classes3.dex */
    public interface OnButtonCheckedListener {
        void onButtonChecked();
    }

    /* loaded from: classes3.dex */
    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        public PressedStateTracker() {
        }
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [com.google.android.material.button.MaterialButtonToggleGroup$1] */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.materialButtonToggleGroupStyle, 2132083802), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.originalCornerData = new ArrayList();
        this.pressedStateTracker = new PressedStateTracker();
        this.onButtonCheckedListeners = new LinkedHashSet<>();
        this.childOrderComparator = new Comparator<MaterialButton>() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.1
            @Override // java.util.Comparator
            public final int compare(MaterialButton materialButton, MaterialButton materialButton2) {
                MaterialButton materialButton3 = materialButton;
                MaterialButton materialButton4 = materialButton2;
                int compareTo = Boolean.valueOf(materialButton3.isChecked()).compareTo(Boolean.valueOf(materialButton4.isChecked()));
                if (compareTo == 0) {
                    int compareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
                    if (compareTo2 == 0) {
                        MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                        return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton3)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton4)));
                    }
                    return compareTo2;
                }
                return compareTo;
            }
        };
        this.skipCheckedStateTracker = false;
        this.checkedIds = new HashSet();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, R.attr.materialButtonToggleGroupStyle, 2132083802, new int[0]);
        setSingleSelection(obtainStyledAttributes.getBoolean(2, false));
        this.defaultCheckId = obtainStyledAttributes.getResourceId(0, -1);
        this.selectionRequired = obtainStyledAttributes.getBoolean(1, false);
        setChildrenDrawingOrderEnabled(true);
        obtainStyledAttributes.recycle();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setImportantForAccessibility(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            if (isChildVisible(r1)) {
                return r1;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int r1 = 0;
        for (int r0 = 0; r0 < getChildCount(); r0++) {
            if ((getChildAt(r0) instanceof MaterialButton) && isChildVisible(r0)) {
                r1++;
            }
        }
        return r1;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            materialButton.setId(ViewCompat.Api17Impl.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int r6, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MaterialButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, r6, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        checkInternal(materialButton.getId(), materialButton.isChecked());
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.originalCornerData.add(new CornerData(shapeAppearanceModel.topLeftCornerSize, shapeAppearanceModel.bottomLeftCornerSize, shapeAppearanceModel.topRightCornerSize, shapeAppearanceModel.bottomRightCornerSize));
        ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                int r3;
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat.mInfo);
                int r0 = MaterialButtonToggleGroup.$r8$clinit;
                MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                materialButtonToggleGroup.getClass();
                if (view2 instanceof MaterialButton) {
                    r3 = 0;
                    for (int r1 = 0; r1 < materialButtonToggleGroup.getChildCount(); r1++) {
                        if (materialButtonToggleGroup.getChildAt(r1) == view2) {
                            break;
                        }
                        if ((materialButtonToggleGroup.getChildAt(r1) instanceof MaterialButton) && materialButtonToggleGroup.isChildVisible(r1)) {
                            r3++;
                        }
                    }
                }
                r3 = -1;
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, r3, 1, ((MaterialButton) view2).isChecked()));
            }
        });
    }

    public final void adjustChildMarginsAndUpdateLayout() {
        LinearLayout.LayoutParams layoutParams;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int r2 = firstVisibleChildIndex + 1; r2 < getChildCount(); r2++) {
            MaterialButton childButton = getChildButton(r2);
            int min = Math.min(childButton.getStrokeWidth(), getChildButton(r2 - 1).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams2 = childButton.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            }
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat$Api17Impl.setMarginEnd(layoutParams, 0);
                MarginLayoutParamsCompat$Api17Impl.setMarginStart(layoutParams, -min);
                layoutParams.topMargin = 0;
            } else {
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = -min;
                MarginLayoutParamsCompat$Api17Impl.setMarginStart(layoutParams, 0);
            }
            childButton.setLayoutParams(layoutParams);
        }
        if (getChildCount() != 0 && firstVisibleChildIndex != -1) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) getChildButton(firstVisibleChildIndex).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams3.topMargin = 0;
                layoutParams3.bottomMargin = 0;
            } else {
                MarginLayoutParamsCompat$Api17Impl.setMarginEnd(layoutParams3, 0);
                MarginLayoutParamsCompat$Api17Impl.setMarginStart(layoutParams3, 0);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
        }
    }

    public final void checkInternal(int r3, boolean z) {
        if (r3 == -1) {
            Log.e("MaterialButtonToggleGroup", "Button ID is not valid: " + r3);
            return;
        }
        HashSet hashSet = new HashSet(this.checkedIds);
        if (z && !hashSet.contains(Integer.valueOf(r3))) {
            if (this.singleSelection && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(r3));
        } else if (!z && hashSet.contains(Integer.valueOf(r3))) {
            if (!this.selectionRequired || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(r3));
            }
        } else {
            return;
        }
        updateCheckedIds(hashSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int r3 = 0; r3 < childCount; r3++) {
            treeMap.put(getChildButton(r3), Integer.valueOf(r3));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public int getCheckedButtonId() {
        if (this.singleSelection && !this.checkedIds.isEmpty()) {
            return ((Integer) this.checkedIds.iterator().next()).intValue();
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int r1 = 0; r1 < getChildCount(); r1++) {
            int id = getChildButton(r1).getId();
            if (this.checkedIds.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    public final MaterialButton getChildButton(int r1) {
        return (MaterialButton) getChildAt(r1);
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r2, int r3) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && r3 < numArr.length) {
            return numArr[r3].intValue();
        }
        Log.w("MaterialButtonToggleGroup", "Child order wasn't updated");
        return r3;
    }

    public final boolean isChildVisible(int r2) {
        if (getChildAt(r2).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r1 = this.defaultCheckId;
        if (r1 != -1) {
            updateCheckedIds(Collections.singleton(Integer.valueOf(r1)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int r1;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (this.singleSelection) {
            r1 = 1;
        } else {
            r1 = 2;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, visibleButtonCount, r1, false).mInfo);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(r1, r2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalCornerData.remove(indexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void setSelectionRequired(boolean z) {
        this.selectionRequired = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            updateCheckedIds(new HashSet());
        }
    }

    public final void updateCheckedIds(Set<Integer> set) {
        HashSet hashSet = this.checkedIds;
        this.checkedIds = new HashSet(set);
        for (int r2 = 0; r2 < getChildCount(); r2++) {
            int id = getChildButton(r2).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.skipCheckedStateTracker = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.skipCheckedStateTracker = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator<OnButtonCheckedListener> it = this.onButtonCheckedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onButtonChecked();
                }
            }
        }
        invalidate();
    }

    public final void updateChildShapes() {
        boolean z;
        CornerData cornerData;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int r4 = 0; r4 < childCount; r4++) {
            MaterialButton childButton = getChildButton(r4);
            if (childButton.getVisibility() != 8) {
                ShapeAppearanceModel shapeAppearanceModel = childButton.getShapeAppearanceModel();
                shapeAppearanceModel.getClass();
                ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
                CornerData cornerData2 = (CornerData) this.originalCornerData.get(r4);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    if (getOrientation() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    AbsoluteCornerSize absoluteCornerSize = CornerData.noCorner;
                    if (r4 == firstVisibleChildIndex) {
                        if (z) {
                            if (ViewUtils.isLayoutRtl(this)) {
                                cornerData = new CornerData(absoluteCornerSize, absoluteCornerSize, cornerData2.topRight, cornerData2.bottomRight);
                            } else {
                                cornerData = new CornerData(cornerData2.topLeft, cornerData2.bottomLeft, absoluteCornerSize, absoluteCornerSize);
                            }
                        } else {
                            cornerData = new CornerData(cornerData2.topLeft, absoluteCornerSize, cornerData2.topRight, absoluteCornerSize);
                        }
                    } else if (r4 == lastVisibleChildIndex) {
                        if (z) {
                            if (ViewUtils.isLayoutRtl(this)) {
                                cornerData = new CornerData(cornerData2.topLeft, cornerData2.bottomLeft, absoluteCornerSize, absoluteCornerSize);
                            } else {
                                cornerData = new CornerData(absoluteCornerSize, absoluteCornerSize, cornerData2.topRight, cornerData2.bottomRight);
                            }
                        } else {
                            cornerData = new CornerData(absoluteCornerSize, cornerData2.bottomLeft, absoluteCornerSize, cornerData2.bottomRight);
                        }
                    } else {
                        cornerData2 = null;
                    }
                    cornerData2 = cornerData;
                }
                if (cornerData2 == null) {
                    builder.setTopLeftCornerSize(0.0f);
                    builder.setTopRightCornerSize(0.0f);
                    builder.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
                    builder.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
                } else {
                    builder.topLeftCornerSize = cornerData2.topLeft;
                    builder.bottomLeftCornerSize = cornerData2.bottomLeft;
                    builder.topRightCornerSize = cornerData2.topRight;
                    builder.bottomRightCornerSize = cornerData2.bottomRight;
                }
                childButton.setShapeAppearanceModel(new ShapeAppearanceModel(builder));
            }
        }
    }

    public void setSingleSelection(int r2) {
        setSingleSelection(getResources().getBoolean(r2));
    }
}
