package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemAppsTextBinding implements ViewBinding {
    public final View divider;
    public final LinearLayout layoutItemAppsText;
    private final LinearLayout rootView;
    public final TextView tvInfo;
    public final TextView tvQuickAction;
    public final TextView tvTitle;

    private ItemAppsTextBinding(LinearLayout linearLayout, View view, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.divider = view;
        this.layoutItemAppsText = linearLayout2;
        this.tvInfo = textView;
        this.tvQuickAction = textView2;
        this.tvTitle = textView3;
    }

    public static ItemAppsTextBinding bind(View view) {
        int r0 = R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(R.id.divider, view);
        if (findChildViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            r0 = R.id.tvInfo;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tvInfo, view);
            if (textView != null) {
                r0 = R.id.tvQuickAction;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tvQuickAction, view);
                if (textView2 != null) {
                    r0 = R.id.tvTitle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tvTitle, view);
                    if (textView3 != null) {
                        return new ItemAppsTextBinding(linearLayout, findChildViewById, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static ItemAppsTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAppsTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_apps_text, viewGroup, false);
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
