package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {
    public boolean mApplyElevationOnAttach;
    public boolean mApplyVisibilityOnAttach;

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r1 = 0; r1 < indexCount; r1++) {
                int index = obtainStyledAttributes.getIndex(r1);
                if (index == 6) {
                    this.mApplyVisibilityOnAttach = true;
                } else if (index == 13) {
                    this.mApplyElevationOnAttach = true;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.mApplyVisibilityOnAttach || this.mApplyElevationOnAttach) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int r3 = 0; r3 < this.mCount; r3++) {
                View view = constraintLayout.mChildrenByIds.get(this.mIds[r3]);
                if (view != null) {
                    if (this.mApplyVisibilityOnAttach) {
                        view.setVisibility(visibility);
                    }
                    if (this.mApplyElevationOnAttach && elevation > 0.0f) {
                        view.setTranslationZ(view.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        applyLayoutFeatures$1();
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        applyLayoutFeatures$1();
    }
}
