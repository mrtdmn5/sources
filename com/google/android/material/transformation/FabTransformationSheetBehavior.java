package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.transformation.FabTransformationBehavior;
import com.kronaby.watch.app.R;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.slf4j.helpers.NOPMDCAdapter;

@Deprecated
/* loaded from: classes3.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public HashMap importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context context, boolean z) {
        int r3;
        if (z) {
            r3 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            r3 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.timings = MotionSpec.createFromResource(context, r3);
        fabTransformationSpec.positioning = new NOPMDCAdapter();
        return fabTransformationSpec;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void onExpandedStateChange(View view, View view2, boolean z, boolean z2) {
        boolean z3;
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            }
            for (int r3 = 0; r3 < childCount; r3++) {
                View childAt = coordinatorLayout.getChildAt(r3);
                if ((childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).mBehavior instanceof FabTransformationScrimBehavior)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (childAt != view2 && !z3) {
                    if (!z) {
                        HashMap hashMap = this.importantForAccessibilityMap;
                        if (hashMap != null && hashMap.containsKey(childAt)) {
                            int intValue = ((Integer) this.importantForAccessibilityMap.get(childAt)).intValue();
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            ViewCompat.Api16Impl.setImportantForAccessibility(childAt, intValue);
                        }
                    } else {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api16Impl.setImportantForAccessibility(childAt, 4);
                    }
                }
            }
            if (!z) {
                this.importantForAccessibilityMap = null;
            }
        }
        super.onExpandedStateChange(view, view2, z, z2);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
