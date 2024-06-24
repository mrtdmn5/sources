package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.ArrayList;
import java.util.WeakHashMap;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    public int currentState;

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        boolean z;
        int r4;
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        int r0 = 2;
        if (!expandableWidget.isExpanded() ? this.currentState != 1 : (r4 = this.currentState) != 0 && r4 != 2) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        if (expandableWidget.isExpanded()) {
            r0 = 1;
        }
        this.currentState = r0;
        onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
        return true;
    }

    public abstract void onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int r7) {
        final ExpandableWidget expandableWidget;
        boolean z;
        int r5;
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (!ViewCompat.Api19Impl.isLaidOut(view)) {
            ArrayList dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int r1 = 0;
            while (true) {
                if (r1 < size) {
                    View view2 = (View) dependencies.get(r1);
                    if (layoutDependsOn(view, view2)) {
                        expandableWidget = (ExpandableWidget) view2;
                        break;
                    }
                    r1++;
                } else {
                    expandableWidget = null;
                    break;
                }
            }
            if (expandableWidget != null) {
                final int r72 = 2;
                if (!expandableWidget.isExpanded() ? this.currentState != 1 : (r5 = this.currentState) != 0 && r5 != 2) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (expandableWidget.isExpanded()) {
                        r72 = 1;
                    }
                    this.currentState = r72;
                    view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public final boolean onPreDraw() {
                            View view3 = view;
                            view3.getViewTreeObserver().removeOnPreDrawListener(this);
                            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                            if (expandableBehavior.currentState == r72) {
                                ExpandableWidget expandableWidget2 = expandableWidget;
                                expandableBehavior.onExpandedStateChange((View) expandableWidget2, view3, expandableWidget2.isExpanded(), false);
                            }
                            return false;
                        }
                    });
                }
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
    }
}
