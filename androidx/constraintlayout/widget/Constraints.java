package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class Constraints extends ViewGroup {
    public ConstraintSet myConstraintSet;

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet == null) {
            this.myConstraintSet = new ConstraintSet();
        }
        ConstraintSet constraintSet = this.myConstraintSet;
        constraintSet.getClass();
        int childCount = getChildCount();
        HashMap<Integer, ConstraintSet.Constraint> hashMap = constraintSet.mConstraints;
        hashMap.clear();
        for (int r3 = 0; r3 < childCount; r3++) {
            View childAt = getChildAt(r3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (constraintSet.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new ConstraintSet.Constraint());
            }
            ConstraintSet.Constraint constraint = hashMap.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                constraint.fillFromConstraints(id, layoutParams);
                if (constraintHelper instanceof Barrier) {
                    ConstraintSet.Layout layout = constraint.layout;
                    layout.mHelperType = 1;
                    Barrier barrier = (Barrier) constraintHelper;
                    layout.mBarrierDirection = barrier.getType();
                    layout.mReferenceIds = barrier.getReferencedIds();
                    layout.mBarrierMargin = barrier.getMargin();
                }
            }
            constraint.fillFromConstraints(id, layoutParams);
        }
        return this.myConstraintSet;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public final float alpha;
        public final boolean applyElevation;
        public final float elevation;
        public final float rotation;
        public final float rotationX;
        public final float rotationY;
        public final float scaleX;
        public final float scaleY;
        public final float transformPivotX;
        public final float transformPivotY;
        public final float translationX;
        public final float translationY;
        public final float translationZ;

        public LayoutParams() {
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int r1 = 0; r1 < indexCount; r1++) {
                int index = obtainStyledAttributes.getIndex(r1);
                if (index == 15) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == 28) {
                    this.elevation = obtainStyledAttributes.getFloat(index, this.elevation);
                    this.applyElevation = true;
                } else if (index == 23) {
                    this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                } else if (index == 24) {
                    this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                } else if (index == 22) {
                    this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                } else if (index == 20) {
                    this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                } else if (index == 21) {
                    this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                } else if (index == 16) {
                    this.transformPivotX = obtainStyledAttributes.getFloat(index, this.transformPivotX);
                } else if (index == 17) {
                    this.transformPivotY = obtainStyledAttributes.getFloat(index, this.transformPivotY);
                } else if (index == 18) {
                    this.translationX = obtainStyledAttributes.getFloat(index, this.translationX);
                } else if (index == 19) {
                    this.translationY = obtainStyledAttributes.getFloat(index, this.translationY);
                } else if (index == 27) {
                    this.translationZ = obtainStyledAttributes.getFloat(index, this.translationZ);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
    }
}
