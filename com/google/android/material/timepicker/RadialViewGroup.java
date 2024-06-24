package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.kronaby.watch.app.R;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class RadialViewGroup extends ConstraintLayout {
    public MaterialShapeDrawable background;
    public int radius;
    public final AnonymousClass1 updateLayoutParametersRunnable;

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void addView(View view, int r2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, r2, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            view.setId(ViewCompat.Api17Impl.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            AnonymousClass1 anonymousClass1 = this.updateLayoutParametersRunnable;
            handler.removeCallbacks(anonymousClass1);
            handler.post(anonymousClass1);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            AnonymousClass1 anonymousClass1 = this.updateLayoutParametersRunnable;
            handler.removeCallbacks(anonymousClass1);
            handler.post(anonymousClass1);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int r2) {
        this.background.setFillColor(ColorStateList.valueOf(r2));
    }

    public final void updateLayoutParams() {
        int childCount = getChildCount();
        int r1 = 1;
        for (int r3 = 0; r3 < childCount; r3++) {
            if ("skip".equals(getChildAt(r3).getTag())) {
                r1++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f = 0.0f;
        for (int r2 = 0; r2 < childCount; r2++) {
            View childAt = getChildAt(r2);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int r7 = this.radius;
                HashMap<Integer, ConstraintSet.Constraint> hashMap = constraintSet.mConstraints;
                if (!hashMap.containsKey(Integer.valueOf(id))) {
                    hashMap.put(Integer.valueOf(id), new ConstraintSet.Constraint());
                }
                ConstraintSet.Layout layout = hashMap.get(Integer.valueOf(id)).layout;
                layout.circleConstraint = R.id.circle_center;
                layout.circleRadius = r7;
                layout.circleAngle = f;
                f = (360.0f / (childCount - r1)) + f;
            }
        }
        constraintSet.applyToInternal(this);
        setConstraintSet(null);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.RadialViewGroup$1] */
    public RadialViewGroup(Context context, AttributeSet attributeSet, int r7) {
        super(context, attributeSet, r7);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.background = materialShapeDrawable;
        RelativeCornerSize relativeCornerSize = new RelativeCornerSize(0.5f);
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.drawableState.shapeAppearanceModel;
        shapeAppearanceModel.getClass();
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
        builder.topLeftCornerSize = relativeCornerSize;
        builder.topRightCornerSize = relativeCornerSize;
        builder.bottomRightCornerSize = relativeCornerSize;
        builder.bottomLeftCornerSize = relativeCornerSize;
        materialShapeDrawable.setShapeAppearanceModel(new ShapeAppearanceModel(builder));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        MaterialShapeDrawable materialShapeDrawable2 = this.background;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api16Impl.setBackground(this, materialShapeDrawable2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, r7, 0);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.updateLayoutParametersRunnable = new Runnable() { // from class: com.google.android.material.timepicker.RadialViewGroup.1
            @Override // java.lang.Runnable
            public final void run() {
                RadialViewGroup.this.updateLayoutParams();
            }
        };
        obtainStyledAttributes.recycle();
    }
}
