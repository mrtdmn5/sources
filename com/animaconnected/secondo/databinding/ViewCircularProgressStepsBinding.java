package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.screens.activity.ActivityView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ViewCircularProgressStepsBinding implements ViewBinding {
    private final ActivityView rootView;

    private ViewCircularProgressStepsBinding(ActivityView activityView) {
        this.rootView = activityView;
    }

    public static ViewCircularProgressStepsBinding bind(View view) {
        if (view != null) {
            return new ViewCircularProgressStepsBinding((ActivityView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ViewCircularProgressStepsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCircularProgressStepsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_circular_progress_steps, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ActivityView getRoot() {
        return this.rootView;
    }
}
