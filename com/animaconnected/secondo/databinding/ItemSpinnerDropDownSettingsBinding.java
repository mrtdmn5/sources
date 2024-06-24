package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ItemSpinnerDropDownSettingsBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView text1;

    private ItemSpinnerDropDownSettingsBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.text1 = textView2;
    }

    public static ItemSpinnerDropDownSettingsBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new ItemSpinnerDropDownSettingsBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    public static ItemSpinnerDropDownSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSpinnerDropDownSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_spinner_drop_down_settings, viewGroup, false);
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
