package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentLostWatchBinding implements ViewBinding {
    public final TextView lostWatchMapDescription1;
    public final TextView lostWatchMapDescription2;
    public final TextView lostWatchMapHeader;
    public final TextView lostWatchTimestamp;
    public final RelativeLayout mapContainerLayout;
    public final ProgressBar mapProgressBar;
    private final FrameLayout rootView;

    private FragmentLostWatchBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout, ProgressBar progressBar) {
        this.rootView = frameLayout;
        this.lostWatchMapDescription1 = textView;
        this.lostWatchMapDescription2 = textView2;
        this.lostWatchMapHeader = textView3;
        this.lostWatchTimestamp = textView4;
        this.mapContainerLayout = relativeLayout;
        this.mapProgressBar = progressBar;
    }

    public static FragmentLostWatchBinding bind(View view) {
        int r0 = R.id.lost_watch_map_description_1;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.lost_watch_map_description_1, view);
        if (textView != null) {
            r0 = R.id.lost_watch_map_description_2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.lost_watch_map_description_2, view);
            if (textView2 != null) {
                r0 = R.id.lost_watch_map_header;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.lost_watch_map_header, view);
                if (textView3 != null) {
                    r0 = R.id.lost_watch_timestamp;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.lost_watch_timestamp, view);
                    if (textView4 != null) {
                        r0 = R.id.map_container_layout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.map_container_layout, view);
                        if (relativeLayout != null) {
                            r0 = R.id.map_progress_bar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.map_progress_bar, view);
                            if (progressBar != null) {
                                return new FragmentLostWatchBinding((FrameLayout) view, textView, textView2, textView3, textView4, relativeLayout, progressBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentLostWatchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLostWatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_lost_watch, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
