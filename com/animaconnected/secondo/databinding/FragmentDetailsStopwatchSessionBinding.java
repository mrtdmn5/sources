package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.widget.TopFadeRecyclerView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsStopwatchSessionBinding implements ViewBinding {
    public final TopFadeRecyclerView lapsRecyclerView;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final LinearLayout sessionHeader;
    public final TextView totalTime;

    private FragmentDetailsStopwatchSessionBinding(LinearLayout linearLayout, TopFadeRecyclerView topFadeRecyclerView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView) {
        this.rootView = linearLayout;
        this.lapsRecyclerView = topFadeRecyclerView;
        this.main = linearLayout2;
        this.sessionHeader = linearLayout3;
        this.totalTime = textView;
    }

    public static FragmentDetailsStopwatchSessionBinding bind(View view) {
        int r0 = R.id.laps_recycler_view;
        TopFadeRecyclerView topFadeRecyclerView = (TopFadeRecyclerView) ViewBindings.findChildViewById(R.id.laps_recycler_view, view);
        if (topFadeRecyclerView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            r0 = R.id.session_header;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(R.id.session_header, view);
            if (linearLayout2 != null) {
                r0 = R.id.total_time;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.total_time, view);
                if (textView != null) {
                    return new FragmentDetailsStopwatchSessionBinding(linearLayout, topFadeRecyclerView, linearLayout, linearLayout2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsStopwatchSessionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsStopwatchSessionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_stopwatch_session, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
