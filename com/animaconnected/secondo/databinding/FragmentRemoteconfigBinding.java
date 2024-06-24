package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentRemoteconfigBinding implements ViewBinding {
    public final TextView remoteconfigText;
    private final ScrollView rootView;

    private FragmentRemoteconfigBinding(ScrollView scrollView, TextView textView) {
        this.rootView = scrollView;
        this.remoteconfigText = textView;
    }

    public static FragmentRemoteconfigBinding bind(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.remoteconfig_text, view);
        if (textView != null) {
            return new FragmentRemoteconfigBinding((ScrollView) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.remoteconfig_text)));
    }

    public static FragmentRemoteconfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRemoteconfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_remoteconfig, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }
}
