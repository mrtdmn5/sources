package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemSpinnerSettingsBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView text1;

    private ItemSpinnerSettingsBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.text1 = textView2;
    }

    public static ItemSpinnerSettingsBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new ItemSpinnerSettingsBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    public static ItemSpinnerSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSpinnerSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_spinner_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }
}
