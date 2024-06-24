package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentTipsAndTricksBinding implements ViewBinding {
    public final LinearLayout detailLayout;
    private final LinearLayout rootView;
    public final TextView tipsAndTricksName;
    public final ViewPager tipsAndTricksPager;

    private FragmentTipsAndTricksBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ViewPager viewPager) {
        this.rootView = linearLayout;
        this.detailLayout = linearLayout2;
        this.tipsAndTricksName = textView;
        this.tipsAndTricksPager = viewPager;
    }

    public static FragmentTipsAndTricksBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int r1 = R.id.tips_and_tricks_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tips_and_tricks_name, view);
        if (textView != null) {
            r1 = R.id.tips_and_tricks_pager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(R.id.tips_and_tricks_pager, view);
            if (viewPager != null) {
                return new FragmentTipsAndTricksBinding(linearLayout, linearLayout, textView, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentTipsAndTricksBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTipsAndTricksBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tips_and_tricks, viewGroup, false);
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
