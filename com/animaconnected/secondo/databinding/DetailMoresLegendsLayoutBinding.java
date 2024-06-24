package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DetailMoresLegendsLayoutBinding implements ViewBinding {
    public final LinearLayout morseLegends;
    private final View rootView;

    private DetailMoresLegendsLayoutBinding(View view, LinearLayout linearLayout) {
        this.rootView = view;
        this.morseLegends = linearLayout;
    }

    public static DetailMoresLegendsLayoutBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.morse_legends, view);
        if (linearLayout != null) {
            return new DetailMoresLegendsLayoutBinding(view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.morse_legends)));
    }

    public static DetailMoresLegendsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.detail_mores_legends_layout, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
