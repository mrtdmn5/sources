package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.screens.activity.activityHistory.StepsHistoryGraph;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ViewLastWeekChartStepsDetailBinding implements ViewBinding {
    private final StepsHistoryGraph rootView;

    private ViewLastWeekChartStepsDetailBinding(StepsHistoryGraph stepsHistoryGraph) {
        this.rootView = stepsHistoryGraph;
    }

    public static ViewLastWeekChartStepsDetailBinding bind(View view) {
        if (view != null) {
            return new ViewLastWeekChartStepsDetailBinding((StepsHistoryGraph) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ViewLastWeekChartStepsDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLastWeekChartStepsDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_last_week_chart_steps_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public StepsHistoryGraph getRoot() {
        return this.rootView;
    }
}
