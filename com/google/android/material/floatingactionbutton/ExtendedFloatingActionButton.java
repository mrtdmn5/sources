package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new Property<View, Float>() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.4
            @Override // android.util.Property
            public final Float get(View view) {
                return Float.valueOf(view.getLayoutParams().width);
            }

            @Override // android.util.Property
            public final void set(View view, Float f) {
                View view2 = view;
                view2.getLayoutParams().width = f.intValue();
                view2.requestLayout();
            }
        };
        new Property<View, Float>() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5
            @Override // android.util.Property
            public final Float get(View view) {
                return Float.valueOf(view.getLayoutParams().height);
            }

            @Override // android.util.Property
            public final void set(View view, Float f) {
                View view2 = view;
                view2.getLayoutParams().height = f.intValue();
                view2.requestLayout();
            }
        };
        new Property<View, Float>() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.6
            @Override // android.util.Property
            public final Float get(View view) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                return Float.valueOf(ViewCompat.Api17Impl.getPaddingStart(view));
            }

            @Override // android.util.Property
            public final void set(View view, Float f) {
                View view2 = view;
                int intValue = f.intValue();
                int paddingTop = view2.getPaddingTop();
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api17Impl.setPaddingRelative(view2, intValue, paddingTop, ViewCompat.Api17Impl.getPaddingEnd(view2), view2.getPaddingBottom());
            }
        };
        new Property<View, Float>() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.7
            @Override // android.util.Property
            public final Float get(View view) {
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                return Float.valueOf(ViewCompat.Api17Impl.getPaddingEnd(view));
            }

            @Override // android.util.Property
            public final void set(View view, Float f) {
                View view2 = view;
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api17Impl.setPaddingRelative(view2, ViewCompat.Api17Impl.getPaddingStart(view2), view2.getPaddingTop(), f.intValue(), view2.getPaddingBottom());
            }
        };
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return 0;
    }

    public MotionSpec getExtendMotionSpec() {
        throw null;
    }

    public MotionSpec getHideMotionSpec() {
        throw null;
    }

    public MotionSpec getShowMotionSpec() {
        throw null;
    }

    public MotionSpec getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setExtendMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setExtendMotionSpecResource(int r2) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public void setExtended(boolean z) {
        if (!z) {
        } else {
            throw null;
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setHideMotionSpecResource(int r2) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super.setPaddingRelative(r1, r2, r3, r4);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setShowMotionSpecResource(int r2) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public void setShrinkMotionSpec(MotionSpec motionSpec) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int r2) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int r1) {
        super.setTextColor(r1);
        getTextColors();
    }

    /* loaded from: classes3.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public final boolean autoHideEnabled;
        public final boolean autoShrinkEnabled;
        public Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ boolean getInsetDodgeRect(View view) {
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean z;
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    z = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior;
                } else {
                    z = false;
                }
                if (z) {
                    updateFabVisibilityForBottomSheet(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int r10) {
            boolean z;
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ArrayList dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int r3 = 0; r3 < size; r3++) {
                View view2 = (View) dependencies.get(r3);
                if (view2 instanceof AppBarLayout) {
                    updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
                } else {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                        z = ((CoordinatorLayout.LayoutParams) layoutParams).mBehavior instanceof BottomSheetBehavior;
                    } else {
                        z = false;
                    }
                    if (z) {
                        updateFabVisibilityForBottomSheet(view2, extendedFloatingActionButton);
                    }
                }
            }
            coordinatorLayout.onLayoutChild(r10, extendedFloatingActionButton);
            return true;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            boolean z2 = this.autoHideEnabled;
            boolean z3 = this.autoShrinkEnabled;
            if ((!z2 && !z3) || layoutParams.mAnchorId != appBarLayout.getId()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (z3) {
                    int r4 = ExtendedFloatingActionButton.$r8$clinit;
                    throw null;
                }
                int r42 = ExtendedFloatingActionButton.$r8$clinit;
                throw null;
            }
            if (z3) {
                int r43 = ExtendedFloatingActionButton.$r8$clinit;
                throw null;
            }
            int r44 = ExtendedFloatingActionButton.$r8$clinit;
            throw null;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            boolean z2 = this.autoHideEnabled;
            boolean z3 = this.autoShrinkEnabled;
            if ((!z2 && !z3) || layoutParams.mAnchorId != view.getId()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                if (z3) {
                    int r5 = ExtendedFloatingActionButton.$r8$clinit;
                    throw null;
                }
                int r52 = ExtendedFloatingActionButton.$r8$clinit;
                throw null;
            }
            if (z3) {
                int r53 = ExtendedFloatingActionButton.$r8$clinit;
                throw null;
            }
            int r54 = ExtendedFloatingActionButton.$r8$clinit;
            throw null;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(0, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        getTextColors();
    }

    public void setAnimateShowBeforeLayout(boolean z) {
    }
}
